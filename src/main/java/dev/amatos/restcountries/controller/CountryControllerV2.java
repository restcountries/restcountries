package dev.amatos.restcountries.controller;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import dev.amatos.restcountries.domain.ICountryRestSymbols;
import dev.amatos.restcountries.domain.ResponseEntity;
import dev.amatos.restcountries.service.v2.CountryServiceV2;
import dev.amatos.restcountries.domain.v2.Country;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.MutableHttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.annotation.QueryValue;
import io.swagger.v3.oas.annotations.Hidden;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@Hidden
@Controller("/v2/")
public class CountryControllerV2 {

  @Get(uri = "all", produces = MediaType.APPLICATION_JSON)
  public Object getAllCountries(@QueryValue("fields") Optional<String> fields) {
    List<Country> countries = CountryServiceV2.getInstance().getAll();
    return checkFieldsAndParseCountries(fields, countries);
  }

  @Get("alpha/{alphacode}")
  public HttpResponse<Object> getByAlpha(@PathVariable("alphacode") String alpha,
      @QueryValue("fields") Optional<String> fields) {
    if (alpha.contains("codes")) {
      alpha = alpha.replace("codes=", "");
    }
    if (isEmpty(alpha) || alpha.length() < 2 || alpha.length() > 3) {
      return ControllerHelper.badRequest();
    }
    Country country = CountryServiceV2.getInstance().getByAlpha(alpha);
    if (country != null) {
      return HttpResponse.ok(checkFieldsAndParseCountry(country, fields));
    }
    return ControllerHelper.notFound();
  }

  @Get("alpha/")
  public HttpResponse<Object> getByAlphaList(@QueryParam("codes") String codes,
      @QueryParam("fields") Optional<String> fields) {
    if (isEmpty(codes) || codes.length() < 2 || (codes.length() > 3 && !codes.contains(","))) {
      return ControllerHelper.badRequest();
    }
    try {
      List<Country> countries = CountryServiceV2.getInstance().getByCodeList(codes);
      if (null != countries && !countries.isEmpty()) {
        return HttpResponse.ok(checkFieldsAndParseCountries(fields, countries));
      }
      return ControllerHelper.notFound();
    } catch (Exception e) {
      return ControllerHelper.internalError();
    }

  }

  @Get("currency/{currency}")
  public HttpResponse<Object> getByCurrency(@PathVariable("currency") String currency,
      @QueryParam("fields") Optional<String> fields) {
    if (isEmpty(currency) || currency.length() != 3) {
      return ControllerHelper.badRequest();
    }
    try {
      List<Country> countries = CountryServiceV2.getInstance().getByCurrency(currency);
      if (!countries.isEmpty()) {
        return HttpResponse.ok(checkFieldsAndParseCountries(fields, countries));
      }
      return ControllerHelper.notFound();
    } catch (Exception e) {
      return ControllerHelper.internalError();
    }
  }

  @Get("name/{name}")
  public HttpResponse<Object> getByName(@PathVariable("name") String name,
      @QueryParam("fullText") Optional<Boolean> fullText,
      @QueryParam("fields") Optional<String> fields) {
    try {
      List<Country> countries = CountryServiceV2.getInstance()
          .getByName(name, fullText.orElse(false));
      if (!countries.isEmpty()) {
        return HttpResponse.ok(checkFieldsAndParseCountries(fields, countries));
      }
      return ControllerHelper.notFound();
    } catch (Exception e) {
      return ControllerHelper.internalError();
    }
  }

  @Get("callingcode/{callingCode}")
  public HttpResponse<Object> getByCallingCode(@PathVariable("callingCode") String callingCode,
      @QueryParam("fields") Optional<String> fields) {

    try {
      List<Country> countries = CountryServiceV2.getInstance().getByCallingCode(callingCode);
      if (!countries.isEmpty()) {
        return HttpResponse.ok(checkFieldsAndParseCountries(fields, countries));
      }
      return ControllerHelper.notFound();
    } catch (Exception e) {
      return ControllerHelper.internalError();
    }
  }

  @Get("capital/{capital}")
  public HttpResponse<Object> getByCapital(@PathVariable("capital") String capital,
      @QueryParam("fields") Optional<String> fields) {
    try {
      List<Country> countries = CountryServiceV2.getInstance().getByCapital(capital);
      if (!countries.isEmpty()) {
        return HttpResponse.ok(checkFieldsAndParseCountries(fields, countries));
      }
      return ControllerHelper.notFound();
    } catch (Exception e) {
      return ControllerHelper.internalError();
    }
  }

  @Get("region/{region}")
  public HttpResponse<Object> getByContinent(@PathVariable("region") String region,
      @QueryParam("fields") Optional<String> fields) {
    try {
      List<Country> countries = CountryServiceV2.getInstance().getByRegion(region);
      if (!countries.isEmpty()) {
        return HttpResponse.ok(checkFieldsAndParseCountries(fields, countries));
      }
      return ControllerHelper.notFound();
    } catch (Exception e) {
      return ControllerHelper.internalError();
    }
  }

