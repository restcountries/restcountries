package dev.amatos.restcountries.domain.base;

import java.util.List;
import java.util.Map;

public class BaseCountry {

  private Name name;
  private List<String> tld;
  private String cca2;
  private String ccn3;
  private String cca3;
  private String cioc;
  private Boolean independent;
  private String status;
  private Boolean unMember;
  private Map<String, Currency> currencies;
  private Idd idd;
  private List<String> capital;
  private List<String> altSpellings;
  private String region;
  private String subregion;
  private Map<String, String> languages;
  private Map<String, Map<String, String>> translations;
  private List<Double> latlng;
  private Boolean landlocked;
  private List<String> borders;
  private Double area;
  private Map<String, Map<String, String>> demonyms;
  private List<String> callingCodes;
  private String flag;
  private Map<String, String> maps;
  private Integer population;
  private Map<String, Double> gini;
  private String fifa;
  private Car car;
  private List<String> timezones;
  private List<String> continents;

  public Name getName() {
    return name;
  }

  public void setName(Name name) {
    this.name = name;
  }

  public List<String> getTld() {
    return tld;
  }

  public void setTld(List<String> tld) {
    this.tld = tld;
  }

  public String getCca2() {
    return cca2;
  }

  public void setCca2(String cca2) {
    this.cca2 = cca2;
  }

  public String getCcn3() {
    return ccn3;
  }

  public void setCcn3(String ccn3) {
    this.ccn3 = ccn3;
  }

  public String getCioc() {
    return cioc;
  }

  public void setCioc(String cioc) {
    this.cioc = cioc;
  }

  public Boolean getIndependent() {
    return independent;
  }

  public void setIndependent(Boolean independent) {
    this.independent = independent;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public Boolean getUnMember() {
    return unMember;
  }

  public void setUnMember(Boolean unMember) {
    this.unMember = unMember;
  }

  public Map<String, Currency> getCurrencies() {
    return currencies;
  }

  public void setCurrencies(
      Map<String, Currency> currencies) {
    this.currencies = currencies;
  }

  public Idd getIdd() {
    return idd;
  }

  public void setIdd(Idd idd) {
    this.idd = idd;
  }

  public List<String> getCapital() {
    return capital;
  }

  public void setCapital(List<String> capital) {
    this.capital = capital;
  }

  public List<String> getAltSpellings() {
    return altSpellings;
  }

  public void setAltSpellings(List<String> altSpellings) {
    this.altSpellings = altSpellings;
  }

  public String getRegion() {
    return region;
  }

  public void setRegion(String region) {
    this.region = region;
  }

  public String getSubregion() {
    return subregion;
  }

  public void setSubregion(String subregion) {
    this.subregion = subregion;
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

  public Boolean getLandlocked() {
    return landlocked;
  }

  public void setLandlocked(Boolean landlocked) {
    this.landlocked = landlocked;
  }

  public List<String> getBorders() {
    return borders;
  }

  public void setBorders(List<String> borders) {
    this.borders = borders;
  }

  public Double getArea() {
    return area;
  }

  public void setArea(Double area) {
    this.area = area;
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
        ", tld=" + tld + "\n" +
        ", cca2='" + cca2 + '\'' + "\n" +
        ", ccn3='" + ccn3 + '\'' + "\n" +
        ", cioc='" + cioc + '\'' + "\n" +
        ", independent=" + independent + "\n" +
        ", status='" + status + '\'' + "\n" +
        ", unMember=" + unMember + "\n" +
        ", currencies=" + currencies + "\n" +
        ", idd=" + idd + "\n" +
        ", capital=" + capital + "\n" +
        ", altSpelling=" + altSpellings + "\n" +
        ", region='" + region + '\'' + "\n" +
        ", subregion='" + subregion + '\'' + "\n" +
        ", language=" + languages + "\n" +
        ", latlng=" + latlng + "\n" +
        ", landlocked=" + landlocked + "\n" +
        ", borders=" + borders + "\n" +
        ", area=" + area + "\n" +
        ", demonyms=" + demonyms + "\n" +
        '}';
  }

  public String getCca3() {
    return cca3;
  }

  public void setCca3(String cca3) {
    this.cca3 = cca3;
  }

  public Map<String, Map<String, String>> getTranslations() {
    return translations;
  }

  public void setTranslations(Map<String, Map<String, String>> translations) {
    this.translations = translations;
  }

  public List<String> getCallingCodes() {
    return callingCodes;
  }

  public void setCallingCodes(List<String> callingCodes) {
    this.callingCodes = callingCodes;
  }

  public String getFlag() {
    return flag;
  }

  public void setFlag(String flag) {
    this.flag = flag;
  }

  public Map<String, String> getMaps() {
    return maps;
  }

  public void setMaps(Map<String, String> maps) {
    this.maps = maps;
  }

  public Integer getPopulation() {
    return population;
  }

  public void setPopulation(Integer population) {
    this.population = population;
  }

  public Map<String, Double> getGini() {
    return gini;
  }

  public void setGini(Map<String, Double> gini) {
    this.gini = gini;
  }

  public String getFifa() {
    return fifa;
  }

  public void setFifa(String fifa) {
    this.fifa = fifa;
  }

  public Car getCar() {
    return car;
  }

  public void setCar(Car car) {
    this.car = car;
  }

  public List<String> getTimezones() {
    return timezones;
  }

  public void setTimezones(List<String> timezones) {
    this.timezones = timezones;
  }

  public List<String> getContinents() {
    return continents;
  }

  public void setContinents(List<String> continents) {
    this.continents = continents;
  }
}
