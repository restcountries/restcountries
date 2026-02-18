package com.restcountries.domain.v4;

import com.restcountries.domain.base.BaseCountryCore;
import com.restcountries.domain.v3.v31.CapitalInformation;
import com.restcountries.domain.v3.v31.Flag;
import io.micronaut.serde.annotation.Serdeable;

import java.util.List;
import java.util.Map;

@Serdeable.Serializable
public class Country extends BaseCountryCore {

  private Name name;
  private List<Currency> currencies;
  private List<Language> languages;
  private List<Translation> translations;
  private List<Demonym> demonyms;
  private List<Gini> gini;
  private Flag flags;
  private Flag coatOfArms;
  private String startOfWeek;
  private CapitalInformation capitalInfo;
  private Map<String, String> postalCode;
  private Geolocation geolocation;
  private List<Religion> religion;
  private List<Ethnicity> ethnicity;
  private Government government;
  private Density density;
  private GDP gdp;
  private String nationalHoliday;
  private String anthem;
  private List<RegionalBloc> regionalBlocs;

  public Name getName() {
    return name;
  }

  public void setName(Name name) {
    this.name = name;
  }

  public List<Currency> getCurrencies() {
    return currencies;
  }

  public void setCurrencies(List<Currency> currencies) {
    this.currencies = currencies;
  }

  public List<Language> getLanguages() {
    return languages;
  }

  public void setLanguages(List<Language> languages) {
    this.languages = languages;
  }

  public List<Translation> getTranslations() {
    return translations;
  }

  public void setTranslations(List<Translation> translations) {
    this.translations = translations;
  }

  public List<Demonym> getDemonyms() {
    return demonyms;
  }

  public void setDemonyms(List<Demonym> demonyms) {
    this.demonyms = demonyms;
  }

  public List<Gini> getGini() {
    return gini;
  }

  public void setGini(List<Gini> gini) {
    this.gini = gini;
  }

  public Flag getFlags() {
    return flags;
  }

  public void setFlags(Flag flags) {
    this.flags = flags;
  }

  public Flag getCoatOfArms() {
    return coatOfArms;
  }

  public void setCoatOfArms(Flag coatOfArms) {
    this.coatOfArms = coatOfArms;
  }

  public String getStartOfWeek() {
    return startOfWeek;
  }

  public void setStartOfWeek(String startOfWeek) {
    this.startOfWeek = startOfWeek;
  }

  public CapitalInformation getCapitalInfo() {
    return capitalInfo;
  }

  public void setCapitalInfo(CapitalInformation capitalInfo) {
    this.capitalInfo = capitalInfo;
  }

  public Map<String, String> getPostalCode() {
    return postalCode;
  }

  public void setPostalCode(Map<String, String> postalCode) {
    this.postalCode = postalCode;
  }

  public Geolocation getGeolocation() {
    return geolocation;
  }

  public void setGeolocation(Geolocation geolocation) {
    this.geolocation = geolocation;
  }

  public List<Religion> getReligion() {
    return religion;
  }

  public void setReligion(List<Religion> religion) {
    this.religion = religion;
  }

  public List<Ethnicity> getEthnicity() {
    return ethnicity;
  }

  public void setEthnicity(List<Ethnicity> ethnicity) {
    this.ethnicity = ethnicity;
  }

  public Government getGovernment() {
    return government;
  }

  public void setGovernment(Government government) {
    this.government = government;
  }

  public Density getDensity() {
    return density;
  }

  public void setDensity(Density density) {
    this.density = density;
  }

  public GDP getGdp() {
    return gdp;
  }

  public void setGdp(GDP gdp) {
    this.gdp = gdp;
  }

  public String getNationalHoliday() {
    return nationalHoliday;
  }

  public void setNationalHoliday(String nationalHoliday) {
    this.nationalHoliday = nationalHoliday;
  }

  public String getAnthem() {
    return anthem;
  }

  public void setAnthem(String anthem) {
    this.anthem = anthem;
  }

  public List<RegionalBloc> getRegionalBlocs() {
    return regionalBlocs;
  }

  public void setRegionalBlocs(List<RegionalBloc> regionalBlocs) {
    this.regionalBlocs = regionalBlocs;
  }
}
