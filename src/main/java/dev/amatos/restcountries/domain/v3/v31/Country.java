package dev.amatos.restcountries.domain.v3.v31;

import dev.amatos.restcountries.domain.base.BaseCountry;

public class Country extends BaseCountry {
  private Flag flags;

  public Flag getFlags() {
    return flags;
  }

  public void setFlags(Flag flags) {
    this.flags = flags;
  }
}
