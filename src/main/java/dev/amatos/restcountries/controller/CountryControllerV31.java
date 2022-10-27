package dev.amatos.restcountries.controller;

import dev.amatos.restcountries.service.v3.v31.CountryServiceV31;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.annotation.QueryValue;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Optional;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@Controller("/v3.1/")
public class CountryControllerV31 extends ControllerV3Helper {

  @Get(uri = "all", produces = MediaType.APPLICATION_JSON)
  @Schema(name="RestCountries")
  public Object getAllCountries(@QueryValue("fields") Optional<String> fields) {
    var countries = CountryServiceV31.getInstance().getAll();
    return ControllerHelper.ok(checkFieldsAndParseCountries(fields, countries));
  }

  @Get("alpha/{alphacode}")
  @Schema(name="RestCountries")
  public Object getByAlpha(@PathVariable("alphacode") String alpha,
      @QueryValue("fields") Optional<String> fields) {
    if (alpha.contains("codes")) {
      alpha = alpha.replace("codes=", "");
    }
    if (isEmpty(alpha) || alpha.length() < 2 || alpha.length() > 3) {
      return ControllerHelper.badRequest();
    }
    var country = CountryServiceV31.getInstance().getByAlpha(alpha);
    if (country != null && !country.isEmpty()) {
      return ControllerHelper.ok(checkFieldsAndParseCountry(country, fields));
    }
    return ControllerHelper.notFound();
  }

  @Get("alpha/")
  @Schema(name="RestCountries")
  public Object getByAlphaList(@QueryParam("codes") String codes,
      @QueryParam("fields") Optional<String> fields) {
    if (isEmpty(codes) || codes.length() < 2 || (codes.length() > 3 && !codes.contains(","))) {
      return ControllerHelper.badRequest();
    }
    try {
      var countries = CountryServiceV31.getInstance().getByCodeList(codes);
      if (!countries.isEmpty()) {
        return ControllerHelper.ok(checkFieldsAndParseCountries(fields, countries));
      }
      return ControllerHelper.notFound();
    } catch (Exception e) {
      return ControllerHelper.internalError();
    }

  }

  @Get("currency/{currency}")
  @Schema(name="RestCountries")
  public Object getByCurrency(@PathVariable("currency") String currency,
      @QueryParam("fields") Optional<String> fields) {
    if (isEmpty(currency)) {
      return ControllerHelper.badRequest();
    }
    try {
      var countries = CountryServiceV31.getInstance().getByCurrency(currency);
      if (!countries.isEmpty()) {
        return ControllerHelper.ok(checkFieldsAndParseCountries(fields, countries));
      }
      return ControllerHelper.notFound();
    } catch (Exception e) {
      return ControllerHelper.internalError();
    }
  }

  @Get("name/{name}")
  @Schema(name="RestCountries")
  public Object getByName(@PathVariable("name") String name,
      @QueryParam("fullText") Optional<Boolean> fullText,
      @QueryParam("fields") Optional<String> fields) {
    try {
      var countries = CountryServiceV31.getInstance().getByName(name, fullText.orElse(false));
      if (!countries.isEmpty()) {
        return ControllerHelper.ok(checkFieldsAndParseCountries(fields, countries));
      }
      return ControllerHelper.notFound();
    } catch (Exception e) {
      return HttpResponse.serverError(Response.Status.INTERNAL_SERVER_ERROR);
    }
  }

  @Get("capital/{capital}")
  @Schema(name="RestCountries")
  public Object getByCapital(@PathVariable("capital") String capital,
      @QueryParam("fields") Optional<String> fields) {
    try {
      var countries = CountryServiceV31.getInstance().getByCapital(capital);
      if (!countries.isEmpty()) {
        return ControllerHelper.ok(checkFieldsAndParseCountries(fields, countries));
      }
      return ControllerHelper.notFound();
    } catch (Exception e) {
      return HttpResponse.serverError(Response.Status.INTERNAL_SERVER_ERROR);
    }
  }


  @Get("region/{region}")
  @Schema(name="RestCountries")
  public Object getByContinent(@PathVariable("region") String region,
      @QueryParam("fields") Optional<String> fields) {
    try {
      var countries = CountryServiceV31.getInstance().getByRegion(region);
      if (!countries.isEmpty()) {
        return ControllerHelper.ok(checkFieldsAndParseCountries(fields, countries));
      }
      return ControllerHelper.notFound();
    } catch (Exception e) {
      return HttpResponse.serverError(Response.Status.INTERNAL_SERVER_ERROR);
    }
  }

  @Get("subregion/{subregion}")
  @Schema(name="RestCountries")
  public Object getBySubRegion(@PathVariable("subregion") String subregion,
      @QueryParam("fields") Optional<String> fields) {
    try {
      var countries = CountryServiceV31.getInstance().getBySubregion(subregion);
      if (!countries.isEmpty()) {
        return ControllerHelper.ok(checkFieldsAndParseCountries(fields, countries));
      }
      return ControllerHelper.notFound();
    } catch (Exception e) {
      return HttpResponse.serverError(Response.Status.INTERNAL_SERVER_ERROR);
    }
  }

  @Get("lang/{lang}")
  @Schema(name="RestCountries")
  public Object getByLanguage(@PathVariable("lang") String language,
      @QueryParam("fields") Optional<String> fields) {
    try {
      var countries = CountryServiceV31.getInstance().getByLanguage(language);
      if (!countries.isEmpty()) {
        return ControllerHelper.ok(checkFieldsAndParseCountries(fields, countries));
      }
      return ControllerHelper.notFound();
    } catch (Exception e) {
      return HttpResponse.serverError(Response.Status.INTERNAL_SERVER_ERROR);
    }

  }

  @Get("demonym/{demonym}")
  @Schema(name="RestCountries")
  public Object getByDemonym(@PathVariable("demonym") String demonym,
      @QueryParam("fields") Optional<String> fields) {
    try {
      var countries = CountryServiceV31.getInstance().getByDemonym(demonym);
      if (!countries.isEmpty()) {
        return ControllerHelper.ok(checkFieldsAndParseCountries(fields, countries));
      }
      return ControllerHelper.notFound();
    } catch (Exception e) {
      return HttpResponse.serverError(Response.Status.INTERNAL_SERVER_ERROR);
    }
  }

  @Get("translation/{translation}")
  @Schema(name="RestCountries")
  public Object getByTranslation(@PathVariable("translation") String translation,
      @QueryParam("fields") Optional<String> fields) {
    try {
      var countries = CountryServiceV31.getInstance().getByTranslation(translation);
      if (!countries.isEmpty()) {
        return ControllerHelper.ok(checkFieldsAndParseCountries(fields, countries));
      }
      return ControllerHelper.notFound();
    } catch (Exception e) {
      return HttpResponse.serverError(Response.Status.INTERNAL_SERVER_ERROR);
    }
  }
}
