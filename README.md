# About this Project
This project is inspired on restcountries.eu by Fayder Florez. Although the original project has now moved to 
a subscription base API, this project is still Open Source and Free to use.

## Important Information About Version 2
The structure has been reverted to its original form from the [Original Project] to maintain compatibility.

# REST Countries
You can access API through https://restcountries.com/v3.1/all


# Contributing
Any help is welcome! Just edit the file relevant file and create a new Merge Request or you can also 
[donate].

# Donations
We're getting about 1.6 millions hits **each day** and that means also bandwidth (24 GB **per day!**) so
costs have obviously increased. **Please**, consider making a [donation] to help me pay the server's 
bills, you're welcome to [donate] or you can also 
[buy me a coffee](https://www.buymeacoffee.com/amatos). 

# Fields
You can check the [FIELDS.md](FIELDS.md) file to get a description for each field (thanks to @ePascalC!).

# Changelog
### General
- Netherlands' population fixed
- Added `fifa` codes
- Added country's driving side
- Added country Distinguishing (oval) sign
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
## Using this Project

- [Famosos](https://famosos.com)
- [Cultural Care](https://www.culturalcare.world/)
- [Covidata](https://worldcovidata.com/)
- [Asendia](https://tracking.asendia.com)
- [Picker](https://mwb.pickerexpress.com/#/login)

#Endpoints
Below are described the REST endpoints available that you can use to search for countries

## All

### V2
``` html
https://restcountries.com/v2/all
```

### V3.1
``` html
https://restcountries.com/v3.1/all
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

### V3.1
Search by country name. It can be the common or official value
``` html
https://restcountries.com/v3.1/name/{name}
```

``` html
https://restcountries.com/v3.1/name/eesti
```

``` html
https://restcountries.com/v3.1/name/deutschland
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

### V3.1
Search by country's full name. It can be the common or official value
``` html
https://restcountries.com/v3.1/name/{name}?fullText=true
```

``` html
https://restcountries.com/v3.1/name/aruba?fullText=true
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
### V3.1
Search by cca2, ccn3, cca3 or cioc country code (yes, any!)

``` html
https://restcountries.com/v3.1/alpha/{code}
```

``` html
https://restcountries.com/v3.1/alpha/co
```

``` html
https://restcountries.com/v3.1/alpha/col
```

``` html
https://restcountries.com/v3.1/alpha/170
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
### V3.1
Search by cca2, ccn3, cca3 or cioc country code (yes, any!)
``` html
https://restcountries.com/v3.1/alpha?codes={code},{code},{code}
```

``` html
https://restcountries.com/v3.1/alpha?codes=170,no,est,pe
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
### V3.1
Search by currency code or name
``` html
https://restcountries.com/v3.1/currency/{currency}
```
``` html
https://restcountries.com/v3.1/currency/cop
```

### Demonym
### V3.1
Now you can search by how a citizen is called.
``` html
https://restcountries.com/v3.1/demonym/{demonym}
```
``` html
https://restcountries.com/v3.1/demonym/peruvian
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

### V3.1
Search by language code or name
``` html
https://restcountries.com/v3.1/lang/{currency}
```
``` html
https://restcountries.com/v3.1/lang/cop
```
``` html
https://restcountries.com/v3.1/lang/spanish
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
https://restcountries.com/v3.1/capital/{capital}
```
``` html
https://restcountries.com/v3.1/capital/tallinn
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
### V3.1
In version 3, calling codes are in the _idd_ object. There is no implementation 
to search by calling codes in V3.

## Region
### V2 - V3 & V3.1
Search by region (replace X with the version you want to use)

``` html
https://restcountries.com/vX/region/{region}
```
``` html
https://restcountries.com/vX/region/europe
```
## Subregions
### V2 - V3 & V3.1
You can search by subregions (replace X with the version you want to use)
``` html
https://restcountries.com/vX/subregion/{subregion}
```
``` html
https://restcountries.com/vX/subregion/Northern Europe
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

## Translation (*V3.x only*)
You can search by any translation name
``` html
https://restcountries.com/v3.1/translation/{translation}
```
``` html
https://restcountries.com/v3.1/translation/germany
```
``` html
https://restcountries.com/v3.1/translation/alemania
```
``` html
https://restcountries.com/v3.1/translation/Saksamaa
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
[donation]: https://www.paypal.me/amatosg/15
[donate]: https://www.paypal.me/amatosg/15
