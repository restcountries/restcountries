package com.restcountries.domain.v4;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable.Serializable
public class GDP {
  private Long total;
  private Long perCapita;
  private String currency;

  public Long getTotal() {
    return total;
  }

  public void setTotal(Long total) {
    this.total = total;
  }

  public Long getPerCapita() {
    return perCapita;
  }

  public void setPerCapita(Long perCapita) {
    this.perCapita = perCapita;
  }

  public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }
}
