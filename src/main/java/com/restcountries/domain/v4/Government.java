package com.restcountries.domain.v4;

import io.micronaut.serde.annotation.Serdeable;

import java.util.List;

@Serdeable.Serializable
public class Government {
  private String type;
  private List<Leader> leaders;

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public List<Leader> getLeaders() {
    return leaders;
  }

  public void setLeaders(List<Leader> leaders) {
    this.leaders = leaders;
  }
}
