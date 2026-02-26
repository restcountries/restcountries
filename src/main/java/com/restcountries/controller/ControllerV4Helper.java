package com.restcountries.controller;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.restcountries.domain.ICountryRestSymbols;
import com.restcountries.domain.v4.Country;

import java.util.*;

public class ControllerV4Helper {

  protected Object checkFieldsAndParseCountries(Optional<String> fields, Set<Country> countries) {
    if (fields.isPresent()) {
      return parsedCountries(countries, fields.get());
    } else {
      return parsedCountries(countries, null);
    }
  }

  protected Object checkFieldsAndParseCountry(Set<Country> countries, Optional<String> fields) {
    if (fields.isPresent()) {
      return parsedCountry(countries, fields.get());
    } else {
      return parsedCountry(countries, null);
    }
  }

  protected Object parsedCountries(Set<Country> countries, String excludedFields) {
    if (excludedFields == null || excludedFields.isEmpty()) {
      return countries;
    } else {
      return getCountriesJson(countries,
          Arrays.asList(excludedFields.split(ICountryRestSymbols.COLON)));
    }
  }

  protected static Object parsedCountry(Set<Country> countries, String fields) {
    if (fields == null || fields.isEmpty()) {
      return countries;
    } else {
      StringBuilder result = new StringBuilder();
      countries.forEach(country -> result.append(
          getCountryJson(country, Arrays.asList(fields.split(ICountryRestSymbols.COLON)))));
      return result;
    }
  }

  private static String getCountryJson(Country country, List<String> fields) {
    var gson = new Gson();
    var jsonObject = JsonParser.parseString(gson.toJson(country)).getAsJsonObject();
    List<String> excludedFields = new ArrayList<>(Arrays.asList(V4_COUNTRY_FIELDS));
    excludedFields.removeAll(fields);
    excludedFields.forEach(jsonObject::remove);
    return jsonObject.toString();
  }

  private String getCountriesJson(Set<Country> countries, List<String> fields) {
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
    List<String> excludedFields = new ArrayList<>(Arrays.asList(V4_COUNTRY_FIELDS));
    excludedFields.removeAll(fields);
    return excludedFields;
  }

  boolean isEmpty(String value) {
    return value == null || value.isEmpty();
  }

  protected static final String[] V4_COUNTRY_FIELDS = new String[]{
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
      "landlocked",
      "borders",
      "area",
      "flag",
      "demonyms",
      "population",
      "maps",
      "gini",
      "fifa",
      "car",
      "timezones",
      "continents",
      "coatOfArms",
      "startOfWeek",
      "capitalInfo",
      "postalCode",
      "capital",
      "altSpellings",
      "geolocation",
      "religion",
      "ethnicity",
      "government",
      "density",
      "gdp",
      "nationalHoliday",
      "anthem",
      "regionalBlocs",
      "callingCodes",
      "hdi",
      "sovereignState"
  };
}
