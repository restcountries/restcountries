/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
package com.restcountries.service.v3;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.restcountries.domain.ICountryRestSymbols;
import com.restcountries.domain.base.BaseCountry;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.text.Normalizer;
import java.util.HashSet;
import java.util.Set;

public class CountryServiceBaseV3 {

  protected <T extends BaseCountry> Set<T> getByAlpha(String alpha, Set<T> countries) {
    var result = new HashSet<T>();
    for (var country : countries) {
      if (country.getCca2().equalsIgnoreCase(alpha) ||
          country.getCcn3().equalsIgnoreCase(alpha) ||
          country.getCca3().equalsIgnoreCase(alpha) ||
          country.getCioc().equalsIgnoreCase(alpha)
      ) {
        result.add(country);
      }
    }
    return result;
  }

  protected Set<? extends BaseCountry> getByCodeList(String codeList, Set<? extends BaseCountry> countries) {
    Set<BaseCountry> result = new HashSet<>();
    if (codeList == null) {
      return result;
    }

    String[] codes = codeList.split(ICountryRestSymbols.COLON);
    for (String code : codes) {
      var country = getByAlpha(code, countries);
      result.addAll(country);
    }
    return result;
  }

  protected Set<? extends BaseCountry> getByName(String name, boolean fullText, Set<? extends BaseCountry> countries) {
    if(fullText) {
      return fulltextSearch(name, countries);
    } else {
      return substringSearch(name, countries);
    }
  }

  private Set<? extends BaseCountry> fulltextSearch(String name, Set<? extends BaseCountry> countries) {
    Set<BaseCountry> result = new HashSet<>();
    for (var country : countries) {
      if ((name.equalsIgnoreCase(country.getName().getCommon()) || name
          .equalsIgnoreCase(country.getName().getOfficial()))) {
        result.add(country);
        return result;
      }
    }
    return result;
  }

  private Set<? extends BaseCountry> substringSearch(String name, Set<? extends BaseCountry> countries) {
    // Using 2 different 'for' loops to give priority to 'name' matches over alternative spellings
    Set<BaseCountry> result = new HashSet<>();
    for (var country : countries) {
      if(country.getName().getCommon().toLowerCase().contains(name.toLowerCase()) ||
          country.getName().getOfficial().toLowerCase().contains(name.toLowerCase())
      ) {
        result.add(country);
      }
      for (String alternative : country.getAltSpellings()) {
        if (alternative.toLowerCase().contains(name.toLowerCase())) {
          result.add(country);
        }
      }
    }
    return result;
  }

  protected Set<? extends BaseCountry> getByCurrency(String currency, Set<? extends BaseCountry> countries) {
    Set<BaseCountry> result = new HashSet<>();
    for (var country : countries) {
      country.getCurrencies().forEach((key, value) -> {
        if (key.equalsIgnoreCase(currency) || value.getName().toLowerCase().contains(currency)) {
          result.add(country);
        }
      });
    }
    return result;
  }

  protected Set<? extends BaseCountry> getByCapital(String capital, Set<? extends BaseCountry> countries) {
    Set<BaseCountry> result = new HashSet<>();
    for (var country : countries) {
      for (String countryCapital : country.getCapital()) {
        if (normalize(countryCapital.toLowerCase()).contains(normalize(capital.toLowerCase()))) {
          result.add(country);
        }
      }
    }
    return result;
  }

  protected Set<? extends BaseCountry> getByRegion(String region, Set<? extends BaseCountry> countries) {
    Set<BaseCountry> result = new HashSet<>();
    for (var country : countries) {
      if (country.getRegion().toLowerCase().contains(region.toLowerCase()) || country.getSubregion()
          .equalsIgnoreCase(region)) {
        result.add(country);
      }
    }
    return result;
  }

  protected Set<? extends BaseCountry> getBySubregion(String subregion, Set<? extends BaseCountry> countries) {
    Set<BaseCountry> result = new HashSet<>();
    for (var country : countries) {
      if (country.getSubregion().toLowerCase().contains(subregion.toLowerCase())
          || country.getSubregion().equalsIgnoreCase(subregion)) {
        result.add(country);
      }
    }
    return result;
  }

  protected Set<? extends BaseCountry> getByLanguage(String language, Set<? extends BaseCountry> countries) {
    Set<BaseCountry> result = new HashSet<>();
    for (var country : countries) {
      country.getLanguages().forEach((key, value) -> {
        if (value.equalsIgnoreCase(language) || key.equalsIgnoreCase(language)) {
          result.add(country);
        }
      });
    }
    return result;
  }

  protected Set<? extends BaseCountry> getByDemonym(String demonym, Set<? extends BaseCountry> countries) {
    Set<BaseCountry> result = new HashSet<>();
    for (var country : countries) {
      country.getDemonyms().forEach((key, values) -> values.forEach((k, v) -> {
        if (v.toLowerCase().contains(demonym.toLowerCase())) {
          result.add(country);
        }
      }));
    }
    return result;
  }

  protected Set<? extends BaseCountry> getByTranslation(String translation, Set<? extends BaseCountry> countries) {
    Set<BaseCountry> result = new HashSet<>();
    for (var country : countries) {
      country.getTranslations().forEach((key, values) -> values.forEach((k, v) -> {
        if (v.toLowerCase().contains(translation.toLowerCase())) {
          result.add(country);
        }
      }));
    }
    return result;
  }

  protected String normalize(String string) {
    return Normalizer.normalize(string, Normalizer.Form.NFD)
        .replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
  }

  protected Set<? extends BaseCountry> loadJson(String filename, Class<? extends BaseCountry> clazz) {
    Set<BaseCountry> countries = new HashSet<>();
    InputStream is = CountryServiceBaseV3.class.getClassLoader().getResourceAsStream(filename);
    Gson gson = new Gson();
    JsonReader reader;
    try {
      reader = new JsonReader(new InputStreamReader(is, StandardCharsets.UTF_8));
      reader.beginArray();
      while(reader.hasNext()) {
        BaseCountry country = gson.fromJson(reader, clazz);
        countries.add(country);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return countries;
  }
}
