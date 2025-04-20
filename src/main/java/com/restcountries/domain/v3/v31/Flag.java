package com.restcountries.domain.v3.v31;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable.Serializable
public class Flag {
  private String png;
  private String svg;
  private String alt;

  public String getPng() {
    return png;
  }

  public void setPng(String png) {
    this.png = png;
  }

  public String getSvg() {
    return svg;
  }

  public void setSvg(String svg) {
    this.svg = svg;
  }

  public String getAlt() {
    return alt;
  }

  public void setAlt(String alt) {
    this.alt = alt;
  }
}
