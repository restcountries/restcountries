package dev.amatos.restcountries.domain.v3.v31;

import dev.amatos.restcountries.domain.base.BaseCountry;
import java.util.Map;

public class Country extends BaseCountry {
  private Map<String, String> flags;


  public Map<String, String> getFlags() {
    return flags;
  }

  public void setFlags(Map<String, String> flags) {
    this.flags = flags;
  }

}
