package dev.amatos.restcountries.domain.v3;

import dev.amatos.restcountries.domain.base.BaseCountry;
import java.util.List;
import java.util.Map;

public class Country extends BaseCountry {
  private List<String> flags;
  private Map<String, String> maps;

  public List<String> getFlags() {
    return flags;
  }

  public void setFlags(List<String> flags) {
    this.flags = flags;
  }

  public Map<String, String> getMaps() {
    return maps;
  }

  public void setMaps(Map<String, String> maps) {
    this.maps = maps;
  }
}
