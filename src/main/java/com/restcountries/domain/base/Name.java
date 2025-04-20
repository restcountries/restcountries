package com.restcountries.domain.base;

import io.micronaut.serde.annotation.Serdeable;

import java.util.List;
import java.util.Map;

@Serdeable.Serializable
public class Name {
  private String common;
  private String official;
  private Map<String, NativeName> nativeName;

  private List<String> altSpellings;

  public String getCommon() {
    return common;
  }

  public void setCommon(String common) {
    this.common = common;
  }

  public String getOfficial() {
    return official;
  }

  public void setOfficial(String official) {
    this.official = official;
  }

  public Map<String, NativeName> getNativeName() {
    return nativeName;
  }

  public void setNativeName(
      Map<String, NativeName> nativeName) {
    this.nativeName = nativeName;
  }

  public List<String> getAltSpellings() {
    return altSpellings;
  }

  public void setAltSpellings(List<String> altSpellings) {
    this.altSpellings = altSpellings;
  }
}
