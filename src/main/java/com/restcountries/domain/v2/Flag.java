package com.restcountries.domain.v2;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable.Serializable
public class Flag {
  private String svg;
  private String png;

  public String getSvg() {
    return svg;
  }

  public void setSvg(String svg) {
    this.svg = svg;
  }

  public String getPng() {
    return png;
  }

  public void setPng(String png) {
    this.png = png;
  }
}
