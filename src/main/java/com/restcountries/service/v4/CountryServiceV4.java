package com.restcountries.service.v4;

import com.restcountries.domain.v4.Country;

import java.text.Normalizer;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class CountryServiceV4 extends CountryServiceBaseV4 {

  private static Set<Country> countries;

  private CountryServiceV4() {
    initialize();
  }

  private static class InstanceHolder {
    private static final CountryServiceV4 INSTANCE = new CountryServiceV4();
  }

  public static CountryServiceV4 getInstance() {
    return InstanceHolder.INSTANCE;
  }

  public Set<Country> getAll() {
    return countries;
  }

  public Set<Country> getByAlpha(String alpha) {
    return super.getByAlpha(alpha, countries);
  }

  public Set<Country> getByName(String name, boolean isFullText) {
    return super.getByName(name, isFullText, countries);
  }

  public Set<Country> getByCurrency(String currency) {
    return super.getByCurrency(currency, countries);
  }

  public Set<Country> getByCodeList(String codeList) {
    return super.getByCodeList(codeList, countries);
  }

  public Set<Country> getByCapital(String capital) {
    return super.getByCapital(capital, countries);
  }

  public Set<Country> getByRegion(String region) {
    return super.getByRegion(region, countries);
  }

  public Set<Country> getBySubregion(String subregion) {
    return super.getBySubregion(subregion, countries);
  }

  public Set<Country> getByLanguage(String language) {
    return super.getByLanguage(language, countries);
  }

  public Set<Country> getByDemonym(String demonym) {
    return super.getByDemonym(demonym, countries);
  }

  public Set<Country> getByTranslation(String translation) {
    return super.getByTranslation(translation, countries);
  }

  public Set<Country> getIndependent(boolean status) {
    return countries.stream().filter(country -> {
      var independent = Boolean.TRUE.equals(country.getIndependent());
      return independent == status;
    }).collect(Collectors.toSet());
  }

  @Override
  protected String normalize(String string) {
    return Normalizer.normalize(string, Normalizer.Form.NFD)
        .replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
  }

  private void initialize() {
    countries = super.loadJson("countriesV4.json");
  }
}
