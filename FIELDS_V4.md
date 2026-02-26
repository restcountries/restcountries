# REST Countries API — v4 Field Reference

Complete reference for all fields returned by the v4 API (`/v4`). The v4 API restructures several fields from previous versions and introduces new demographic, economic, cultural, and geographic data.

---

## Quick Reference Table

| Field             | Type           | Description                                 |
| ----------------- | -------------- | ------------------------------------------- |
| `name`            | Object         | Country name (common, official, nativeName) |
| `tld`             | List\<String\> | Top-level internet domains                  |
| `cca2`            | String         | ISO 3166-1 alpha-2 two-letter code          |
| `ccn3`            | String         | ISO 3166-1 numeric code (UN M49)            |
| `cca3`            | String         | ISO 3166-1 alpha-3 three-letter code        |
| `cioc`            | String         | International Olympic Committee code        |
| `fifa`            | String         | FIFA code                                   |
| `independent`     | Boolean        | ISO 3166-1 sovereignty status               |
| `status`          | String         | ISO 3166-1 assignment status                |
| `unMember`        | Boolean        | UN member state                             |
| `currencies`      | List\<Object\> | Official currencies                         |
| `idd`             | Object         | International direct dialling info          |
| `callingCodes`    | List\<String\> | ★ Full international calling codes          |
| `capital`         | List\<String\> | Capital city names                          |
| `capitalInfo`     | Object         | Capital latitude/longitude                  |
| `altSpellings`    | List\<String\> | Alternate country name spellings            |
| `region`          | String         | UN geographic region                        |
| `subregion`       | String         | UN geographic subregion                     |
| `continents`      | List\<String\> | Continents the country lies on              |
| `languages`       | List\<Object\> | Official languages with ISO codes           |
| `translations`    | List\<Object\> | Country name in many languages              |
| `geolocation`     | Object         | ★ Latitude and longitude (named fields)     |
| `landlocked`      | Boolean        | Whether the country is landlocked           |
| `borders`         | List\<String\> | Bordering country cca3 codes                |
| `area`            | Double         | Land area in km²                            |
| `flag`            | Object         | SVG and PNG flag images, alt text, and emoji |
| `demonyms`        | List\<Object\> | Genderized demonyms by language             |
| `coatOfArms`      | Object         | SVG and PNG coat of arms URLs               |
| `population`      | Integer        | Estimated population                        |
| `maps`            | Object         | Google Maps and OpenStreetMap links         |
| `gini`            | List\<Object\> | Gini inequality index by year               |
| `car`             | Object         | Driving side and oval signs                 |
| `postalCode`      | Object         | Postal code format and regex                |
| `startOfWeek`     | String         | First day of the week                       |
| `timezones`       | List\<String\> | UTC timezone offsets                        |
| `regionalBlocs`   | List\<Object\> | ★ Regional/trade bloc memberships           |
| `religion`        | List\<Object\> | ★ Religious group breakdown                 |
| `ethnicity`       | List\<Object\> | ★ Ethnic group breakdown                    |
| `government`      | Object         | ★ Government type and current leaders       |
| `density`         | Double         | ★ Population density (people/km²)           |
| `gdp`             | Object         | ★ GDP total and per-capita (USD)            |
| `nationalHoliday` | String         | ★ National/independence day (date string)   |
| `anthem`          | String         | ★ Name of the national anthem               |
| `hdi`             | Double         | ★ Human Development Index score             |

★ = New in v4 (not present in v3.1)

---

## Detailed Field Reference

### Names & Codes

---

#### `name`

**Type:** Object
**Description:** The country's name in its common form, official form, and native languages.

```json
"name": {
  "common": "Aruba",
  "official": "Aruba",
  "nativeName": [
    { "lang": "nld", "official": "Aruba", "common": "Aruba" },
    { "lang": "pap", "official": "Aruba", "common": "Aruba" }
  ]
}
```

**Nested object — `name.nativeName[]`:**

| Sub-field  | Type   | Description                    |
| ---------- | ------ | ------------------------------ |
| `lang`     | String | ISO 639-2 language code        |
| `official` | String | Official name in that language |
| `common`   | String | Common name in that language   |

> **Note:** In v4 `nativeName` is a `List` of objects (keyed by `lang`), unlike v3.1 where it was a `Map<langCode, {official, common}>`.

---

#### `tld`

**Type:** List\<String\>
**Description:** Internet top-level domains assigned to the country.

