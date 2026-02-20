package com.restcountries.domain.v4;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable.Serializable
public class NativeName {
  private String lang;
  private String official;
  private String common;

  public String getLang() {
    return lang;
  }

  public void setLang(String lang) {
    this.lang = lang;
  }

  public String getOfficial() {
    return official;
  }

  public void setOfficial(String official) {
    this.official = official;
  }

  public String getCommon() {
    return common;
  }

  public void setCommon(String common) {
    this.common = common;
  }
}
