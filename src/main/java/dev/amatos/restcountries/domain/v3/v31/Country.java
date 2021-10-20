package dev.amatos.restcountries.domain.v3.v31;

import dev.amatos.restcountries.domain.base.BaseCountry;
import java.util.Map;

public class Country extends BaseCountry {
  private Flag flags;
  private Flag coatOfArms;
  private String startOfWeek;
  private CapitalInformation capitalInfo;
  private Map<String, String> postalCode;

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
}
