package com.restcountries.domain.base;

import io.micronaut.serde.annotation.Serdeable;

import java.util.List;
import java.util.Map;

@Serdeable.Serializable
public abstract class BaseCountryCore {

  private List<String> tld;
  private String cca2;
  private String ccn3;
  private String cca3;
  private String cioc;
  private Boolean independent;
  private String status;
  private Boolean unMember;
  private Idd idd;
  private List<String> capital;
  private List<String> altSpellings;
  private String region;
  private String subregion;
  private Boolean landlocked;
  private List<String> borders;
  private Double area;
  private List<String> callingCodes;
  private String flag;
  private Map<String, String> maps;
  private Integer population;
  private String fifa;
  private Car car;
  private List<String> timezones;
  private List<String> continents;

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

  public String getCca3() {
    return cca3;
  }

  public void setCca3(String cca3) {
    this.cca3 = cca3;
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
