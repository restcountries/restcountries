package com.restcountries.domain.base;

import io.micronaut.serde.annotation.Serdeable;

import java.util.List;
import java.util.Map;

@Serdeable.Serializable
public class BaseCountry extends BaseCountryCore {

  private String flag;
  private Name name;
  private Map<String, Currency> currencies;
  private Map<String, String> languages;
  private Map<String, Map<String, String>> translations;
  private List<Double> latlng;
  private Map<String, Map<String, String>> demonyms;
  private Map<String, Double> gini;

  public String getFlag() {
    return flag;
  }

  public void setFlag(String flag) {
    this.flag = flag;
  }

  public Name getName() {
    return name;
  }

  public void setName(Name name) {
    this.name = name;
  }

  public Map<String, Currency> getCurrencies() {
    return currencies;
  }

  public void setCurrencies(
      Map<String, Currency> currencies) {
    this.currencies = currencies;
  }

  public Map<String, String> getLanguages() {
    return languages;
  }

  public void setLanguages(Map<String, String> languages) {
    this.languages = languages;
  }

  public List<Double> getLatlng() {
    return latlng;
  }

  public void setLatlng(List<Double> latlng) {
    this.latlng = latlng;
  }

  public Map<String, Map<String, String>> getDemonyms() {
    return demonyms;
  }

  public void setDemonyms(
      Map<String, Map<String, String>> demonyms) {
    this.demonyms = demonyms;
  }

  @Override
  public String toString() {
    return "Country{" + "\n" +
        "NativeName=" + name.getNativeName() + "\n" +
        "Common=" + name.getCommon() + "\n" +
        "Official=" + name.getOfficial() + "\n" +
        ", tld=" + getTld() + "\n" +
        ", cca2='" + getCca2() + '\'' + "\n" +
        ", ccn3='" + getCcn3() + '\'' + "\n" +
        ", cioc='" + getCioc() + '\'' + "\n" +
        ", independent=" + getIndependent() + "\n" +
        ", status='" + getStatus() + '\'' + "\n" +
        ", unMember=" + getUnMember() + "\n" +
        ", currencies=" + currencies + "\n" +
        ", idd=" + getIdd() + "\n" +
        ", capital=" + getCapital() + "\n" +
        ", altSpelling=" + getAltSpellings() + "\n" +
        ", region='" + getRegion() + '\'' + "\n" +
        ", subregion='" + getSubregion() + '\'' + "\n" +
        ", language=" + languages + "\n" +
        ", latlng=" + latlng + "\n" +
        ", landlocked=" + getLandlocked() + "\n" +
        ", borders=" + getBorders() + "\n" +
        ", area=" + getArea() + "\n" +
        ", demonyms=" + demonyms + "\n" +
        '}';
  }

  public Map<String, Map<String, String>> getTranslations() {
    return translations;
  }

  public void setTranslations(Map<String, Map<String, String>> translations) {
    this.translations = translations;
  }

  public Map<String, Double> getGini() {
    return gini;
  }

  public void setGini(Map<String, Double> gini) {
    this.gini = gini;
  }
}
