package dev.amatos.restcountries.controller;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import dev.amatos.restcountries.domain.ICountryRestSymbols;
import dev.amatos.restcountries.domain.ResponseEntity;
import dev.amatos.restcountries.domain.v3.v31.Country;
import dev.amatos.restcountries.service.v3.v31.CountryServiceV31;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.annotation.QueryValue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@Controller("v3.1/")
public class CountryControllerV31 extends ControllerHelper {

  @Get(uri = "all", produces = MediaType.APPLICATION_JSON)
  public Object getAllCountries(@QueryValue("fields") Optional<String> fields) {
    var countries = CountryServiceV31.getInstance().getAll();
    return checkFieldsAndParseCountries(fields, countries);
  }

  private Object checkFieldsAndParseCountries(Optional<String> fields,
      Set<Country> countries) {
    if (fields.isPresent()) {
      return parsedCountries(countries, fields.get());
    } else {
      return parsedCountries(countries, null);
    }
  }

  @Get("alpha/{alphacode}")
  public Object getByAlpha(@PathVariable("alphacode") String alpha,
      @QueryValue("fields") Optional<String> fields) {
    if (alpha.contains("codes")) {
      alpha = alpha.replace("codes=", "");
    }
    if (isEmpty(alpha) || alpha.length() < 2 || alpha.length() > 3) {
      return HttpResponse.badRequest(getResponse(Response.Status.BAD_REQUEST));
    }
    var country = CountryServiceV31.getInstance().getByAlpha(alpha);
    if (country != null) {
      return checkFieldsAndParseCountry(country, fields);
    }
    return HttpResponse.notFound(getResponse(Response.Status.NOT_FOUND));
  }

  private Object checkFieldsAndParseCountry(Set<Country> countries, Optional<String> fields) {
    if (fields.isPresent()) {
      return parsedCountry(countries, fields.get());
    } else {
      return parsedCountry(countries, null);
    }
  }

  @Get("alpha/")
  public Object getByAlphaList(@QueryParam("codes") String codes,
      @QueryParam("fields") Optional<String> fields) {
    if (isEmpty(codes) || codes.length() < 2 || (codes.length() > 3 && !codes.contains(","))) {
      return HttpResponse.badRequest(getResponse(Response.Status.BAD_REQUEST));
    }
    try {
      var countries = CountryServiceV31.getInstance().getByCodeList(codes);
      if (!countries.isEmpty()) {
        return checkFieldsAndParseCountries(fields, countries);
      }
      return HttpResponse.notFound(getResponse(Response.Status.NOT_FOUND));
    } catch (Exception e) {
      return HttpResponse.serverError(getResponse(Response.Status.INTERNAL_SERVER_ERROR));
    }

  }

  @Get("currency/{currency}")
  public Object getByCurrency(@PathVariable("currency") String currency,
      @QueryParam("fields") Optional<String> fields) {
    if (isEmpty(currency)) {
      return getResponse(Response.Status.BAD_REQUEST);
    }
    try {
      var countries = CountryServiceV31.getInstance().getByCurrency(currency);
      if (!countries.isEmpty()) {
        return checkFieldsAndParseCountries(fields, countries);
      }
      return HttpResponse.notFound(getResponse(Response.Status.NOT_FOUND));
    } catch (Exception e) {
      return HttpResponse.serverError(getResponse(Response.Status.INTERNAL_SERVER_ERROR));
    }
  }

  @Get("name/{name}")
  public Object getByName(@PathVariable("name") String name,
      @QueryParam("fullText") Optional<Boolean> fullText,
      @QueryParam("fields") Optional<String> fields) {
    try {
      var countries = CountryServiceV31.getInstance()
          .getByName(name, fullText.orElse(false));
      if (!countries.isEmpty()) {
        return checkFieldsAndParseCountries(fields, countries);
      }
      return HttpResponse.notFound(getResponse(Response.Status.NOT_FOUND));
    } catch (Exception e) {
      return HttpResponse.serverError(Response.Status.INTERNAL_SERVER_ERROR);
    }
  }

  @Get("capital/{capital}")
  public Object getByCapital(@PathVariable("capital") String capital,
      @QueryParam("fields") Optional<String> fields) {
    try {
      var countries = CountryServiceV31.getInstance().getByCapital(capital);
      if (!countries.isEmpty()) {
        return checkFieldsAndParseCountries(fields, countries);
      }
      return HttpResponse.notFound(getResponse(Response.Status.NOT_FOUND));
    } catch (Exception e) {
      return HttpResponse.serverError(Response.Status.INTERNAL_SERVER_ERROR);
    }
  }


