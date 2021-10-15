package dev.amatos.restcountries.domain.v3.v31;

import dev.amatos.restcountries.domain.base.BaseCountry;

public class Country extends BaseCountry {
  private Flag flags;
  private Flag coatOfArms;
  private String startOfWeek;

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
}
