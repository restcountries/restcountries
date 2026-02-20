package com.restcountries.domain.v4;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable.Serializable
public class Demonym {
  private String lang;
  private String male;
  private String female;

  public String getLang() {
    return lang;
  }

  public void setLang(String lang) {
    this.lang = lang;
  }

  public String getMale() {
    return male;
  }

  public void setMale(String male) {
    this.male = male;
  }

  public String getFemale() {
    return female;
  }

  public void setFemale(String female) {
    this.female = female;
  }
}