```json
"tld": [".aw"]
```

---

#### `cca2`

**Type:** String
**Description:** ISO 3166-1 alpha-2 two-letter country code.

```json
"cca2": "AW"
```

---

#### `ccn3`

**Type:** String
**Description:** ISO 3166-1 numeric code (UN M49), zero-padded to three digits.

```json
"ccn3": "533"
```

---

#### `cca3`

**Type:** String
**Description:** ISO 3166-1 alpha-3 three-letter country code.

```json
"cca3": "ABW"
```

---

#### `cioc`

**Type:** String
**Description:** Code assigned by the International Olympic Committee. May be `null` for non-participating territories.

```json
"cioc": "ARU"
```

---

#### `fifa`

**Type:** String
**Description:** FIFA country code used in international football. May be `null`.

```json
"fifa": "ARU"
```

---

### Status & Membership

---

#### `independent`

**Type:** Boolean
**Description:** Whether the country is considered a sovereign state under ISO 3166-1. `false` for dependent territories.

```json
"independent": false
```

---

#### `status`

**Type:** String
**Description:** ISO 3166-1 assignment status. Common values: `"officially-assigned"`, `"user-assigned"`.

```json
"status": "officially-assigned"
```

---

#### `unMember`

**Type:** Boolean
**Description:** Whether the country is a full member of the United Nations.

```json
"unMember": false
```

---

### Geography

---

#### `region`

