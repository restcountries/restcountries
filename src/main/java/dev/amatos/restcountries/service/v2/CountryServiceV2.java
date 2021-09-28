/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
package dev.amatos.restcountries.service.v2;

import dev.amatos.restcountries.domain.v2.Country;
import dev.amatos.restcountries.domain.v2.Currency;
import dev.amatos.restcountries.domain.v2.Language;
import dev.amatos.restcountries.domain.v2.RegionalBloc;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

public class CountryServiceV2 extends CountryServiceBaseV2 {

  private static final Logger LOG = Logger.getLogger(CountryServiceV2.class);

  private static List<Country> countries;

  private CountryServiceV2() {
    initialize();
  }

  private static class InstanceHolder {

    private static final CountryServiceV2 INSTANCE = new CountryServiceV2();
  }

  public static CountryServiceV2 getInstance() {
    return InstanceHolder.INSTANCE;
  }

  public List<Country> getAll() {
    return countries;
  }

  public Country getByAlpha(String alpha) {
    return super.getByAlpha(alpha, countries);
  }

  public List<Country> getByCodeList(String codeList) {
    return (List<Country>) super.getByCodeList(codeList, countries);
  }

  @SuppressWarnings("unchecked")
  public List<Country> getByName(String name, boolean isFullText) {
    return (List<Country>) super.getByName(name, isFullText, countries);
  }

  @SuppressWarnings("unchecked")
  public List<Country> getByCallingCode(String callingcode) {
    return (List<Country>) super.getByCallingCode(callingcode, countries);
  }

  @SuppressWarnings("unchecked")
  public List<Country> getByCapital(String capital) {
    return (List<Country>) super.getByCapital(capital, countries);
  }

  @SuppressWarnings("unchecked")
  public List<Country> getByContinent(String region) {
    return (List<Country>) super.getByContinent(region, countries);
  }

  @SuppressWarnings("unchecked")
  public List<Country> getByRegion(String subregion) {
    return (List<Country>) super.getByRegion(subregion, countries);
  }

  public List<Country> getByCurrency(String currency) {
    List<Country> result = new ArrayList<>();
    for (Country country : countries) {
      for (Currency curr : country.getCurrencies()) {
        if (curr.getCode() != null && currency.toLowerCase().equals(curr.getCode().toLowerCase())) {
          result.add(country);
        }
      }
    }
    return result;
  }

  public List<Country> getByLanguage(String language) {
    List<Country> result = new ArrayList<>();
    if (language.length() == 2) {
      for (Country country : countries) {
        for (Language lang : country.getLanguages()) {
          if (language.toLowerCase().equals(lang.getIso639_1())) {
            result.add(country);
          }
        }
      }
    } else if (language.length() == 3) {
      for (Country country : countries) {
        for (Language lang : country.getLanguages()) {
          if (language.toLowerCase().equals(lang.getIso639_2())) {
            result.add(country);
          }
        }
      }
    }
    return result;
  }

  public List<Country> getByDemonym(String demonym) {
    List<Country> result = new ArrayList<>();
    for (Country country : countries) {
      if (country.getDemonym().toLowerCase().equals(normalize(demonym.toLowerCase()))) {
        result.add(country);
      }
    }
    return result;
  }

  public List<Country> getByRegionalBloc(String regionalBloc) {
    List<Country> result = new ArrayList<>();
    for (Country country : countries) {
      if (null != country.getRegionalBlocs()) {
        for (RegionalBloc countryRegionalBloc : country.getRegionalBlocs()) {
          if (getRegionalBlockMatch(countryRegionalBloc.getAcronym(),
              countryRegionalBloc.getOtherAcronyms(), regionalBloc)) {
            result.add(country);
          }
        }
      }
    }
    return result;
  }

  private boolean getRegionalBlockMatch(String acronym, List<String> otherAcronym,
      String regionalBlock) {
    return acronym != null && otherAcronym != null && ((acronym.equalsIgnoreCase(regionalBlock)
        || otherAcronym.contains(regionalBlock)));
  }

  @SuppressWarnings("unchecked")
  private void initialize() {
    countries = (List<Country>) super.loadJson("countriesV2.json", Country.class);
  }
}
