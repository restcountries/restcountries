REST Countries 🇵🇪
=======

Get information about countries via a RESTful API

*Current version: 1*

Donate!
---------------
If you want to donate to **this** project to help me pay the server bill, you are welcome to donate 
[$5], [$10], [$15] o [more]. I would very much appreciate the help 😃

The original restcountries project was acquired by apilayer, one of the leading providers of 
API microservices. As the original project has shown very little activity, I created this project 
in order to provide a more updated version and with some fixes requested in the original project.

Users
---------------

This project is used by 
- [Nations24](https://nations24.com)

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

API Endpoints
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

``` javascript
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

``` javascript
https://restcountries.com/v2/name/{name}?fullText=true
```

``` html
https://restcountries.com/v2/name/aruba?fullText=true
```

Code
---------------

Search by ISO 3166-1 2-letter or 3-letter country code

``` javascript
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

``` javascript
https://restcountries.com/v2/alpha?codes={code},{code},{code}
```

``` html
https://restcountries.com/v2/alpha?codes=col,pe,at
```

Currency
---------------

Search by ISO 4217 currency code

``` javascript
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

``` javascript
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

``` javascript
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