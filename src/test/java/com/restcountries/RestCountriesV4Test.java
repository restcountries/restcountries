package com.restcountries;

import com.restcountries.service.v4.CountryServiceV4;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RestCountriesV4Test {

  @Test
  void getAll() {
    var countries = CountryServiceV4.getInstance().getAll();
    assertFalse(countries.isEmpty());
    Assertions.assertEquals(250, countries.size());
  }

  @Test
  void getByAlpha() {
    var countries = CountryServiceV4.getInstance().getByAlpha("CO");
    assertFalse(countries.isEmpty());
    Assertions.assertEquals("Colombia",
        countries.stream().findFirst().map(country -> country.getName().getCommon()).orElseThrow());
  }

  @Test
  void getByAlphaList() {
    var countries = CountryServiceV4.getInstance().getByCodeList("de,co");
    Assertions.assertEquals(2, countries.size());
  }

  @Test
  void getCountryByName() {
    var countries = CountryServiceV4.getInstance().getByName("Peru", false);
    assertFalse(countries.isEmpty());
    Assertions.assertEquals("Peru",
        countries.stream().findFirst().map(country -> country.getName().getCommon()).orElseThrow());
  }

  @Test
  void getByCodeList() {
    var countries = CountryServiceV4.getInstance().getByCodeList("PE,NL,DE");
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
    var countries = CountryServiceV4.getInstance().getByCurrency("EUR");
    Assertions.assertNotNull(countries);
    assertFalse(countries.isEmpty());
    countries.forEach(country -> {
      var hasEur = country.getCurrencies().stream()
          .anyMatch(c -> "EUR".equals(c.getCode()));
      assertTrue(hasEur);
    });
  }

  @Test
  void getByCapital() {
    var countries = CountryServiceV4.getInstance().getByCapital("Helsinki");
    var result = countries.stream()
        .anyMatch(country -> country.getName().getCommon().equalsIgnoreCase("Finland"));
    assertTrue(result);
    Assertions.assertEquals(1, countries.size());
    Assertions.assertEquals("Finland",
        countries.stream().findFirst().map(country -> country.getName().getCommon()).orElseThrow());
  }

  @Test
  void getByRegion() {
    var countries = CountryServiceV4.getInstance().getByRegion("Asia");
    assertFalse(countries.isEmpty());
    var result = countries.stream()
        .anyMatch(country -> country.getName().getCommon().equalsIgnoreCase("Bangladesh"));
    assertTrue(result);
  }

  @Test
  void getBySubregion() {
    var countries = CountryServiceV4.getInstance().getBySubregion("Middle Africa");
    assertFalse(countries.isEmpty());
    var result = countries.stream()
        .anyMatch(country -> country.getName().getCommon().equalsIgnoreCase("Gabon"));
    assertTrue(result);
  }

  @Test
  void getByLanguage() {
    var countries = CountryServiceV4.getInstance().getByLanguage("german");
    assertFalse(countries.isEmpty());
    var result = countries.stream()
        .anyMatch(country -> country.getName().getCommon().equalsIgnoreCase("Liechtenstein"));
    assertTrue(result);
  }

  @Test
  void getByDemonym() {
    var countries = CountryServiceV4.getInstance().getByDemonym("chilean");
    assertFalse(countries.isEmpty());
    var result = countries.stream()
        .anyMatch(country -> country.getName().getCommon().equalsIgnoreCase("Chile"));
    assertTrue(result);
  }

  @Test
  void getByTranslation() {
    var countries = CountryServiceV4.getInstance().getByTranslation("Běloruská");
    assertFalse(countries.isEmpty());
    Assertions.assertEquals(1, countries.size());
    Assertions.assertEquals("Belarus", countries.stream().findFirst().get().getName().getCommon());
  }

  @Test
  void testFlags() {
    var countries = CountryServiceV4.getInstance().getAll();
    try {
      var result = countries.stream().noneMatch(
          country -> null == country.getFlags().getPng() || null == country.getFlags().getSvg()
              || null == country.getFlags().getAlt());
      assertTrue(result);
    } catch (Exception ex) {
      Assertions.fail();
    }
  }

  @Test
  void testGeolocation() {
    var countries = CountryServiceV4.getInstance().getAll();
    var countriesWithGeo = countries.stream()
        .filter(c -> c.getGeolocation() != null &&
            c.getGeolocation().getLatitude() != null &&
            c.getGeolocation().getLongitude() != null)
        .count();
    assertTrue(countriesWithGeo > 200);
  }

  @Test
  void testCurrenciesAsArray() {
    var countries = CountryServiceV4.getInstance().getByAlpha("US");
    assertFalse(countries.isEmpty());
    var us = countries.stream().findFirst().get();
    assertFalse(us.getCurrencies().isEmpty());
    var usd = us.getCurrencies().stream()
        .filter(c -> "USD".equals(c.getCode()))
        .findFirst();
    assertTrue(usd.isPresent());
    Assertions.assertEquals("United States dollar", usd.get().getName());
  }

  @Test
  void testLanguagesAsArray() {
    var countries = CountryServiceV4.getInstance().getByAlpha("CH");
    assertFalse(countries.isEmpty());
    var ch = countries.stream().findFirst().get();
    assertFalse(ch.getLanguages().isEmpty());
    var hasSwissGerman = ch.getLanguages().stream()
        .anyMatch(l -> "Swiss German".equals(l.getName()));
    assertTrue(hasSwissGerman);
  }

  @Test
  void testNativeNameAsArray() {
    var countries = CountryServiceV4.getInstance().getByAlpha("BE");
    assertFalse(countries.isEmpty());
    var be = countries.stream().findFirst().get();
    assertFalse(be.getName().getNativeName().isEmpty());
    var hasFrench = be.getName().getNativeName().stream()
        .anyMatch(nn -> "fra".equals(nn.getLang()));
    assertTrue(hasFrench);
  }

  @Test
  void testIndependent() {
    var countries = CountryServiceV4.getInstance().getIndependent(true);
    assertFalse(countries.isEmpty());
    var nonIndependent = CountryServiceV4.getInstance().getIndependent(false);
    assertFalse(nonIndependent.isEmpty());
  }
}
