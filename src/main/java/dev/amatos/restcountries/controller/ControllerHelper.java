package dev.amatos.restcountries.controller;

import static dev.amatos.restcountries.utils.Constants.CACHE_CONTROL_VALUE;
import static io.micronaut.http.HttpHeaders.CACHE_CONTROL;

import dev.amatos.restcountries.domain.ResponseEntity;
import io.micronaut.http.HttpResponse;
import jakarta.ws.rs.core.Response;

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
}
