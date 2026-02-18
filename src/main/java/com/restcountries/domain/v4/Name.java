package com.restcountries.domain.v4;

import io.micronaut.serde.annotation.Serdeable;

import java.util.List;

@Serdeable.Serializable
public class Name {
  private String common;
  private String official;
  private List<NativeName> nativeName;

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

  public List<NativeName> getNativeName() {
    return nativeName;
  }

  public void setNativeName(List<NativeName> nativeName) {
    this.nativeName = nativeName;
  }
}
