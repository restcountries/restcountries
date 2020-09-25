/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
package dev.amatos.restcountries.v2.domain;

import dev.amatos.restcountries.domain.BaseCountry;

import java.util.List;

public class Country extends BaseCountry {

    private List<dev.amatos.restcountries.v2.domain.Currency> currencies;
    private List<dev.amatos.restcountries.v2.domain.Language> languages;
    private dev.amatos.restcountries.v2.domain.Translations translations;
    private List<String> flags;
    private List<RegionalBloc> regionalBlocs;
    private String cioc;
    private boolean independent;

    public List<dev.amatos.restcountries.v2.domain.Currency> getCurrencies() {
        return currencies;
    }

    public List<dev.amatos.restcountries.v2.domain.Language> getLanguages() {
        return languages;
    }

    public dev.amatos.restcountries.v2.domain.Translations getTranslations() {
        return translations;
    }

    public List<String> getFlags() {
        return flags;
    }

    public List<RegionalBloc> getRegionalBlocs() {
        return regionalBlocs;
    }

    public String getCioc() {
        return cioc;
    }

    public boolean isIndependent() {
        return independent;
    }
}
