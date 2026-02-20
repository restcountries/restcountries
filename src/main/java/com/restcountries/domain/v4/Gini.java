package com.restcountries.domain.v4;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable.Serializable
public class Gini {
  private String year;
  private Double value;

  public String getYear() {
    return year;
  }

  public void setYear(String year) {
    this.year = year;
  }

  public Double getValue() {
    return value;
  }

  public void setValue(Double value) {
    this.value = value;
  }
}