**Type:** String
**Description:** UN [demographic region](https://unstats.un.org/unsd/methodology/m49/). Examples: `"Africa"`, `"Americas"`, `"Asia"`, `"Europe"`, `"Oceania"`, `"Antarctic"`.

```json
"region": "Americas"
```

---

#### `subregion`

**Type:** String
**Description:** UN demographic subregion. Example: `"Caribbean"`, `"Northern Europe"`.

```json
"subregion": "Caribbean"
```

---

#### `continents`

**Type:** List\<String\>
**Description:** Continent(s) the country geographically belongs to. Some island nations span multiple.

```json
"continents": ["North America"]
```

---

#### `landlocked`

**Type:** Boolean
**Description:** Whether the country has no coastline (fully enclosed by other countries).

```json
"landlocked": false
```

---

#### `borders`

**Type:** List\<String\>
**Description:** List of bordering countries, identified by their `cca3` codes. Empty list for island nations.

```json
"borders": ["BEL", "DEU", "LUX"]
```

---

#### `area`

**Type:** Double
**Description:** Total land area in square kilometres.

```json
"area": 180.0
```

---

#### `geolocation` ★ New in v4

**Type:** Object
**Description:** Geographic centre of the country as named latitude and longitude values. Replaces the positional `latlng` array from previous versions.

```json
"geolocation": {
  "latitude": 12.5,
  "longitude": -69.96666666
}
```

**Nested fields:**

| Sub-field   | Type   | Description               |
| ----------- | ------ | ------------------------- |
| `latitude`  | Double | Decimal degrees latitude  |
| `longitude` | Double | Decimal degrees longitude |

---

### Capital

---

#### `capital`

**Type:** List\<String\>
**Description:** Name(s) of the capital city or cities. Some countries have multiple capitals.

```json
"capital": ["Oranjestad"]
```

---

#### `capitalInfo`

**Type:** Object
**Description:** Geographic coordinates of the capital city.

```json
"capitalInfo": {
  "latlng": [12.52, -70.03]
}
```

**Nested fields:**

| Sub-field | Type           | Description                          |
| --------- | -------------- | ------------------------------------ |
| `latlng`  | List\<Double\> | [latitude, longitude] of the capital |

---

### Languages & Translations

---

#### `languages`

**Type:** List\<Object\>
**Description:** Official languages of the country. In v4 this is a typed list with full ISO codes and native names, instead of a key-value map.

```json
"languages": [
  {
    "iso639_1": "nl",
    "iso639_2": "nld",
    "name": "Dutch",
    "nativeName": "Nederlands"
  },
  {
    "iso639_1": null,
    "iso639_2": "pap",
    "name": "Papiamento",
    "nativeName": null
  }
]
```

**Nested object fields:**

| Sub-field    | Type   | Description                                    |
| ------------ | ------ | ---------------------------------------------- |
| `iso639_1`   | String | ISO 639-1 two-letter code (may be `null`)      |
| `iso639_2`   | String | ISO 639-2 three-letter code                    |
| `name`       | String | English name of the language                   |
| `nativeName` | String | Language name in that language (may be `null`) |

---

#### `translations`

**Type:** List\<Object\>
**Description:** The country's name translated into many languages. Each entry contains the ISO 639-2 language code and both official and common forms.

```json
"translations": [
  { "lang": "deu", "official": "Aruba", "common": "Aruba" },
  { "lang": "fra", "official": "Aruba", "common": "Aruba" },
  { "lang": "jpn", "official": "アルバ", "common": "アルバ" }
]
```

**Nested object fields:**

| Sub-field  | Type   | Description                                |
| ---------- | ------ | ------------------------------------------ |
| `lang`     | String | ISO 639-2 language code of the translation |
| `official` | String | Official name in this language             |
| `common`   | String | Common name in this language               |

---

### Communications

---

#### `idd`

**Type:** Object
**Description:** International Direct Dialling information. Combine `root` + each `suffix` to form a full calling code (e.g. `+297`).

```json
"idd": {
  "root": "+2",
  "suffixes": ["97"]
}
```

**Nested fields:**

| Sub-field  | Type           | Description                    |
| ---------- | -------------- | ------------------------------ |
| `root`     | String         | Shared dialling prefix root    |
| `suffixes` | List\<String\> | Suffixes to append to the root |

---

#### `callingCodes` ★ New in v4

**Type:** List\<String\>
**Description:** Complete international calling codes (without `+`). Provided as a flat list for convenience, combining `idd.root` and `idd.suffixes`.

```json
"callingCodes": ["297"]
```

---

#### `timezones`

**Type:** List\<String\>
**Description:** UTC-based timezone offset(s) the country observes. Countries spanning multiple zones list all of them.

```json
"timezones": ["UTC-04:00"]
```

---

#### `tld`

_(see [Names & Codes](#names--codes))_

---

### Demographics

---

#### `population`

**Type:** Integer
**Description:** Estimated resident population of the country.

```json
"population": 106739
```

---

#### `density` ★ New in v4

**Type:** Double
**Description:** Population density expressed as people per square **kilometre**.

```json
"density": 560.4
```

---

#### `demonyms`

**Type:** List\<Object\>
**Description:** The name used for inhabitants of the country, with male and female forms, per language.

```json
"demonyms": [
  { "lang": "eng", "male": "Aruban", "female": "Aruban" },
  { "lang": "fra", "male": "Arubais", "female": "Arubaise" }
]
```

**Nested object fields:**

| Sub-field | Type   | Description             |
| --------- | ------ | ----------------------- |
| `lang`    | String | ISO 639-2 language code |
| `male`    | String | Male demonym form       |
| `female`  | String | Female demonym form     |

---

#### `religion` ★ New in v4

**Type:** List\<Object\>
**Description:** Breakdown of the population by religious group, including estimated counts and percentages.

```json
"religion": [
  { "name": "islam", "percentage": 99.9, "population": 49950000 },
  { "name": "other", "percentage": 0.1,  "population": 50000 }
]
```

**Nested object fields:**

| Sub-field    | Type   | Description                             |
| ------------ | ------ | --------------------------------------- |
| `name`       | String | Name of the religious group (lowercase) |
| `percentage` | Double | Share of the total population (%)       |
| `population` | Long   | Estimated number of adherents           |

---

#### `ethnicity` ★ New in v4

**Type:** List\<Object\>
**Description:** Breakdown of the population by ethnic group, with percentage shares.

```json
"ethnicity": [
  { "name": "dutch",     "percentage": 78.8 },
  { "name": "colombian", "percentage": 6.6  },
  { "name": "other",     "percentage": 5.1  }
]
```

**Nested object fields:**

| Sub-field    | Type   | Description                          |
| ------------ | ------ | ------------------------------------ |
| `name`       | String | Name of the ethnic group (lowercase) |
| `percentage` | Double | Share of the total population (%)    |

---

### Economy

---

#### `currencies`

**Type:** List\<Object\>
**Description:** Official currencies accepted in the country, each with ISO code, English name, and symbol.

> **Note:** In v4 this is a `List` of typed objects. In v3.1 it was a `Map<currencyCode, {name, symbol}>`.

```json
"currencies": [
  { "code": "AWG", "name": "Aruban florin", "symbol": "ƒ" }
]
```

**Nested object fields:**

| Sub-field | Type   | Description            |
| --------- | ------ | ---------------------- |
| `code`    | String | ISO 4217 currency code |
| `name`    | String | English currency name  |
| `symbol`  | String | Currency symbol        |

---

#### `gdp` ★ New in v4

**Type:** Object
**Description:** Gross Domestic Product figures in US dollars.

```json
"gdp": {
  "total": 3827000000,
  "perCapita": 35717
}
```

**Nested fields:**

| Sub-field   | Type | Description           |
| ----------- | ---- | --------------------- |
| `total`     | Long | Total GDP in USD      |
| `perCapita` | Long | GDP per capita in USD |

---

#### `gini`

**Type:** List\<Object\>
**Description:** World Bank [Gini](https://data.worldbank.org/indicator/SI.POV.GINI) inequality index measurements. Each entry records the year of measurement and the index value (0–100, higher = more unequal). May be an empty list when no data is available.

```json
"gini": [
  { "year": "2018", "value": 51.3 }
]
```

**Nested object fields:**

| Sub-field | Type   | Description                    |
| --------- | ------ | ------------------------------ |
| `year`    | String | Year the measurement was taken |
| `value`   | Double | Gini coefficient (0–100)       |

---

#### `hdi` ★ New in v4

**Type:** Double
**Description:** Human Development Index score (0.0–1.0). A composite measure of life expectancy, education, and income. `0.0` indicates no data available.

```json
"hdi": 0.496
```

---

### Government

---

#### `government` ★ New in v4

**Type:** Object
**Description:** The form of government and a list of current heads of state or government.

```json
"government": {
  "type": "Devolution",
  "leaders": [
    {
      "title": "Monarchy of the Netherlands",
      "name": "Willem-Alexander of the Netherlands"
    },
    {
      "title": "Governor of Aruba",
      "name": "Alfonso Boekhoudt"
    }
  ]
}
```

**Nested fields:**

| Sub-field | Type           | Description                                              |
| --------- | -------------- | -------------------------------------------------------- |
| `type`    | String         | Government system type (e.g. `"Republic"`, `"Monarchy"`) |
| `leaders` | List\<Object\> | Current leaders (see below)                              |

**`government.leaders[]` fields:**

| Sub-field | Type   | Description                            |
| --------- | ------ | -------------------------------------- |
| `title`   | String | Official title of the position         |
| `name`    | String | Full name of the current office holder |

---

### Visual

---

#### `flag`

**Type:** Object
**Description:** National flag images and emoji. SVG and PNG renderings are sourced from
[Flagpedia](https://flagpedia.net/). Includes an accessible `alt` text description and
the Unicode flag `emoji`.

```json
"flag": {
  "svg": "https://flagcdn.com/aw.svg",
  "png": "https://flagcdn.com/w320/aw.png",
  "alt": "The flag of Aruba is blue, with two narrow, horizontal yellow stripes across the lower portion and a red four-pointed star outlined in white in the canton.",
  "emoji": "🇦🇼"
}
```

**Nested fields:**

| Sub-field | Type   | Description                             |
| --------- | ------ | --------------------------------------- |
| `svg`     | String | URL to the SVG flag image               |
| `png`     | String | URL to the PNG flag image (320px wide)  |
| `alt`     | String | Accessible text description of the flag |
| `emoji`   | String | Unicode flag emoji                      |

---

#### `coatOfArms`

**Type:** Object
**Description:** URLs to SVG and PNG images of the national coat of arms, sourced from [MainFacts.com](https://mainfacts.com/coat-of-arms-countries-world). `svg` and `png` may be empty strings for territories without a coat of arms.

```json
"coatOfArms": {
  "svg": "https://mainfacts.com/media/images/coats_of_arms/aw.svg",
  "png": "https://mainfacts.com/media/images/coats_of_arms/aw.png"
}
```

**Nested fields:**

| Sub-field | Type   | Description                       |
| --------- | ------ | --------------------------------- |
| `svg`     | String | URL to the SVG coat of arms image |
| `png`     | String | URL to the PNG coat of arms image |

---

### Cartography

---

#### `maps`

**Type:** Object (Map\<String, String\>)
**Description:** Links to the country on popular mapping platforms.

```json
"maps": {
  "googleMaps": "https://goo.gl/maps/8hopbQqifHAgyZyg8",
  "openStreetMaps": "https://www.openstreetmap.org/relation/1231749"
}
```

**Keys:**

| Key              | Description                |
| ---------------- | -------------------------- |
| `googleMaps`     | Shortened Google Maps URL  |
| `openStreetMaps` | OpenStreetMap relation URL |

---

#### `car`

**Type:** Object
**Description:** Information about road vehicle conventions.

```json
"car": {
  "signs": ["AW"],
  "side": "right"
}
```

**Nested fields:**

| Sub-field | Type           | Description                                |
| --------- | -------------- | ------------------------------------------ |
| `signs`   | List\<String\> | Oval distinguishing signs used on vehicles |
| `side`    | String         | Driving side: `"left"` or `"right"`        |

---

#### `postalCode`

**Type:** Object (Map\<String, String\>)
**Description:** The postal code system format and validation regex. Both values may be `null` for countries without a postal code system.

```json
"postalCode": {
  "format": "#### @@",
  "regex": "^(\\d{4}\\s[a-zA-Z]{2})$"
}
```

**Keys:**

| Key      | Type   | Description                              |
| -------- | ------ | ---------------------------------------- |
| `format` | String | Human-readable format pattern (nullable) |
| `regex`  | String | Validation regular expression (nullable) |

---

#### `startOfWeek`

**Type:** String
**Description:** The conventional first day of the working week. Values: `"monday"`, `"sunday"`, `"saturday"`.

```json
"startOfWeek": "monday"
```

---

#### `altSpellings`

**Type:** List\<String\>
**Description:** Alternate spellings and short-form references for the country name (includes country codes, short names, and abbreviations).

```json
"altSpellings": ["AW"]
```

---

### International Organizations

---

#### `regionalBlocs` ★ New in v4

**Type:** List\<Object\>
**Description:** Regional or trade bloc memberships of the country. May be an empty list for non-member countries.

```json
"regionalBlocs": [
  {
    "acronym": "SAARC",
    "name": "South Asian Association for Regional Cooperation",
    "otherNames": []
  }
]
```

**Nested object fields:**

| Sub-field    | Type           | Description                                      |
| ------------ | -------------- | ------------------------------------------------ |
| `acronym`    | String         | Short acronym for the bloc (e.g. `"EU"`, `"AU"`) |
| `name`       | String         | Full name of the bloc                            |
| `otherNames` | List\<String\> | Alternative or historical names of the bloc      |

---

### Cultural

---

#### `anthem` ★ New in v4

**Type:** String
**Description:** The English (or transliterated) name of the national anthem.

```json
"anthem": "Aruba Dushi Tera"
```

---

#### `nationalHoliday` ★ New in v4

**Type:** String
**Description:** The national or independence day as a date string. Format varies by country; commonly `YYYY-MM-DD` but may include descriptive strings.

```json
"nationalHoliday": "1976-03-18"
```

---

## New in v4

The following fields are **not present in v3.1** and were introduced in v4:

| Field             | Description                                                   |
| ----------------- | ------------------------------------------------------------- |
| `callingCodes`    | Complete calling codes as a flat string list                  |
| `geolocation`     | Named `latitude`/`longitude` object (replaces `latlng` array) |
| `regionalBlocs`   | Regional/trade bloc memberships                               |
| `religion`        | Religious group breakdown with population and percentage      |
| `ethnicity`       | Ethnic group breakdown with percentage                        |
| `government`      | Government type and current leaders                           |
| `density`         | Population density (people/km²)                               |
| `gdp`             | GDP total and per-capita in USD                               |
| `hdi`             | Human Development Index score                                 |
| `nationalHoliday` | National/independence day date                                |
| `anthem`          | Name of the national anthem                                   |

### Shape changes from v3.1

| Field             | v3.1 shape                          | v4 shape                                       |
| ----------------- | ----------------------------------- | ---------------------------------------------- |
| `name.nativeName` | `Map<langCode, {official, common}>` | `List<{lang, official, common}>`               |
| `languages`       | `Map<iso639_2, languageName>`       | `List<{iso639_1, iso639_2, name, nativeName}>` |
| `currencies`      | `Map<currencyCode, {name, symbol}>` | `List<{code, name, symbol}>`                   |
| `translations`    | `Map<langCode, {official, common}>` | `List<{lang, official, common}>`               |
| `demonyms`        | `Map<lang, {m, f}>`                 | `List<{lang, male, female}>`                   |
| `gini`            | `Map<year, value>`                  | `List<{year, value}>`                          |
| `latlng`          | `[Double, Double]` array            | Removed — use `geolocation`                    |
