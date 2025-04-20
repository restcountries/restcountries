package com.restcountries.domain.v2;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable.Serializable
public class Maps {
    private String gmaps;
    private String openstreetmap;

    public String getGmaps() {
        return gmaps;
    }

    public void setGmaps(String gmaps) {
        this.gmaps = gmaps;
    }

    public String getOpenstreetmap() {
        return openstreetmap;
    }

    public void setOpenstreetmap(String openstreetmap) {
        this.openstreetmap = openstreetmap;
    }
}
