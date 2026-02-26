package com.restcountries;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class V4JsonStructureTest {

  private static final Logger log = LoggerFactory.getLogger(V4JsonStructureTest.class);
  private static JsonArray countries;

  @BeforeAll
  static void loadJson() {
    var is = V4JsonStructureTest.class.getClassLoader().getResourceAsStream("countriesV4.json");
    assertNotNull(is, "countriesV4.json not found");
    countries = JsonParser.parseReader(new InputStreamReader(is, StandardCharsets.UTF_8)).getAsJsonArray();
  }

  @Test
  void testAllCountriesLoaded() {
    assertTrue(countries.size() >= 200, "Should have at least 200 countries");
  }

  @Test
  void testRequiredFields() {
    for (JsonElement el : countries) {
      JsonObject c = el.getAsJsonObject();
      assertTrue(c.has("name"), "Missing name field");
      assertTrue(c.has("cca2"), "Missing cca2 field");
      assertTrue(c.has("cca3"), "Missing cca3 field");
      assertTrue(c.has("region"), "Missing region field");
    }
  }

  @Test
  void testNameStructure() {
    for (JsonElement el : countries) {
      JsonObject c = el.getAsJsonObject();
      JsonObject name = c.getAsJsonObject("name");
      assertNotNull(name, "name should be an object");

      assertTrue(name.has("common") && !name.get("common").isJsonNull(),
          "name.common should not be null for " + c.get("cca2"));
      assertTrue(name.has("official") && !name.get("official").isJsonNull(),
          "name.official should not be null for " + c.get("cca2"));

      String common = name.get("common").getAsString();
      String official = name.get("official").getAsString();
      assertFalse(common.isEmpty(), "name.common should not be empty");
      assertFalse(official.isEmpty(), "name.official should not be empty");

      assertTrue(name.has("nativeName"), "name.nativeName should exist");
      assertTrue(name.get("nativeName").isJsonArray(),
          "name.nativeName should be an array for " + c.get("cca2"));

      for (JsonElement nn : name.getAsJsonArray("nativeName")) {
        assertTrue(nn.isJsonObject(), "nativeName entry should be object");
        JsonObject nnObj = nn.getAsJsonObject();
        assertTrue(nnObj.has("lang"), "nativeName entry should have lang");
        assertTrue(nnObj.has("official"), "nativeName entry should have official");
        assertTrue(nnObj.has("common"), "nativeName entry should have common");
      }
    }
  }

  @Test
  void testCurrenciesStructure() {
    for (JsonElement el : countries) {
      JsonObject c = el.getAsJsonObject();
      assertTrue(c.has("currencies"), "Missing currencies for " + c.get("cca2"));
      assertTrue(c.get("currencies").isJsonArray(),
          "currencies should be an array for " + c.get("cca2"));

      for (JsonElement curr : c.getAsJsonArray("currencies")) {
        assertTrue(curr.isJsonObject(), "currency entry should be object");
        JsonObject currObj = curr.getAsJsonObject();
        assertTrue(currObj.has("code"), "currency entry should have code");
        assertTrue(currObj.has("name"), "currency entry should have name");
        assertTrue(currObj.has("symbol"), "currency entry should have symbol");
      }
    }
  }

  @Test
  void testLanguagesStructure() {
    for (JsonElement el : countries) {
      JsonObject c = el.getAsJsonObject();
      assertTrue(c.has("languages"), "Missing languages for " + c.get("cca2"));
      assertTrue(c.get("languages").isJsonArray(),
          "languages should be an array for " + c.get("cca2"));

      for (JsonElement lang : c.getAsJsonArray("languages")) {
        assertTrue(lang.isJsonObject(), "language entry should be object");
        JsonObject langObj = lang.getAsJsonObject();
        assertTrue(langObj.has("iso639_1"), "language entry should have iso639_1");
        assertTrue(langObj.has("iso639_2"), "language entry should have iso639_2");
        assertTrue(langObj.has("name"), "language entry should have name");
        assertTrue(langObj.has("nativeName"), "language entry should have nativeName");
      }
    }
  }

  @Test
  void testGeolocationStructure() {
    for (JsonElement el : countries) {
      JsonObject c = el.getAsJsonObject();
      assertTrue(c.has("geolocation"), "Missing geolocation for " + c.get("cca2"));
      if (!c.get("geolocation").isJsonNull()) {
        JsonObject geo = c.getAsJsonObject("geolocation");
        assertTrue(geo.has("latitude"), "geolocation should have latitude");
        assertTrue(geo.has("longitude"), "geolocation should have longitude");
      }
    }
  }

  @Test
  void testReligionStructure() {
    for (JsonElement el : countries) {
      JsonObject c = el.getAsJsonObject();
      assertTrue(c.has("religion"), "Missing religion for " + c.get("cca2"));
      assertTrue(c.get("religion").isJsonArray(),
          "religion should be an array for " + c.get("cca2"));

      for (JsonElement r : c.getAsJsonArray("religion")) {
        assertTrue(r.isJsonObject(), "religion entry should be object");
        JsonObject rObj = r.getAsJsonObject();
        assertTrue(rObj.has("name"), "religion entry should have name");
        assertTrue(rObj.has("population"), "religion entry should have population");
        assertTrue(rObj.has("percentage"), "religion entry should have percentage");
      }
    }
  }

  @Test
  void testEthnicityStructure() {
    for (JsonElement el : countries) {
      JsonObject c = el.getAsJsonObject();
      assertTrue(c.has("ethnicity"), "Missing ethnicity for " + c.get("cca2"));
      assertTrue(c.get("ethnicity").isJsonArray(),
          "ethnicity should be an array for " + c.get("cca2"));

      for (JsonElement e : c.getAsJsonArray("ethnicity")) {
        assertTrue(e.isJsonObject(), "ethnicity entry should be object");
        JsonObject eObj = e.getAsJsonObject();
        if(!eObj.has("percentage")) {
          log.error("name: {}", e.toString());
        }
        assertTrue(eObj.has("name"), "ethnicity entry should have name");
        assertTrue(eObj.has("percentage"), "ethnicity entry should have percentage");
      }
    }
  }

  @Test
  void testGovernmentStructure() {
    for (JsonElement el : countries) {
      JsonObject c = el.getAsJsonObject();
      assertTrue(c.has("government"), "Missing government for " + c.get("cca2"));
      if (!c.get("government").isJsonNull()) {
        JsonObject gov = c.getAsJsonObject("government");
        assertTrue(gov.has("type"), "government should have type");
        assertTrue(gov.has("leaders"), "government should have leaders");
        assertTrue(gov.get("leaders").isJsonArray(), "leaders should be an array");
        for (JsonElement l : gov.getAsJsonArray("leaders")) {
          assertTrue(l.isJsonObject(), "leader entry should be an object");
          JsonObject leader = l.getAsJsonObject();
          assertTrue(leader.has("title"), "leader should have title");
          assertTrue(leader.has("name"), "leader should have name");
        }
      }
    }
  }

  @Test
  void testGdpStructure() {
    for (JsonElement el : countries) {
      JsonObject c = el.getAsJsonObject();
      assertTrue(c.has("gdp"), "Missing gdp for " + c.get("cca2"));
      if (!c.get("gdp").isJsonNull()) {
        JsonObject gdp = c.getAsJsonObject("gdp");
        assertTrue(gdp.has("total"), "gdp should have total");
        assertTrue(gdp.has("perCapita"), "gdp should have perCapita");
      }
    }
  }

  @Test
  void testGiniStructure() {
    for (JsonElement el : countries) {
      JsonObject c = el.getAsJsonObject();
      assertTrue(c.has("gini"), "Missing gini for " + c.get("cca2"));
      assertTrue(c.get("gini").isJsonArray(),
          "gini should be an array for " + c.get("cca2"));

      for (JsonElement g : c.getAsJsonArray("gini")) {
        assertTrue(g.isJsonObject(), "gini entry should be object");
        JsonObject gObj = g.getAsJsonObject();
        assertTrue(gObj.has("year"), "gini entry should have year");
        assertTrue(gObj.has("value"), "gini entry should have value");
      }
    }
  }

  @Test
  void testTranslationsStructure() {
    for (JsonElement el : countries) {
      JsonObject c = el.getAsJsonObject();
      assertTrue(c.has("translations"), "Missing translations for " + c.get("cca2"));
      assertTrue(c.get("translations").isJsonArray(),
          "translations should be an array for " + c.get("cca2"));

      for (JsonElement t : c.getAsJsonArray("translations")) {
        assertTrue(t.isJsonObject(), "translation entry should be object");
        JsonObject tObj = t.getAsJsonObject();
        assertTrue(tObj.has("lang"), "translation entry should have lang");
        assertTrue(tObj.has("official"), "translation entry should have official");
        assertTrue(tObj.has("common"), "translation entry should have common");
      }
    }
  }

  @Test
  void testDemonymsStructure() {
    for (JsonElement el : countries) {
      JsonObject c = el.getAsJsonObject();
      assertTrue(c.has("demonyms"), "Missing demonyms for " + c.get("cca2"));
      assertTrue(c.get("demonyms").isJsonArray(),
          "demonyms should be an array for " + c.get("cca2"));

      for (JsonElement d : c.getAsJsonArray("demonyms")) {
        assertTrue(d.isJsonObject(), "demonym entry should be object");
        JsonObject dObj = d.getAsJsonObject();
        assertTrue(dObj.has("lang"), "demonym entry should have lang");
        assertTrue(dObj.has("male"), "demonym entry should have male");
        assertTrue(dObj.has("female"), "demonym entry should have female");
      }
    }
  }

  @Test
  void testArrayFieldsAreArrays() {
    for (JsonElement el : countries) {
      JsonObject c = el.getAsJsonObject();
      assertIsArrayIfPresent(c, "currencies");
      assertIsArrayIfPresent(c, "languages");
      assertIsArrayIfPresent(c, "gini");
      assertIsArrayIfPresent(c, "translations");
      assertIsArrayIfPresent(c, "demonyms");
      assertIsArrayIfPresent(c, "religion");
      assertIsArrayIfPresent(c, "ethnicity");
      assertIsArrayIfPresent(c, "regionalBlocs");
      assertIsArrayIfPresent(c, "callingCodes");
      assertIsArrayIfPresent(c, "timezones");
      assertIsArrayIfPresent(c, "borders");
      assertIsArrayIfPresent(c, "continents");
    }
  }

  @Test
  void testCca2CodeLength() {
    for (JsonElement el : countries) {
      JsonObject c = el.getAsJsonObject();
      if (c.has("cca2") && !c.get("cca2").isJsonNull()) {
        String cca2 = c.get("cca2").getAsString();
        assertEquals(2, cca2.length(), "cca2 should be 2 chars: " + cca2);
      }
    }
  }

  @Test
  void testCca3CodeLength() {
    for (JsonElement el : countries) {
      JsonObject c = el.getAsJsonObject();
      if (c.has("cca3") && !c.get("cca3").isJsonNull()) {
        String cca3 = c.get("cca3").getAsString();
        assertEquals(3, cca3.length(), "cca3 should be 3 chars: " + cca3);
      }
    }
  }

  @Test
  void testNoDuplicateCca2() {
    Set<String> seen = new HashSet<>();
    for (JsonElement el : countries) {
      JsonObject c = el.getAsJsonObject();
      if (c.has("cca2") && !c.get("cca2").isJsonNull()) {
        String cca2 = c.get("cca2").getAsString();
        assertTrue(seen.add(cca2), "Duplicate cca2: " + cca2);
      }
    }
  }

  @Test
  void testNoDuplicateCca3() {
    Set<String> seen = new HashSet<>();
    for (JsonElement el : countries) {
      JsonObject c = el.getAsJsonObject();
      if (c.has("cca3") && !c.get("cca3").isJsonNull()) {
        String cca3 = c.get("cca3").getAsString();
        assertTrue(seen.add(cca3), "Duplicate cca3: " + cca3);
      }
    }
  }

  @Test
  void testFlagStructure() {
    for (JsonElement el : countries) {
      JsonObject c = el.getAsJsonObject();
      assertTrue(c.has("flag"), "Missing flag for " + c.get("cca2"));
      assertFalse(c.get("flag").isJsonNull(), "flag should not be null for " + c.get("cca2"));
      assertTrue(c.get("flag").isJsonObject(), "flag should be an object for " + c.get("cca2"));
      JsonObject flag = c.getAsJsonObject("flag");
      assertTrue(flag.has("svg"), "flag should have svg for " + c.get("cca2"));
      assertTrue(flag.has("png"), "flag should have png for " + c.get("cca2"));
      assertTrue(flag.has("alt"), "flag should have alt for " + c.get("cca2"));
      assertTrue(flag.has("emoji"), "flag should have emoji for " + c.get("cca2"));
      assertFalse(flag.get("emoji").getAsString().isEmpty(), "flag.emoji should not be empty for " + c.get("cca2"));
    }
  }

  @Test
  void testSovereignStateField() {
    for (JsonElement el : countries) {
      JsonObject c = el.getAsJsonObject();
      if (c.has("sovereignState")) {
        assertFalse(c.get("sovereignState").isJsonNull(), "sovereignState should not be null for " + c.get("cca2"));
      }
    }
  }

  private void assertIsArrayIfPresent(JsonObject obj, String field) {
    if (obj.has(field) && !obj.get(field).isJsonNull()) {
      assertTrue(obj.get(field).isJsonArray(),
          field + " should be an array for " + obj.get("cca2"));
    }
  }
}
