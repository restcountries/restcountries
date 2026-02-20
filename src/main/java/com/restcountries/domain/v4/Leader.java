package com.restcountries.domain.v4;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable.Serializable
public class Leader {
  private String title;
  private String name;

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
