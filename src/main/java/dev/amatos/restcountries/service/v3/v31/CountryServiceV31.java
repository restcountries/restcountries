/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
package dev.amatos.restcountries.service.v3.v31;

import dev.amatos.restcountries.domain.v3.v31.Country;
import dev.amatos.restcountries.service.v3.CountryServiceBaseV3;
import java.text.Normalizer;
import java.util.HashSet;
import java.util.Set;

public class CountryServiceV31 extends CountryServiceBaseV3 {

  private static Set<Country> countries;

  private CountryServiceV31() {
    initialize();
  }

  private static class InstanceHolder {

    private static final CountryServiceV31 INSTANCE = new CountryServiceV31();
  }

  public static CountryServiceV31 getInstance() {
    return CountryServiceV31.InstanceHolder.INSTANCE;
  }

  public Set<Country> getAll() {
    return countries;
  }

  public Set<Country> getByAlpha(String alpha) {
    return super.getByAlpha(alpha, countries);
  }

  public Set<Country> getByName(String name, boolean isFullText) {
    return (Set<Country>) super.getByName(name, isFullText, countries);
  }

  public Set<Country> getByCurrency(String currency) {
    return (Set<Country>) super.getByCurrency(currency, countries);
  }

  public Set<Country> getByCodeList(String codeList) {
    return (Set<Country>) super.getByCodeList(codeList, countries);
  }

  public Set<Country> getByCapital(String capital) {
    return (Set<Country>) super.getByCapital(capital, countries);
  }

  public Set<Country> getByRegion(String region) {
    return (Set<Country>) super.getByRegion(region, countries);
  }

  public Set<Country> getBySubregion(String subregion) {
    return (Set<Country>) super.getBySubregion(subregion, countries);
  }

  public Set<Country> getByLanguage(String language) {
    return (Set<Country>) super.getByLanguage(language, countries);
  }

  public Set<Country> getByDemonym(String demonym) {
    return (Set<Country>) super.getByDemonym(demonym, countries);
  }

  public Set<Country> getByTranslation(String translation) {
    Set<Country> result = new HashSet<>();
    for (Country country : countries) {
      country.getTranslations().forEach((key, values) -> values.forEach((k, v) -> {
        if (v.toLowerCase().contains(translation.toLowerCase())) {
          result.add(country);
        }
      }));
    }
    return result;
  }

  protected String normalize(String string) {
    return Normalizer.normalize(string, Normalizer.Form.NFD)
        .replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
  }

  private void initialize() {
    countries = (Set<Country>) super.loadJson("countriesV3.1.json", Country.class);
  }
}
