package com.restcountries.domain.v4;

import io.micronaut.serde.annotation.Serdeable;

import java.util.ArrayList;
import java.util.List;

@Serdeable.Serializable
public class RegionalBloc {
  private String acronym;
  private String name;
  private List<String> otherNames;

  public String getAcronym() {
    return acronym;
  }

  public void setAcronym(String acronym) {
    this.acronym = acronym;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<String> getOtherNames() {
    if (otherNames == null) {
      otherNames = new ArrayList<>();
    }
    return otherNames;
  }

  public void setOtherNames(List<String> otherNames) {
    this.otherNames = otherNames;
  }
}
