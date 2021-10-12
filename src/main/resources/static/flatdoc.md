REST Countries 🇵🇪
=======

Get information about countries via a RESTful API

*Current version: 3.1*

New in Version 3
-
Version 3 and 3.1 uses [this] project to get the country's structure and adds a couple of new features:

- Search by translations
- Search by language's name (not just language code)
- Search by currency's name (not just currency code)
- Turning back from V2 to V3: continent to region and region to subregion
- Population
- Fifa code
- Added country's driving side
- Added country Distinguishing (oval) sign

In addition to those features, I added the flags (svg and png) to each country. 

V3 vs V3.1
-
The only difference between v3 and v3.1 is

V3:

```json
"flags": [
  "https://restcountries.com/data/per.svg",
  "https://restcountries.com/data/png/per.png"
]
``` 
V3.1:

```json
"flags": {
  "svg": "https://restcountries.com/data/per.svg",
  "png": "https://restcountries.com/data/png/per.png"
}
```

Important Information About Version 2
--
The structure has been reverted to its original form from the [Original Project] to maintain compatibility.

Donate!
---------------
We're getting about 1.6 millions hits each day and that means also bandwidth (25 GB per day!) so
costs have obviously increased. **Please**, consider making a [donation] to help me pay the server's
bills, you're welcome to [donate] or you can also
[buy me a coffee](https://www.buymeacoffee.com/amatos).

Users
---------------

This project is used by

- [Famosos](https://famosos.com)
- [Cultural Care](https://www.culturalcare.world/)
- [Covidata](https://worldcovidata.com/)
- [Asendia](https://tracking.asendia.com)
- [Picker](https://mwb.pickerexpress.com/#/login)

Original RESTCountries project has over 1200 users, including:

- [TTÜ]
- [Spotify International Pricing Index]
- [Gorillaz]
- [Wanderlust]
- [Xero]
- [FxPro]
- [SKROSS]
- [onefinestay]
- [Much Better Adventures]

API Endpoints v3
=======

This version takes countries from [this] project, but it adds the flags. Although the requests 
have not changed much, the response has as the country structure is different. Please refer to the
example response body.

All
---------------
``` html
https://restcountries.com/v3.1/all
```

Name
---------------

Search by country name. It can be the native name or partial name

``` html
https://restcountries.com/v3.1/name/{name}
```

``` html
https://restcountries.com/v3.1/name/peru
```

``` html
https://restcountries.com/v3.1/name/united
```

Full Name
---------------

Search by country full name

``` html
https://restcountries.com/v3.1/name/{name}?fullText=true
```

``` html
https://restcountries.com/v3.1/name/aruba?fullText=true
```

Code
---------------

Search by cca2, ccn3, cca3 or cioc country code (yes, any!)

**UPDATE**: this will now return an array.

``` html
https://restcountries.com/v3.1/alpha/{code}
```

``` html
https://restcountries.com/v3.1/alpha/pe
```

``` html
https://restcountries.com/v3.1/alpha/per
```

List of codes
---------------

Search by list of cca2, ccn3, cca3 or cioc country codes (yes, any!). The original project used *;* as
separator. In out case, the *comma* is used to separate values.

``` html
https://restcountries.com/v3.1/alpha?codes={code},{code},{code}
```

``` html
https://restcountries.com/v3.1/alpha?codes=col,pe,at
```

Currency
---------------

Search by currency name (_new!_) or code

``` html
https://restcountries.com/v3.1/currency/{currency}
```
``` html
https://restcountries.com/v3.1/currency/pen
```
``` html
https://restcountries.com/v3.1/currency/dollar
```

Language
---------------

Search by language name (_new!_) or iso639_2 code

``` html
https://restcountries.com/v3.1/lang/{lang}
```
``` html
https://restcountries.com/v3.1/lang/spa
```
``` html
https://restcountries.com/v3.1/lang/german
```

Translations (*V3 only*)
-
Now you can search by name in any available translation
``` html
https://restcountries.com/v3.1/translation/Peruánská
```

Capital city
---------------

Search by capital city.

``` html
https://restcountries.com/v3.1/capital/{capital}
```
``` html
https://restcountries.com/v3.1/capital/lima
```

Region
---------------

Search by Region: Africa, Americas, Asia, Europe, Oceania. The search can be using the full region's name or just part of it

``` html
https://restcountries.com/v3.1/region/{region}
```
``` html
https://restcountries.com/v3.1/region/europe
```
``` html
https://restcountries.com/v3.1/region/ame
```

Subregion
---------------

Search by Subregion: South America, Southern Europe, Central America, Eastern Asia, etc. The search can be using the full subregion's name or just part of it

``` html
https://restcountries.com/v3.1/subregion/{region}
```
``` html
https://restcountries.com/v3.1/subregion/europe
```
``` html
https://restcountries.com/v3.1/subregion/south
```

Demonym
-
Now you can search by how a citizen is called.

``` html
https://restcountries.com/v3.1/demonym/{demonym}
```
``` html
https://restcountries.com/v3.1/demonym/peruvian
```

Response Example
-
``` html
https://restcountries.com/v3.1/name/japan
```
``` html
[
  {
    "name": {
      "common": "Japan",
      "official": "Japan",
      "nativeName": {
        "jpn": {
          "official": "日本",
          "common": "日本"
        }
      }
    },
    "tld": [
      ".jp",
      ".みんな"
    ],
    "cca2": "JP",
    "ccn3": "392",
    "cca3": "JPN",
    "cioc": "JPN",
    "independent": true,
    "status": "officially-assigned",
    "unMember": true,
    "currencies": {
      "JPY": {
        "name": "Japanese yen",
        "symbol": "¥"
      }
    },
    "idd": {
      "root": "+8",
      "suffixes": [
        "1"
      ]
    },
    "capital": [
      "Tokyo"
    ],
    "altSpellings": [
      "JP",
      "Nippon",
      "Nihon"
    ],
    "region": "Asia",
    "subregion": "Eastern Asia",
    "languages": {
      "jpn": "Japanese"
    },
    "translations": {
      "ces": {
        "official": "Japonsko",
        "common": "Japonsko"
      },
      "deu": {
        "official": "Japan",
        "common": "Japan"
      },
      "est": {
        "official": "Jaapan",
        "common": "Jaapan"
      },
      "fin": {
        "official": "Japani",
        "common": "Japani"
      },
      "fra": {
        "official": "Japon",
        "common": "Japon"
      },
      "hrv": {
        "official": "Japan",
        "common": "Japan"
      },
      "hun": {
        "official": "Japán",
        "common": "Japán"
      },
      "ita": {
        "official": "Giappone",
        "common": "Giappone"
      },
      "jpn": {
        "official": "日本",
        "common": "日本"
      },
      "kor": {
        "official": "일본국",
        "common": "일본"
      },
      "nld": {
        "official": "Japan",
        "common": "Japan"
      },
      "per": {
        "official": "ژاپن",
        "common": "ژاپن"
      },
      "pol": {
        "official": "Japonia",
        "common": "Japonia"
      },
      "por": {
        "official": "Japão",
        "common": "Japão"
      },
      "rus": {
        "official": "Япония",
        "common": "Япония"
      },
      "slk": {
        "official": "Japonsko",
        "common": "Japonsko"
      },
      "spa": {
        "official": "Japón",
        "common": "Japón"
      },
      "swe": {
        "official": "Japan",
        "common": "Japan"
      },
      "urd": {
        "official": "جاپان",
        "common": "جاپان"
      },
      "zho": {
        "official": "日本国",
        "common": "日本"
      }
    },
    "latlng": [
      36.0,
      138.0
    ],
    "landlocked": false,
    "area": 377930.0,
    "flag": "🇯🇵",
    "flags": [
      "svg": "https://restcountries.com/data/jpn.svg",
      "png": "https://restcountries.com/data/png/jpn.png"
    ],
    "demonyms": {
      "eng": {
        "f": "Japanese",
        "m": "Japanese"
      },
      "fra": {
        "f": "Japonaise",
        "m": "Japonais"
      }
    }
  }
]
```

---------------------

API Endpoints v2
=======

Below are described the REST endpoints available that you can use to search for countries

All
---------------

``` html
https://restcountries.com/v2/all
```

Name
---------------

Search by country name. It can be the native name or partial name

``` html
https://restcountries.com/v2/name/{name}
```

``` html
https://restcountries.com/v2/name/peru
```

``` html
https://restcountries.com/v2/name/united
```

Full Name
---------------

Search by country full name

``` html
https://restcountries.com/v2/name/{name}?fullText=true
```

``` html
https://restcountries.com/v2/name/aruba?fullText=true
```

Code
---------------

Search by ISO 3166-1 2-letter or 3-letter country code

``` html
https://restcountries.com/v2/alpha/{code}
```

``` html
https://restcountries.com/v2/alpha/pe
```

``` html
https://restcountries.com/v2/alpha/per
```

List of codes
---------------

Search by list of ISO 3166-1 2-letter or 3-letter country codes. The original project used *;* as 
separator. In out case, the *comma* is used to separate values.

``` html
https://restcountries.com/v2/alpha?codes={code},{code},{code}
```

``` html
https://restcountries.com/v2/alpha?codes=col,pe,at
```

Currency
---------------

Search by ISO 4217 currency code

``` html
https://restcountries.com/v2/currency/{currency}
```
``` html
https://restcountries.com/v2/currency/pen
```

Language
---------------

Search by ISO 639-1 language code.

``` javascript
https://restcountries.com/v2/lang/{lang}
```
``` html
https://restcountries.com/v2/lang/es
```

Capital city
---------------

Search by capital city

``` html
https://restcountries.com/v2/capital/{capital}
```
``` html
https://restcountries.com/v2/capital/lima
```

Calling code
---------------

Search by calling code

``` javascript
https://restcountries.com/v2/callingcode/{callingcode}
```
``` html
https://restcountries.com/v2/callingcode/51
```

Continent
---------------

Search by continent: Africa, Americas, Asia, Europe, Oceania

``` javascript
https://restcountries.com/v2/continent/{region}
```
``` html
https://restcountries.com/v2/continent/europe
```

Regional Bloc
---------------

Search by regional bloc:

- EU (European Union)
- EFTA (European Free Trade Association)
- CARICOM (Caribbean Community)
- PA (Pacific Alliance)
- AU (African Union)
- USAN (Union of South American Nations)
- EEU (Eurasian Economic Union)
- AL (Arab League)
- ASEAN (Association of Southeast Asian Nations)
- CAIS (Central American Integration System)
- CEFTA (Central European Free Trade Agreement)
- NAFTA (North American Free Trade Agreement)
- SAARC (South Asian Association for Regional Cooperation)

``` html
https://restcountries.com/v2/regionalbloc/{regionalbloc}
```
``` html
https://restcountries.com/v2/regionalbloc/eu
```

Response Example
---------------

``` html
https://restcountries.com/v2/alpha/col
```

``` json
{
  "name": "Colombia",
  "topLevelDomain": [
    ".co"
  ],
  "alpha2Code": "CO",
  "alpha3Code": "COL",
  "callingCodes": [
    "57"
  ],
  "capital": "Bogotá",
  "altSpellings": [
    "CO",
    "Republic of Colombia",
    "República de Colombia"
  ],
  "region": "South America",
  "continent": "Americas",
  "population": 48759958,
  "latlng": [
    4.0,
    -72.0
  ],
  "demonym": "Colombian",
  "area": 1141748.0,
  "gini": 55.9,
  "timezones": [
    "UTC-05:00"
  ],
  "borders": [
    "BRA",
    "ECU",
    "PAN",
    "PER",
    "VEN"
  ],
  "nativeName": "Colombia",
  "numericCode": "170",
  "currencies": [
    {
      "code": "COP",
      "name": "Colombian peso",
      "symbol": "$"
    }
  ],
  "languages": [
    {
      "iso639_1": "es",
      "iso639_2": "spa",
      "name": "Spanish",
      "nativeName": "Español"
    }
  ],
  "translations": {
    "br": "Colômbia",
    "pt": "Colômbia",
    "nl": "Colombia",
    "hr": "Kolumbija",
    "fa": "کلمبیا",
    "de": "Kolumbien",
    "es": "Colombia",
    "fr": "Colombie",
    "ja": "コロンビア",
    "it": "Colombia",
    "hu": "Kolumbia"
  },
  "flags": [
    "https://restcountries.com/data/col.svg",
    "https://restcountries.com/data/png/col.png"
  ],
  "regionalBlocs": [
    {
      "acronym": "PA",
      "name": "Pacific Alliance",
      "otherNames": [
        "Alianza del Pacífico"
      ]
    },
    {
      "acronym": "USAN",
      "name": "Union of South American Nations",
      "otherAcronyms": [
        "UNASUR",
        "UNASUL",
        "UZAN"
      ],
      "otherNames": [
        "Unión de Naciones Suramericanas",
        "União de Nações Sul-Americanas",
        "Unie van Zuid-Amerikaanse Naties",
        "South American Union"
      ]
    }
  ],
  "cioc": "COL",
  "independent": true
}
```

Filter Response
=======

You can filter the output of your request to include only the specified fields.

``` javascript
https://restcountries.com/v2/{service}?fields={field},{field},{field}
```
``` html
https://restcountries.com/v2/all?fields=name,capital,currencies
```

Sources
=======
* [@mledoze]
* [List of countries]
* [Languages]
* [Currencies]
* [Area]

Similar projects
=======
* [Original Project]
* [Countries of the world]
* [REST Countries Node.js]
* [REST Countries Ruby]
* [REST Countries Go]
* [REST Countries Python]
* [world-currencies]

License
=======
[Mozilla Public License] MPL 2.0

[$5]:https://www.paypal.com/paypalme/amatosg/5
[$10]:https://www.paypal.com/paypalme/amatosg/10
[$15]:https://www.paypal.com/paypalme/amatosg/15
[more]:https://www.paypal.com/paypalme/amatosg/
[Original Project]: https://github.com/apilayer/restcountries/
[@mledoze]: https://github.com/mledoze/countries
[List of countries]: https://en.wikipedia.org/wiki/ISO_3166-1#Current_codes
[Languages]: https://en.wikipedia.org/wiki/List_of_ISO_639-1_codes
[Currencies]: https://en.wikipedia.org/wiki/List_of_circulating_currencies
[Area]: https://en.wikipedia.org/wiki/List_of_countries_and_dependencies_by_area
[Population]: https://en.wikipedia.org/wiki/List_of_countries_by_population
[Gini coefficient]: http://en.wikipedia.org/wiki/List_of_countries_by_income_equality
[Mozilla Public License]: https://www.mozilla.org/en-US/MPL/2.0/
[world-currencies]: https://github.com/wiredmax/world-currencies
[REST Countries Node.js]: https://github.com/aredo/restcountries
[REST Countries Ruby]: https://github.com/davidesantangelo/restcountry
[REST Countries Go]: https://github.com/alediaferia/gocountries
[REST Countries Python]: https://github.com/SteinRobert/python-restcountries
[Countries of the world]: http://countries.petethompson.net
[TTÜ]: https://www.ttu.ee/studying/tut_admission/programmes-in-tut/ask-us/
[Spotify International Pricing Index]: http://mts.io/2014/05/07/spotify-pricing-index/
[Gorillaz]: http://www.gorillaz.com/
[Wanderlust]: https://wanderlust.com/
[Xero]: https://www.xero.com/
[FxPro]: http://www.fxpro.com/
[onefinestay]: https://www.onefinestay.com/
[Much Better Adventures]: https://www.muchbetteradventures.com
[SKROSS]: http://www.skross.com/en
[this]: https://github.com/mledoze/countries
[donation]: https://www.paypal.me/amatosg/15
[donate]: https://www.paypal.me/amatosg/15