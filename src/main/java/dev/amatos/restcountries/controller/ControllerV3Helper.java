package dev.amatos.restcountries.controller;

import static dev.amatos.restcountries.utils.Constants.CACHE_CONTROL_VALUE;
import static io.micronaut.http.HttpHeaders.CACHE_CONTROL;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import dev.amatos.restcountries.domain.ICountryRestSymbols;
import dev.amatos.restcountries.domain.base.BaseCountry;
import io.micronaut.http.HttpResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class ControllerV3Helper {

  protected Object checkFieldsAndParseCountries(Optional<String> fields,
      Set<? extends dev.amatos.restcountries.domain.base.BaseCountry> countries) {
    if (fields.isPresent()) {
      return parsedCountries(countries, fields.get());
    } else {
      return parsedCountries(countries, null);
    }
  }

  protected Object checkFieldsAndParseCountry(Set<? extends dev.amatos.restcountries.domain.base.BaseCountry> countries, Optional<String> fields) {
    if (fields.isPresent()) {
      return parsedCountry(countries, fields.get());
    } else {
      return parsedCountry(countries, null);
    }
  }

  protected Object parsedCountries(Set<? extends dev.amatos.restcountries.domain.base.BaseCountry> countries, String excludedFields) {
    if (excludedFields == null || excludedFields.isEmpty()) {
      return countries;
    } else {
      return getCountriesJson(countries,
          Arrays.asList(excludedFields.split(ICountryRestSymbols.COLON)));
    }
  }

  protected static Object parsedCountry(Set<? extends BaseCountry> countries, String fields) {
    if (fields == null || fields.isEmpty()) {
      return countries;
    } else {
      StringBuilder result = new StringBuilder();
      countries.forEach(country -> result.append(
          getCountryJson(country, Arrays.asList(fields.split(ICountryRestSymbols.COLON)))));
      return result;
    }
  }

  private static String getCountryJson(BaseCountry country, List<String> fields) {
    var gson = new Gson();
    var jsonObject = JsonParser.parseString(gson.toJson(country)).getAsJsonObject();
    List<String> excludedFields = new ArrayList<>(Arrays.asList(V3_COUNTRY_FIELDS));
    excludedFields.removeAll(fields);
    excludedFields.forEach(jsonObject::remove);
    return jsonObject.toString();
  }

  private String getCountriesJson(Set<? extends dev.amatos.restcountries.domain.base.BaseCountry> countries, List<String> fields) {
    var gson = new Gson();
    var jsonArray = JsonParser.parseString(gson.toJson(countries)).getAsJsonArray();
    var resultArray = new JsonArray();
    jsonArray.forEach(element -> {
      var jsonObject = (JsonObject) element;
      var excludedFields = getExcludedFields(fields);
      excludedFields.forEach(jsonObject::remove);
      resultArray.add(jsonObject);
    });
    return resultArray.toString();
  }

  private List<String> getExcludedFields(List<String> fields) {
    List<String> excludedFields = new ArrayList<>(Arrays.asList(V3_COUNTRY_FIELDS));
    excludedFields.removeAll(fields);
    return excludedFields;
  }

  boolean isEmpty(String value) {
    return value == null || value.isEmpty();
  }

  protected static final String[] V3_COUNTRY_FIELDS = new String[]{
      "name",
      "tld",
      "cca2",
      "ccn3",
      "cca3",
      "cioc",
      "independent",
      "status",
      "unMember",
      "currencies",
      "idd",
      "region",
      "subregion",
      "languages",
      "translations",
      "latlng",
      "landlocked",
      "borders",
      "area",
      "flags",
      "demonyms",
      "population",
      "flags",
      "flag",
      "maps",
      "population",
      "gini",
      "fifa",
      "car",
      "timezones",
      "continents",
      "coatOfArms",
      "startOfWeek",
      "capitalInfo",
      "postalCode"
  };
}
