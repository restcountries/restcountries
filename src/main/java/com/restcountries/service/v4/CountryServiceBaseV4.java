package com.restcountries.service.v4;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.restcountries.domain.ICountryRestSymbols;
import com.restcountries.domain.v4.Country;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.text.Normalizer;
import java.util.HashSet;
import java.util.Set;

public class CountryServiceBaseV4 {

  protected Set<Country> getByAlpha(String alpha, Set<Country> countries) {
    var result = new HashSet<Country>();
    for (var country : countries) {
      if ((country.getCca2() != null && country.getCca2().equalsIgnoreCase(alpha)) ||
          (country.getCcn3() != null && country.getCcn3().equalsIgnoreCase(alpha)) ||
          (country.getCca3() != null && country.getCca3().equalsIgnoreCase(alpha)) ||
          (country.getCioc() != null && country.getCioc().equalsIgnoreCase(alpha))
      ) {
        result.add(country);
      }
    }
    return result;
  }

  protected Set<Country> getByCodeList(String codeList, Set<Country> countries) {
    Set<Country> result = new HashSet<>();
    if (codeList == null) {
      return result;
    }
    String[] codes = codeList.split(ICountryRestSymbols.COLON);
    for (String code : codes) {
      result.addAll(getByAlpha(code, countries));
    }
    return result;
  }

  protected Set<Country> getByName(String name, boolean fullText, Set<Country> countries) {
    if (fullText) {
      return fulltextSearch(name, countries);
    } else {
      return substringSearch(name, countries);
    }
  }

  private Set<Country> fulltextSearch(String name, Set<Country> countries) {
    Set<Country> result = new HashSet<>();
    for (var country : countries) {
      if (name.equalsIgnoreCase(country.getName().getCommon()) ||
          name.equalsIgnoreCase(country.getName().getOfficial())) {
        result.add(country);
        return result;
      }
    }
    return result;
  }

  private Set<Country> substringSearch(String name, Set<Country> countries) {
    Set<Country> result = new HashSet<>();
    for (var country : countries) {
      if (country.getName().getCommon().toLowerCase().contains(name.toLowerCase()) ||
          country.getName().getOfficial().toLowerCase().contains(name.toLowerCase())) {
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

  protected Set<Country> getByCurrency(String currency, Set<Country> countries) {
    Set<Country> result = new HashSet<>();
    for (var country : countries) {
      if (country.getCurrencies() != null) {
        for (var c : country.getCurrencies()) {
          if ((c.getCode() != null && c.getCode().equalsIgnoreCase(currency)) ||
              (c.getName() != null && c.getName().toLowerCase().contains(currency.toLowerCase()))) {
            result.add(country);
          }
        }
      }
    }
    return result;
  }

  protected Set<Country> getByCapital(String capital, Set<Country> countries) {
    Set<Country> result = new HashSet<>();
    for (var country : countries) {
      if (country.getCapital() != null) {
        for (String countryCapital : country.getCapital()) {
          if (normalize(countryCapital.toLowerCase()).contains(normalize(capital.toLowerCase()))) {
            result.add(country);
          }
        }
      }
    }
    return result;
  }

  protected Set<Country> getByRegion(String region, Set<Country> countries) {
    Set<Country> result = new HashSet<>();
    for (var country : countries) {
      if ((country.getRegion() != null && country.getRegion().toLowerCase().contains(region.toLowerCase())) ||
          (country.getSubregion() != null && country.getSubregion().equalsIgnoreCase(region))) {
        result.add(country);
      }
    }
    return result;
  }

  protected Set<Country> getBySubregion(String subregion, Set<Country> countries) {
    Set<Country> result = new HashSet<>();
    for (var country : countries) {
      if (country.getSubregion() != null &&
          (country.getSubregion().toLowerCase().contains(subregion.toLowerCase()) ||
           country.getSubregion().equalsIgnoreCase(subregion))) {
        result.add(country);
      }
    }
    return result;
  }

  protected Set<Country> getByLanguage(String language, Set<Country> countries) {
    Set<Country> result = new HashSet<>();
    for (var country : countries) {
      if (country.getLanguages() != null) {
        for (var lang : country.getLanguages()) {
          if ((lang.getName() != null && lang.getName().equalsIgnoreCase(language)) ||
              (lang.getIso639_1() != null && lang.getIso639_1().equalsIgnoreCase(language)) ||
              (lang.getIso639_2() != null && lang.getIso639_2().equalsIgnoreCase(language))) {
            result.add(country);
          }
        }
      }
    }
    return result;
  }

  protected Set<Country> getByDemonym(String demonym, Set<Country> countries) {
    Set<Country> result = new HashSet<>();
    for (var country : countries) {
      if (country.getDemonyms() != null) {
        for (var d : country.getDemonyms()) {
          if ((d.getMale() != null && d.getMale().toLowerCase().contains(demonym.toLowerCase())) ||
              (d.getFemale() != null && d.getFemale().toLowerCase().contains(demonym.toLowerCase()))) {
            result.add(country);
          }
        }
      }
    }
    return result;
  }

  protected Set<Country> getByTranslation(String translation, Set<Country> countries) {
    Set<Country> result = new HashSet<>();
    for (var country : countries) {
      if (country.getTranslations() != null) {
        for (var t : country.getTranslations()) {
          if ((t.getOfficial() != null && t.getOfficial().toLowerCase().contains(translation.toLowerCase())) ||
              (t.getCommon() != null && t.getCommon().toLowerCase().contains(translation.toLowerCase()))) {
            result.add(country);
          }
        }
      }
    }
    return result;
  }

  protected String normalize(String string) {
    return Normalizer.normalize(string, Normalizer.Form.NFD)
        .replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
  }

  protected Set<Country> loadJson(String filename) {
    Set<Country> countries = new HashSet<>();
    InputStream is = CountryServiceBaseV4.class.getClassLoader().getResourceAsStream(filename);
    Gson gson = new Gson();
    try {
      JsonReader reader = new JsonReader(new InputStreamReader(is, StandardCharsets.UTF_8));
      reader.beginArray();
      while (reader.hasNext()) {
        Country country = gson.fromJson(reader, Country.class);
        countries.add(country);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return countries;
  }
}
