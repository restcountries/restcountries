package com.restcountries.domain.base;

import io.micronaut.serde.annotation.Serdeable;

import java.util.List;

@Serdeable.Serializable
public class Car {
  private List<String> signs;
  private String side;

  public List<String> getSigns() {
    return signs;
  }

  public void setSigns(List<String> signs) {
    this.signs = signs;
  }

  public String getSide() {
    return side;
  }

  public void setSide(String side) {
    this.side = side;
  }
}
