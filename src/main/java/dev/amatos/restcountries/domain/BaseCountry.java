package dev.amatos.restcountries.domain;

import java.util.List;
import java.util.Map;

public class BaseCountry {

  protected String name;

  private List<String> topLevelDomain;

  protected String alpha2Code;

  private String alpha3Code;

  private List<String> callingCodes;

  protected String capital;

  private List<String> altSpellings;

  protected String subregion;

  protected String region;

  protected Integer population;

  private List<Double> latlng;

  private String demonym;

  private Double area;

  protected Double gini;

  private List<String> timezones;

  protected List<String> borders;

  protected String nativeName;

  private String numericCode;

  private Map<String, String> flags;

  public String getName() {
    return name;
  }

  public List<String> getTopLevelDomain() {
    return topLevelDomain;
  }

  public String getAlpha2Code() {
    return alpha2Code;
  }

  public String getAlpha3Code() {
    return alpha3Code;
  }

  public List<String> getCallingCodes() {
    return callingCodes;
  }

  public String getCapital() {
    return capital;
  }

  public List<String> getAltSpellings() {
    return altSpellings;
  }

  public String getSubregion() {
    return subregion;
  }

  public String getRegion() {
    return region;
  }

  public Integer getPopulation() {
    return population;
  }

  public List<Double> getLatlng() {
    return latlng;
  }

  public String getDemonym() {
    return demonym;
  }

  public Double getArea() {
    return area;
  }

  public Double getGini() {
    return gini;
  }

  public List<String> getTimezones() {
    return timezones;
  }

  public List<String> getBorders() {
    return borders;
  }

  public String getNativeName() {
    return nativeName;
  }

  public String getNumericCode() {
    return numericCode;
  }

  public Map<String, String> getFlags() {
    return flags;
  }

  public void setFlags(Map<String, String> flags) {
    this.flags = flags;
  }
}