  @Get("subregion/{subregion}")
  public HttpResponse<Object> getBySubRegion(@PathVariable("subregion") String subregion,
      @QueryParam("fields") Optional<String> fields) {
    try {
      List<Country> countries = CountryServiceV2.getInstance().getBySubregion(subregion);
      if (!countries.isEmpty()) {
        return HttpResponse.ok(checkFieldsAndParseCountries(fields, countries));
      }
      return ControllerHelper.notFound();
    } catch (Exception e) {
      return ControllerHelper.internalError();
    }
  }

  @Get("lang/{lang}")
  public HttpResponse<Object> getByLanguage(@PathVariable("lang") String language,
      @QueryParam("fields") Optional<String> fields) {
    try {
      List<Country> countries = CountryServiceV2.getInstance().getByLanguage(language);
      if (!countries.isEmpty()) {
        return HttpResponse.ok(checkFieldsAndParseCountries(fields, countries));
      }
      return ControllerHelper.notFound();
    } catch (Exception e) {
      return ControllerHelper.internalError();
    }

  }

  @Get("demonym/{demonym}")
  public HttpResponse<Object> getByDemonym(@PathVariable("demonym") String demonym,
      @QueryParam("fields") Optional<String> fields) {
    try {
      List<Country> countries = CountryServiceV2.getInstance().getByDemonym(demonym);
      if (!countries.isEmpty()) {
        return HttpResponse.ok(checkFieldsAndParseCountries(fields, countries));
      }
      return ControllerHelper.notFound();
    } catch (Exception e) {
      return ControllerHelper.internalError();
    }
  }

  @Get("regionalbloc/{regionalBlock}")
  public HttpResponse<Object> getByRegionalBloc(@PathVariable("regionalBlock") String regionalBlock,
      @QueryParam("fields") Optional<String> fields) {
    try {
      List<Country> countries = CountryServiceV2.getInstance().getByRegionalBloc(regionalBlock);
      if (!countries.isEmpty()) {
        return HttpResponse.ok(checkFieldsAndParseCountries(fields, countries));
      }
      return ControllerHelper.notFound();
    } catch (Exception e) {
      return ControllerHelper.internalError();
    }
  }

  private List<Country> checkFieldsAndParseCountries(Optional<String> fields,
      List<Country> countries) {
    if (fields.isPresent()) {
      return parsedCountries(countries, fields.get());
    } else {
      return parsedCountries(countries, null);
    }
  }

  private Object checkFieldsAndParseCountry(Country country, Optional<String> fields) {
    if (fields.isPresent()) {
      return parsedCountry(country, fields.get());
    } else {
      return parsedCountry(country, null);
    }
  }

  private List<Country> parsedCountries(List<Country> countries, String excludedFields) {
    if (excludedFields == null || excludedFields.isEmpty()) {
      return countries;
    } else {
      return getCountriesJson(countries,
          Arrays.asList(excludedFields.split(ICountryRestSymbols.COLON)));
    }
  }

  private List<Country> getCountriesJson(List<Country> countries, List<String> fields) {
    List<Country> result = new ArrayList<>();
    var gson = new Gson();
    var parser = new JsonParser();
    JsonArray jsonArray = parser.parse(gson.toJson(countries)).getAsJsonArray();
    for (var i = 0; i < jsonArray.size(); i++) {
      var jsonObject = (JsonObject) jsonArray.get(i);
      List<String> excludedFields = getExcludedFields(fields);
      for (String excludedField : excludedFields) {
        jsonObject.remove(excludedField);
      }
      result.add(gson.fromJson(jsonObject, Country.class));
    }
    return result;
  }

  private List<String> getExcludedFields(List<String> fields) {
    List<String> excludedFields = new ArrayList<>(Arrays.asList(ControllerHelper.COUNTRY_FIELDS_V2));
    excludedFields.removeAll(fields);
    return excludedFields;
  }
  
  private Object parsedCountry(Country country, String fields) {
    if (fields == null || fields.isEmpty()) {
      return country;
    } else {
      return getCountryJson(country, Arrays.asList(fields.split(ICountryRestSymbols.COLON)));
    }
  }

  private String getCountryJson(Country country, List<String> fields) {
    var gson = new Gson();
    var parser = new JsonParser();
    JsonObject jsonObject = parser.parse(gson.toJson(country)).getAsJsonObject();

    List<String> excludedFields = getExcludedFields(fields);
    for (String field : excludedFields) {
      jsonObject.remove(field);
    }
    return jsonObject.toString();
  }

  private boolean isEmpty(String value) {
    return value == null || value.isEmpty();
  }
}
