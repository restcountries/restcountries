# About this Project
This project is inspired on restcountries.eu by Fayder Florez. As it hasn't had any activity in at least 14 months, I decided to take action :)

## Important Information About Version 2
The structure has been reverted to its original form from the [Original Project] to maintain compatibility.

# REST Countries
You can access API through https://restcountries.com/v3/all

# TODO:
Please reffer to the [issue website](https://gitlab.com/amatos/rest-countries/-/issues)

# Contributing
Any help is welcome! Just edit the file relevant file and create a new Merge Request or you can also 
[donate](https://www.paypal.me/amatosg/15).

# Donations
Donation will help me paying the server's bills and any upgrade the server might need due to usage so if 
you feel like helping me, you're welcome to [donate](https://www.paypal.me/amatosg/15) or you can also 
[buy me a coffee](https://www.buymeacoffee.com/amatos). 


# Changelog
### V3
- Added population
### V3.1
- Added population
- Added named object for `flags`

# API Endpoints

Currently there are 3 versions:
- Version 2 is the original version from restcountries.eu by Fayder Florez
- Version 3 is the implementation from [this project](https://github.com/mledoze/countries)
- Version 3.1 adds named values to the `flags` object like this:

```json
"flags": {
  "svg": "https://restcountries.com/data/per.svg",
  "png": "https://restcountries.com/data/png/per.png"
}
```

Below are described the REST endpoints available that you can use to search for countries

## All

### V2
``` html
https://restcountries.com/v2/all
```

### V3
``` html
https://restcountries.com/v3/all
```


## Name

### V2
Search by country name. It can be the native name or partial name

``` javascript
https://restcountries.com/v2/name/{name}
```

``` html
https://restcountries.com/v2/name/eesti
```

``` html
https://restcountries.com/v2/name/united
```

### V3
Search by country name. It can be the common or official value
``` html
https://restcountries.com/v3/name/{name}
```

``` html
https://restcountries.com/v3/name/eesti
```

``` html
https://restcountries.com/v3/name/deutschland
```

## Full Name
### V2
Search by country's full name

``` html
https://restcountries.com/v2/name/{name}?fullText=true
```

``` html
https://restcountries.com/v2/name/aruba?fullText=true
```

### V3
Search by country's full name. It can be the common or official value
``` html
https://restcountries.com/v3/name/{name}?fullText=true
```

``` html
https://restcountries.com/v3/name/aruba?fullText=true
```
## Code
### V2
Search by ISO 3166-1 2-letter or 3-letter country code

``` html
https://restcountries.com/v2/alpha/{code}
```

``` html
https://restcountries.com/v2/alpha/co
```

``` html
https://restcountries.com/v2/alpha/col
```
### V3
Search by cca2, ccn3, cca3 or cioc country code (yes, any!)

``` html
https://restcountries.com/v3/alpha/{code}
```

``` html
https://restcountries.com/v3/alpha/co
```

``` html
https://restcountries.com/v3/alpha/col
```

``` html
https://restcountries.com/v3/alpha/170
```
## List of codes
### V2
Search by list of ISO 3166-1 2-letter or 3-letter country codes

``` html
https://restcountries.com/v2/alpha?codes={code},{code},{code}
```

``` html
https://restcountries.com/v2/alpha?codes=col,no,ee,pe
```
### V3
Search by cca2, ccn3, cca3 or cioc country code (yes, any!)
``` html
https://restcountries.com/v3/alpha?codes={code},{code},{code}
```

``` html
https://restcountries.com/v3/alpha?codes=170,no,est,pe
```
## Currency
### V2
Search by ISO 4217 currency code

``` html
https://restcountries.com/v2/currency/{currency}
```
``` html
https://restcountries.com/v2/currency/cop
```
### V3
Search by currency code or name
``` html
https://restcountries.com/v3/currency/{currency}
```
``` html
https://restcountries.com/v3/currency/cop
```

### Demonym
### V3
Now you can search by how a citizen is called.
``` html
https://restcountries.com/v3/demonym/{demonym}
```
``` html
https://restcountries.com/v3/demonym/peruvian
```

## Language
### V2
Search by ISO 639-1 language code

``` javascript
https://restcountries.com/v2/lang/{et}
```
``` html
https://restcountries.com/v2/lang/es
```

### V3
Search by language code or name
``` html
https://restcountries.com/v3/lang/{currency}
```
``` html
https://restcountries.com/v3/lang/cop
```
``` html
https://restcountries.com/v3/lang/spanish
```

## Capital city

_This is the same in both versions_

Search by capital city

``` javascript
https://restcountries.com/v2/capital/{capital}
```
``` html
https://restcountries.com/v2/capital/tallinn
```

``` javascript
https://restcountries.com/v3/capital/{capital}
```
``` html
https://restcountries.com/v3/capital/tallinn
```

## Calling code
### V2
Search by calling code

``` html
https://restcountries.com/v2/callingcode/{callingcode}
```
``` html
https://restcountries.com/v2/callingcode/372
```
### V3
In version 3, calling codes are in the _idd_ object. There is no implementation 
to search by calling codes in V3.

## Region
### V2
In version 2 regions are _continent_ and subregions are _region_
Search by continent: Africa, Americas, Asia, Europe, Oceania

``` html
https://restcountries.com/v2/continent/{continent}
```
``` html
https://restcountries.com/v2/continent/europe
```
### V3
In version 3, continents are _Regions_ and regions are _Subregions_

``` html
https://restcountries.com/v2/region/{region}
```
``` html
https://restcountries.com/v2/region/europe
```
## Subregions
###V3
You can search by subregions
``` html
https://restcountries.com/v2/subregion/{subregion}
```
``` html
https://restcountries.com/v2/subregion/Northern Europe
```

## Regional Bloc (*Version 2 only*)



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

## Translation
You can search by any translation name
``` html
https://restcountries.com/v3/translation/{translation}
```
``` html
https://restcountries.com/v3/translation/germany
```
``` html
https://restcountries.com/v3/translation/alemania
```
``` html
https://restcountries.com/v3/translation/Saksamaa
```

## Response Example

``` html
https://restcountries.com/v2/alpha/col
```

``` json
[[{
	"name": "Colombia",
	"topLevelDomain": [".co"],
	"alpha2Code": "CO",
	"alpha3Code": "COL",
	"callingCodes": ["57"],
	"capital": "Bogotá",
	"altSpellings": ["CO", "Republic of Colombia", "República de Colombia"],
	"region": "Americas",
	"subregion": "South America",
	"population": 48759958,
	"latlng": [4.0, -72.0],
	"demonym": "Colombian",
	"area": 1141748.0,
	"gini": 55.9,
	"timezones": ["UTC-05:00"],
	"borders": ["BRA", "ECU", "PAN", "PER", "VEN"],
	"nativeName": "Colombia",
	"numericCode": "170",
	"currencies": [{
		"code": "COP",
		"name": "Colombian peso",
		"symbol": "$"
	}],
	"languages": [{
		"iso639_1": "es",
		"iso639_2": "spa",
		"name": "Spanish",
		"nativeName": "Español"
	}],
	"translations": {
		"de": "Kolumbien",
		"es": "Colombia",
		"fr": "Colombie",
		"ja": "コロンビア",
		"it": "Colombia",
		"br": "Colômbia",
		"pt": "Colômbia"
	},
	"flag": "https://restcountries.com/data/col.svg",
	"regionalBlocs": [{
		"acronym": "PA",
		"name": "Pacific Alliance",
		"otherAcronyms": [],
		"otherNames": ["Alianza del Pacífico"]
	}, {
		"acronym": "USAN",
		"name": "Union of South American Nations",
		"otherAcronyms": ["UNASUR", "UNASUL", "UZAN"],
		"otherNames": ["Unión de Naciones Suramericanas", "União de Nações Sul-Americanas", "Unie van Zuid-Amerikaanse Naties", "South American Union"]
	}]
}]
```

## Filter Response

You can filter the output of your request to include only the specified fields.

``` javascript
https://restcountries.com/v2/{service}?fields={field},{field},{field}
```
``` html
https://restcountries.com/v2/all?fields=name,capital,currencies
```
## Using this Project

- [Nations24](https://nations24.com)

## Similar projects
* [REST Countries] (original project)
* [Countries of the world]
* [REST Countries Node.js]
* [REST Countries Ruby]
* [REST Countries Go]
* [REST Countries Python]
* [world-currencies]

[world-currencies]: https://github.com/wiredmax/world-currencies
[REST Countries Node.js]: https://github.com/aredo/restcountries
[REST Countries Ruby]: https://github.com/davidesantangelo/restcountry
[REST Countries Go]: https://github.com/alediaferia/gocountries
[REST Countries Python]: https://github.com/SteinRobert/python-restcountries
[Countries of the world]: http://countries.petethompson.net
[REST Countries]: https://github.com/apilayer/restcountries
[Original Project]: https://github.com/apilayer/restcountries/
