package com.restcountries.controller;

import com.restcountries.domain.ResponseEntity;
import io.micronaut.http.HttpResponse;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.restcountries.utils.Constants.CACHE_CONTROL_VALUE;
import static io.micronaut.http.HttpHeaders.CACHE_CONTROL;

public class ControllerHelper {

  protected static final String[] COUNTRY_FIELDS_V2 = new String[]{
      "name",
      "topLevelDomain",
      "alpha2Code",
      "alpha3Code",
      "callingCodes",
      "capital",
      "altSpellings",
      "region",
      "subregion",
      "translations",
      "population",
      "latlng",
      "demonym",
      "area",
      "gini",
      "timezones",
      "borders",
      "nativeName",
      "numericCode",
      "currencies",
      "languages",
      "flags",
      "regionalBlocs",
      "cioc",
      "independent",
      "continent",
      "borders",
      "flag",
      "flags"
  };

  protected static HttpResponse<Object> ok(Object object) {
    return HttpResponse.ok(object).header(CACHE_CONTROL, CACHE_CONTROL_VALUE);
  }

  protected static HttpResponse<Object> notFound() {
    return HttpResponse.notFound().body(
        new ResponseEntity(
            Response.Status.NOT_FOUND.getStatusCode(),
            Response.Status.NOT_FOUND.getReasonPhrase()
        )
    );
  }

  protected static HttpResponse<Object> internalError() {
    return HttpResponse.serverError().body(
        new ResponseEntity(
            Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(),
            Response.Status.INTERNAL_SERVER_ERROR.getReasonPhrase()
        )
    );
  }

  protected static HttpResponse<Object> badRequest() {
    return HttpResponse.badRequest().body(
        new ResponseEntity(
            Response.Status.BAD_REQUEST.getStatusCode(),
            Response.Status.BAD_REQUEST.getReasonPhrase()
        )
    );
  }

  protected static HttpResponse<Object> badAllRequest() {
    return HttpResponse.badRequest().body(
            new ResponseEntity(
                    Response.Status.BAD_REQUEST.getStatusCode(),
                    "'fields' query not specified"
            )
    );
  }

  protected static boolean hasValidFields(Optional<String> fields) {
    if (fields.isEmpty()) {
      return true;
    }
    var totalFields = Arrays
            .stream(fields.get().split(","))
            .toList()
            .stream()
            .map(String::trim)
            .collect(Collectors.toCollection(ArrayList::new));
    boolean isEmptyOrHasBlank = totalFields.isEmpty() || totalFields.stream().anyMatch(String::isEmpty);
    if (isEmptyOrHasBlank || totalFields.size() > 10) {
      return true;
    }
    return false;
  }
}
