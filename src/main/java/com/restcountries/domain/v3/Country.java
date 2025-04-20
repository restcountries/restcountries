package com.restcountries.domain.v3;

import com.restcountries.domain.base.BaseCountry;
import io.micronaut.serde.annotation.Serdeable;

import java.util.List;

@Serdeable.Serializable
public class Country extends BaseCountry {
  private List<String> flags;

  public List<String> getFlags() {
    return flags;
  }

  public void setFlags(List<String> flags) {
    this.flags = flags;
  }
}
