/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
package dev.amatos.restcountries.service.v2;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import dev.amatos.restcountries.domain.BaseCountry;
import dev.amatos.restcountries.domain.ICountryRestSymbols;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CountryServiceBaseV2 {

    private static final Logger logger = LogManager.getLogger(CountryServiceBaseV2.class);

    protected <T extends BaseCountry> T getByAlpha(String alpha, List<T> countries) {
        int alphaLength = alpha.length();
        for (T country : countries) {
            if (alphaLength == 2) {
                if (country.getAlpha2Code().equalsIgnoreCase(alpha)) {
                    return country;
                }
            } else if (alphaLength == 3 && country.getAlpha3Code().equalsIgnoreCase(alpha)) {
                return country;
            }
        }
        return null;
    }

    protected List<? extends BaseCountry> getByCodeList(String codeList, List<? extends BaseCountry> countries) {
        List<BaseCountry> result = new ArrayList<>();
        if (codeList == null) return result;

        String[] codes = codeList.split(ICountryRestSymbols.COLON);
        for (String code : codes) {
            BaseCountry country = getByAlpha(code, countries);
            if (!result.contains(country))
                result.add(country);
        }
        return result;
    }

    protected List<? extends BaseCountry> getByName(String name, boolean fullText, List<? extends BaseCountry> countries) {
        if (fullText) {
            return fulltextSearch(name, countries);
        } else {
            return substringSearch(name, countries);
        }
    }

    protected List<? extends BaseCountry> getByCallingCode(String callingCode, List<? extends BaseCountry> countries) {
        List<BaseCountry> result = new ArrayList<>();
        for (BaseCountry country : countries) {
            for (String c : country.getCallingCodes()) {
                if (c.equals(callingCode))
                    result.add(country);
            }
        }
        return result;
    }

    protected List<? extends BaseCountry> getByCapital(String capital, List<? extends BaseCountry> countries) {
        List<BaseCountry> result = new ArrayList<>();
        for (BaseCountry country : countries) {
            if (normalize(country.getCapital().toLowerCase()).contains(normalize(capital.toLowerCase()))) {
                result.add(country);
            }
        }
        return result;
    }

    protected List<? extends BaseCountry> getByRegion(String region, List<? extends BaseCountry> countries) {
        List<BaseCountry> result = new ArrayList<>();
        for (BaseCountry country : countries) {
            if (country.getRegion().equalsIgnoreCase(region)) {
                result.add(country);
            }
        }
        return result;
    }

    protected List<? extends BaseCountry> getBySubregion(String subregion, List<? extends BaseCountry> countries) {
        List<BaseCountry> result = new ArrayList<>();
        for (BaseCountry country : countries) {
            if (country.getSubregion().equalsIgnoreCase(subregion)) {
                result.add(country);
            }
        }
        return result;
    }

    private List<? extends BaseCountry> fulltextSearch(String name, List<? extends BaseCountry> countries) {
        // Using 2 different 'for' loops to give priority to 'name' matches over alternative spellings
        List<BaseCountry> result = new ArrayList<>();
        for (BaseCountry country : countries) {
            if (normalize(country.getName().toLowerCase()).equals(normalize(name.toLowerCase()))) {
                result.add(country);
            }
        }
        for (BaseCountry country : countries) {
            for (String alternative : country.getAltSpellings()) {
                if (normalize(alternative.toLowerCase()).equals(normalize(name.toLowerCase()))
                        && !result.contains(country)) {
                    result.add(country);
                }
            }
        }
        return result;
    }

    private List<? extends BaseCountry> substringSearch(String name, List<? extends BaseCountry> countries) {
        // Using 2 different 'for' loops to give priority to 'name' matches over alternative spellings
        List<BaseCountry> result = new ArrayList<>();
        for (BaseCountry country : countries) {
            if (normalize(country.getName().toLowerCase()).contains(normalize(name.toLowerCase()))) {
                result.add(country);
            }
        }
        for (BaseCountry country : countries) {
            for (String alternative : country.getAltSpellings()) {
                if (normalize(alternative.toLowerCase()).contains(normalize(name.toLowerCase()))
                        && !result.contains(country)) {
                    result.add(country);
                }
            }
        }
        return result;
    }

    protected String normalize(String string) {
        return Normalizer.normalize(string, Normalizer.Form.NFD)
                .replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
    }

    protected List<? extends BaseCountry> loadJson(String filename, Class<? extends BaseCountry> clazz) {
        logger.info("Loading JSON {}", filename);
        List<BaseCountry> countries = new ArrayList<>();
        InputStream is = CountryServiceBaseV2.class.getClassLoader().getResourceAsStream(filename);
        var gson = new Gson();
        JsonReader reader;
        try {
            assert is != null;
            reader = new JsonReader(new InputStreamReader(is, StandardCharsets.UTF_8));
            reader.beginArray();
            while (reader.hasNext()) {
                BaseCountry country = gson.fromJson(reader, clazz);
                countries.add(country);
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Could not load JSON " + filename);
        }
        return countries;
    }
}
