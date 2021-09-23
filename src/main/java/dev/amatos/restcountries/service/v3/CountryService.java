package dev.amatos.restcountries.service.v3;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import dev.amatos.restcountries.domain.ICountryRestSymbols;
import dev.amatos.restcountries.v3.domain.Country;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class CountryService {

  private static Set<Country> countries;

  private CountryService() {
    countries = loadJson();
  }

  private static class InstanceHolder {
    private static final CountryService INSTANCE = new CountryService();
  }

  public static CountryService getInstance() {
    return CountryService.InstanceHolder.INSTANCE;
  }

  public Set<Country> getAll() {
    return countries;
  }

  public Set<Country> getByAlpha(String alpha) {
    var result = new HashSet<Country>();
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

  public Set<Country> getByName(String name, boolean isFullText) {
    if (isFullText) {
      return fulltextSearch(name, countries);
    } else {
      return substringSearch(name, countries);
    }
  }

  public Set<Country> getByCurrency(String currency) {
    Set<Country> result = new HashSet<>();
    for (Country country : countries) {
      country.getCurrencies().forEach((key, value) -> {
        if (key.equalsIgnoreCase(currency) || value.getName().toLowerCase().contains(currency)) {
          result.add(country);
        }
      });
    }
    return result;
  }

  private Set<Country> fulltextSearch(String name, Set<Country> countries) {
    Set<Country> result = new HashSet<>();
    for (Country country : countries) {
      if ((name.equalsIgnoreCase(country.getName().getCommon()) || name
              .equalsIgnoreCase(country.getName().getOfficial()))) {
        result.add(country);
        return result;
      }
    }
    return result;
  }

  private Set<Country> substringSearch(String name, Set<Country> countries) {
    // Using 2 different 'for' loops to give priority to 'name' matches over alternative spellings
    Set<Country> result = new HashSet<>();
    for (Country country : countries) {
      if (name.toLowerCase().contains(country.getName().getCommon().toLowerCase()) ||
              name.toLowerCase().contains(country.getName().getOfficial().toLowerCase())) {
        result.add(country);
      }
    }
    for (Country country : countries) {
      for (String alternative : country.getAltSpellings()) {
        if (alternative.toLowerCase().contains(name.toLowerCase())) {
          result.add(country);
        }
      }
    }
    return result;
  }

  public Set<Country> getByCodeList(String codeList) {
    Set<Country> result = new HashSet<>();
    if (codeList == null) {
      return result;
    }

    String[] codes = codeList.split(ICountryRestSymbols.COLON);
    for (String code : codes) {
      var country = getByAlpha(code);
      result.addAll(country);
    }
    return result;
  }

  public Set<Country> getByCapital(String capital) {
    Set<Country> result = new HashSet<>();
    for (Country country : countries) {
      for (String countryCapital : country.getCapital()) {
        if (normalize(countryCapital.toLowerCase()).contains(normalize(capital.toLowerCase()))) {
          result.add(country);
        }
      }
    }
    return result;
  }

  public Set<Country> getByRegion(String subregion) {
    Set<Country> result = new HashSet<>();
    for (Country country : countries) {
      if (country.getRegion().equalsIgnoreCase(subregion)) {
        result.add(country);
      }
    }
    return result;
  }

  public Set<Country> getBySubregion(String region) {
    Set<Country> result = new HashSet<>();
    for (Country country : countries) {
      if (country.getSubregion().equalsIgnoreCase(region)) {
        result.add(country);
      }
    }
    return result;
  }

  public Set<Country> getByLanguage(String language) {
    Set<Country> result = new HashSet<>();
    for (Country country : countries) {
      country.getLanguages().forEach((key, value) -> {
        if (value.equalsIgnoreCase(language) || key.equalsIgnoreCase(language)) {
          result.add(country);
        }
      });
    }
    return result;
  }

  public Set<Country> getByDemonym(String demonym) {
    Set<Country> result = new HashSet<>();
    for (Country country : countries) {
      country.getDemonyms().forEach((key, values) -> values.forEach((k, v) -> {
        if (v.toLowerCase().contains(demonym.toLowerCase())) {
          result.add(country);
        }
      }));
    }
    return result;
  }

  public Set<Country> getByTranslation(String translation) {
    Set<Country> result = new HashSet<>();
    for (Country country : countries) {
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

  protected static Set<Country> loadJson() {
    try {
      InputStream is = CountryService.class.getClassLoader().getResourceAsStream("countriesV3.json");
      var gson = new Gson();
      JsonReader reader;
      countries = new HashSet<>();

      assert is != null;
      reader = new JsonReader(new InputStreamReader(is, StandardCharsets.UTF_8));
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
