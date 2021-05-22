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
import java.util.List;

public class CountryService {

  private static List<Country> countries;

  private CountryService() {
    initialize();
  }

  private static void initialize() {
    countries = loadJson("countriesV3.json", Country.class);
  }

  private static class InstanceHolder {

    private static final CountryService INSTANCE = new CountryService();
  }

  public static CountryService getInstance() {
    return CountryService.InstanceHolder.INSTANCE;
  }

  public List<Country> getAll() {
    return countries;
  }

  public Country getByAlpha(String alpha) {
    for (var country : countries) {
      if (country.getCca2().equalsIgnoreCase(alpha) ||
          country.getCcn3().equalsIgnoreCase(alpha) ||
          country.getCca3().equalsIgnoreCase(alpha) ||
          country.getCioc().equalsIgnoreCase(alpha)
      ) {
        return country;
      }
    }
    return null;
  }

  public List<Country> getByName(String name, boolean isFullText) {
    if (isFullText) {
      return fulltextSearch(name, countries);
    } else {
      return substringSearch(name, countries);
    }
  }

  public List<Country> getByCurrency(String currency) {
    List<Country> result = new ArrayList<>();
    for (Country country : countries) {
      country.getCurrencies().forEach((key, value) -> {
        if (key.equalsIgnoreCase(currency) ||
            value.getName() != null && value.getName().toLowerCase().contains(currency)
        ) {
          result.add(country);
        }
      });
    }
    return result;
  }

  private List<Country> fulltextSearch(String name, List<Country> countries) {
    // Using 2 different 'for' loops to give priority to 'name' matches over alternative spellings
    List<Country> result = new ArrayList<>();
    for (Country country : countries) {
      if ((name.equalsIgnoreCase(country.getName().getCommon())||name.equalsIgnoreCase(country.getName().getOfficial()))){
        result.add(country);
        return result;
      }
    }
    return result;
  }

  private List<Country> substringSearch(String name, List<Country> countries) {
    // Using 2 different 'for' loops to give priority to 'name' matches over alternative spellings
    List<Country> result = new ArrayList<>();
    for (Country country : countries) {
      if (
          isNameNormalizedContaining(name, country.getName().getCommon()) ||
              isNameNormalizedContaining(name, country.getName().getOfficial())
      ) {
        result.add(country);
      }
    }
    for (Country country : countries) {
      for (String alternative : country.getAltSpellings()) {
        if (isNameNormalizedContaining(alternative, country.getName().getCommon())
            && !result.contains(country)) {
          result.add(country);
        }
      }
    }
    return result;
  }

  public List<Country> getByCodeList(String codeList) {
    List<Country> result = new ArrayList<>();
    if (codeList == null) {
      return result;
    }

    String[] codes = codeList.split(ICountryRestSymbols.COLON);
    for (String code : codes) {
      var country = getByAlpha(code);
      if (!result.contains(country)) {
        result.add(country);
      }
    }
    return result;
  }

  public List<Country> getByCapital(String capital) {
    List<Country> result = new ArrayList<>();
    for (Country country : countries) {
      for (String countryCapital : country.getCapital()) {
        if (normalize(countryCapital.toLowerCase()).contains(normalize(capital.toLowerCase()))) {
          result.add(country);
        }
      }
    }
    return result;
  }

  public List<Country> getByRegion(String subregion) {
    List<Country> result = new ArrayList<>();
    for (Country country : countries) {
      if (country.getRegion().equalsIgnoreCase(subregion)) {
        result.add(country);
      }
    }
    return result;
  }

  public List<Country> getBySubregion(String region) {
    List<Country> result = new ArrayList<>();
    for (Country country : countries) {
      if (country.getSubregion().equalsIgnoreCase(region)) {
        result.add(country);
      }
    }
    return result;
  }

  public List<Country> getByLanguage(String language) {
    List<Country> result = new ArrayList<>();
    for (Country country : countries) {
      country.getLanguages().forEach((key, value) -> {
        if (value.equalsIgnoreCase(language) || key.equalsIgnoreCase(language)) {
          result.add(country);
        }
      });
    }
    return result;
  }

  public List<Country> getByDemonym(String demonym) {
    List<Country> result = new ArrayList<>();
    for (Country country : countries) {
      country.getDemonyms().forEach((key, values) -> values.forEach((k, v)-> {
        if(v.toLowerCase().contains(demonym.toLowerCase())) {
          result.add(country);
        }
      }));
    }
    return result;
  }

  public List<Country> getByTranslation(String translation) {
    List<Country> result = new ArrayList<>();
    for (Country country : countries) {
      country.getTranslations().forEach((key, values) -> values.forEach((k, v)-> {
        if(v.toLowerCase().contains(translation.toLowerCase())) {
          result.add(country);
        }
      }));
    }
    return result;
  }

  private boolean isNameNormalizedEquals(String countryName, String name) {
    return normalize(countryName.toLowerCase()).equals(name.toLowerCase());
  }

  private boolean isNameNormalizedContaining(String countryName, String name) {
    return normalize(countryName.toLowerCase()).contains(name.toLowerCase());
  }

  protected String normalize(String string) {
    return Normalizer.normalize(string, Normalizer.Form.NFD)
        .replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
  }

  protected static List<Country> loadJson(String filename, Class<? extends Country> clazz) {
    InputStream is = CountryService.class.getClassLoader().getResourceAsStream(filename);
    var gson = new Gson();
    JsonReader reader;
    countries = new ArrayList<>();
    try {
      assert is != null;
      reader = new JsonReader(new InputStreamReader(is, StandardCharsets.UTF_8));
      reader.beginArray();
      while (reader.hasNext()) {
        Country country = gson.fromJson(reader, clazz);
        countries.add(country);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return countries;
  }
}
