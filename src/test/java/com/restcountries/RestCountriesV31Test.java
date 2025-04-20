package com.restcountries;

import com.restcountries.service.v3.v31.CountryServiceV31;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@MicronautTest
class RestCountriesV31Test {

  @Test
  void getAll() {
    var countries = CountryServiceV31.getInstance().getAll();
    assertFalse(countries.isEmpty());
  }

  @Test
  void getByAlpha() {
    var countries = CountryServiceV31.getInstance().getByAlpha("CO");
    assertFalse(countries.isEmpty());
    Assertions.assertEquals("Colombia",
        countries.stream().findFirst().map(country -> country.getName().getCommon()).orElseThrow());
  }

  @Test
  void getByAlphaList() {
    var countries = CountryServiceV31.getInstance().getByCodeList("de,co");
    Assertions.assertEquals(2, countries.size());
  }

  @Test
  void getCountryByName() {
    var countries = CountryServiceV31.getInstance().getByName("Peru", false);
    assertFalse(countries.isEmpty());
    Assertions.assertEquals("Peru",
        countries.stream().findFirst().map(country -> country.getName().getCommon()).orElseThrow());
  }

  @Test
  void getByCodeList() {
    var countries = CountryServiceV31.getInstance().getByCodeList("PE,NL,DE");
    Assertions.assertNotNull(countries);
    assertFalse(countries.isEmpty());
    Assertions.assertEquals(3, countries.size());
    var result = countries.stream().allMatch(country ->
        country.getName().getCommon().contains("Peru") ||
            country.getName().getCommon().contains("Netherlands") ||
            country.getName().getCommon().contains("German")
    );
    assertTrue(result);
  }

  @Test
  void getByCurrency() {
    var countries = CountryServiceV31.getInstance().getByCurrency("EUR");
    Assertions.assertNotNull(countries);
    assertFalse(countries.isEmpty());
    countries.forEach(country -> country.getCurrencies()
        .forEach((key, value) -> Assertions.assertEquals("EUR", key)));
  }

  @Test
  void getByCapital() {
    var countries = CountryServiceV31.getInstance().getByCapital("Helsinki");
    var result = countries.stream()
        .anyMatch(country -> country.getName().getCommon().equalsIgnoreCase("Finland"));
    assertTrue(result);
    Assertions.assertEquals(1, countries.size());
    Assertions.assertEquals("Finland",
        countries.stream().findFirst().map(country -> country.getName().getCommon()).orElseThrow());
  }

  @Test
  void getByRegion() {
    var countries = CountryServiceV31.getInstance().getByRegion("Asia");
    assertFalse(countries.isEmpty());
    var result = countries.stream()
        .anyMatch(country -> country.getName().getCommon().equalsIgnoreCase("Bangladesh"));
    assertTrue(result);
  }

  @Test
  void getBySubregion() {
    var countries = CountryServiceV31.getInstance().getBySubregion("Middle Africa");
    assertFalse(countries.isEmpty());
    var result = countries.stream()
        .anyMatch(country -> country.getName().getCommon().equalsIgnoreCase("Gabon"));
    assertTrue(result);
  }

  @Test
  void getByLanguage() {
    var countries = CountryServiceV31.getInstance().getByLanguage("german");
    assertFalse(countries.isEmpty());
    var result = countries.stream()
        .anyMatch(country -> country.getName().getCommon().equalsIgnoreCase("Liechtenstein"));
    assertTrue(result);
  }

  @Test
  void getByDemonym() {
    var countries = CountryServiceV31.getInstance().getByDemonym("chilean");
    assertFalse(countries.isEmpty());
    var result = false;
    result = countries.stream()
        .anyMatch(country -> country.getName().getCommon().equalsIgnoreCase("Chile"));
    assertTrue(result);
  }

  @Test
  void getByTranslation() {
    var countries = CountryServiceV31.getInstance().getByTranslation("Běloruská");
    assertFalse(countries.isEmpty());
    Assertions.assertEquals(1, countries.size());
    Assertions.assertEquals("Belarus", countries.stream().findFirst().get().getName().getCommon());
  }

  @Test
  void testFlags() {
    var countries = CountryServiceV31.getInstance().getAll();
    var result = true;
    try {
      result = countries.stream().noneMatch(
          country -> null == country.getFlags().getPng() || null == country.getFlags().getSvg()
              || null == country.getFlags().getAlt());
    } catch (
        Exception ex) {
      Assertions.fail();
    }
    assertTrue(result);
  }

  @Test
  void testCoatOfArms() {
    var countries = CountryServiceV31.getInstance().getAll();
    var result = true;
    try {
      result = countries.stream().noneMatch(
          country -> null == country.getCoatOfArms().getPng() || null == country.getCoatOfArms()
              .getSvg());
    } catch (
        Exception ex) {
      Assertions.fail();
    }
    assertTrue(result);
  }
}