  @Get("region/{region}")
  public Object getByContinent(@PathVariable("region") String region,
      @QueryParam("fields") Optional<String> fields) {
    try {
      var countries = CountryServiceV31.getInstance().getByRegion(region);
      if (!countries.isEmpty()) {
        return checkFieldsAndParseCountries(fields, countries);
      }
      return HttpResponse.notFound(getResponse(Response.Status.NOT_FOUND));
    } catch (Exception e) {
      return HttpResponse.serverError(Response.Status.INTERNAL_SERVER_ERROR);
    }
  }

  @Get("subregion/{subregion}")
  public Object getBySubRegion(@PathVariable("subregion") String subregion,
      @QueryParam("fields") Optional<String> fields) {
    try {
      var countries = CountryServiceV31.getInstance().getBySubregion(subregion);
      if (!countries.isEmpty()) {
        return checkFieldsAndParseCountries(fields, countries);
      }
      return HttpResponse.notFound(getResponse(Response.Status.NOT_FOUND));
    } catch (Exception e) {
      return HttpResponse.serverError(Response.Status.INTERNAL_SERVER_ERROR);
    }
  }

  @Get("lang/{lang}")
  public Object getByLanguage(@PathVariable("lang") String language,
      @QueryParam("fields") Optional<String> fields) {
    try {
      var countries = CountryServiceV31.getInstance().getByLanguage(language);
      if (!countries.isEmpty()) {
        return checkFieldsAndParseCountries(fields, countries);
      }
      return HttpResponse.notFound(getResponse(Response.Status.NOT_FOUND));
    } catch (Exception e) {
      return HttpResponse.serverError(Response.Status.INTERNAL_SERVER_ERROR);
    }

  }

  @Get("demonym/{demonym}")
  public Object getByDemonym(@PathVariable("demonym") String demonym,
      @QueryParam("fields") Optional<String> fields) {
    try {
      var countries = CountryServiceV31.getInstance().getByDemonym(demonym);
      if (!countries.isEmpty()) {
        return checkFieldsAndParseCountries(fields, countries);
      }
      return HttpResponse.notFound(getResponse(Response.Status.NOT_FOUND));
    } catch (Exception e) {
      return HttpResponse.serverError(Response.Status.INTERNAL_SERVER_ERROR);
    }
  }

  @Get("translation/{translation}")
  public Object getByTranslation(@PathVariable("translation") String translation,
      @QueryParam("fields") Optional<String> fields) {
    try {
      var countries = CountryServiceV31.getInstance().getByTranslation(translation);
      if (!countries.isEmpty()) {
        return checkFieldsAndParseCountries(fields, countries);
      }
      return HttpResponse.notFound(getResponse(Response.Status.NOT_FOUND));
    } catch (Exception e) {
      return HttpResponse.serverError(Response.Status.INTERNAL_SERVER_ERROR);
    }
  }

  private Object parsedCountries(Set<Country> countries, String excludedFields) {
    if (excludedFields == null || excludedFields.isEmpty()) {
      return countries;
    } else {
      return getCountriesJson(countries,
          Arrays.asList(excludedFields.split(ICountryRestSymbols.COLON)));
    }
  }

  private String getCountriesJson(Set<Country> countries, List<String> fields) {
    var gson = new Gson();
    var parser = new JsonParser();
    var jsonArray = parser.parse(gson.toJson(countries)).getAsJsonArray();
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

  private Object getResponse(Response.Status status) {
    var gson = new Gson();
    return Response
        .status(status)
        .entity(gson.toJson(new ResponseEntity(status.getStatusCode(),
            status.getReasonPhrase())))
        .build()
        .getEntity();
  }

  private Object parsedCountry(Set<Country> countries, String fields) {
    if (fields == null || fields.isEmpty()) {
      return countries;
    } else {
      StringBuilder result = new StringBuilder();
      countries.forEach(country -> result.append(
          getCountryJson(country, Arrays.asList(fields.split(ICountryRestSymbols.COLON)))));
      return result;
    }
  }

  private String getCountryJson(Country country, List<String> fields) {
    var gson = new Gson();
    var parser = new JsonParser();
    var jsonObject = parser.parse(gson.toJson(country)).getAsJsonObject();

    List<String> excludedFields = getExcludedFields(fields);
    excludedFields.forEach(jsonObject::remove);
    return jsonObject.toString();
  }

  private boolean isEmpty(String value) {
    return value == null || value.isEmpty();
  }
}
