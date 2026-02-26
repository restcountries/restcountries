> **v4 Preview — Not for production use**
> REST Countries v4 is currently available as a **preview** at `/v4`. It introduces new fields,
> richer data, and breaking changes from v3.1. The API is still subject to change before its
> stable release. **Do not use it in production yet.**
> Join the discussion and share your feedback at
> [issue #286](https://gitlab.com/restcountries/restcountries/-/issues/286).

# About this Project

This project is inspired on restcountries.eu by Fayder Florez. Although the original project has now moved to
a subscription base API, this project is still Open Source and Free to use.

# REST Countries

You can access API through https://restcountries.com/v3.1/all

# Contributing

Any help is always welcome! Just edit the relevant file and create a new Merge Request.

# Donations

This are getting out of control. As I stated [here](https://gitlab.com/restcountries/restcountries/-/issues/187), the server is not going to hold much longer. I'm getting about 4 million hits **each day** and that means CPU ussage (99%) and also bandwidth consumption (120 GB **per day!**) so costs have obviously increased. **Please**, consider making a donation on [Patreon](https://www.patreon.com/amatos) or [PayPal](https://www.paypal.me/amatosg/15). This will help me pay the server's bills

# Fields

You can check the [FIELDS.md](FIELDS.md) file to get a description for each field (thanks to @ePascalC!). This file might be outdated and **will not** be updated.

# API Endpoints

# Endpoints

Below are described the REST endpoints available that you can use to search for countries

## Latest added Endpoint

### Independent

Now you can get all independent (or not independent) countries by calling this endpoint:

```html
https://restcountries.com/v3.1/independent?status=true
```

If you don't specify the status, true will be taken as default. You can mix it with the `fields` filter like this:

```html
https://restcountries.com/v3.1/independent?status=true&fields=languages,capital
```

## All

You **must** specify the fields you need (up to 10 fields) when calling the `all` endpoints,
otherwise you'll get a `bad request` response. Please see [this issue](https://gitlab.com/restcountries/restcountries/-/issues/265)
for more information. This applies to all versions.

```html
https://restcountries.com/v3.1/all
```

## Name

**Search** by country name. If you want to get an exact match, use the next endpoint. It can be the common or official value

```html
https://restcountries.com/v3.1/name/{name}
```

```html
https://restcountries.com/v3.1/name/eesti
```

```html
https://restcountries.com/v3.1/name/deutschland
```

## Full Name

Search by country's full name. It can be the common or official value

```html
https://restcountries.com/v3.1/name/{name}?fullText=true
```

```html
https://restcountries.com/v3.1/name/aruba?fullText=true
```

## Code

Search by cca2, ccn3, cca3 or cioc country code (yes, any!)

```html
https://restcountries.com/v3.1/alpha/{code}
```

```html
https://restcountries.com/v3.1/alpha/co
```

```html
https://restcountries.com/v3.1/alpha/col
```

```html
https://restcountries.com/v3.1/alpha/170
```

## List of codes

Search by cca2, ccn3, cca3 or cioc country code (yes, any!)

```html
https://restcountries.com/v3.1/alpha?codes={code},{code},{code}
```

```html
https://restcountries.com/v3.1/alpha?codes=170,no,est,pe
```

## Currency

Search by currency code or name

```html
https://restcountries.com/v3.1/currency/{currency}
```

```html
https://restcountries.com/v3.1/currency/cop
```

## Demonym

Now you can search by how a citizen is called.

```html
https://restcountries.com/v3.1/demonym/{demonym}
```

```html
https://restcountries.com/v3.1/demonym/peruvian
```

## Language

Search by language code or name

```html
https://restcountries.com/v3.1/lang/{currency}
```

```html
https://restcountries.com/v3.1/lang/cop
```

```html
https://restcountries.com/v3.1/lang/spanish
```

## Capital city

Search by capital city

```html
https://restcountries.com/v3.1/capital/{capital}
```

```html
https://restcountries.com/v3.1/capital/tallinn
```

## Calling code

In version 3, calling codes are in the _idd_ object. There is no implementation to search by calling codes in V3.

## Region

Search by region

```html
https://restcountries.com/v3.1/region/{region}
```

```html
https://restcountries.com/v3.1/region/europe
```

## Subregions

You can search by subregions

```html
https://restcountries.com/v3.1/subregion/{subregion}
```

```html
https://restcountries.com/v3.1/subregion/Northern Europe
```

## Translation

You can search by any translation name

```html
https://restcountries.com/v3.1/translation/{translation}
```

```html
https://restcountries.com/v3.1/translation/germany
```

```html
https://restcountries.com/v3.1/translation/alemania
```

```html
https://restcountries.com/v3.1/translation/saksamaa
```

## Filter Response

You can filter the output of your request to include only the specified fields.

```html
https://restcountries.com/v3.1/{endpoint}?fields={field},{field},{field}
```

```html
https://restcountries.com/v3.1/all?fields=name,capital,currencies
```

## REST Countries Typed API Package

Yusif Aliyev from Azerbaijan created [an npm package](https://www.npmjs.com/package/@yusifaliyevpro/countries)
which provides TypeScript support for the REST Countries API. Everyone can use
the package for their own purpose.
This package offers full type and autocomplete support for anyone using
JavaScript or TypeScript. Users no longer need to spend time reading
documentation or manually writing API URLs and types. You can easily use
all the package's functionalities by calling its functions.
He is also open to contributing further improvements.

You can find the code [here](https://github.com/yusifaliyevpro/countries)

## Similar projects

- [REST Countries] (original project)
- [Countries of the world]
- [REST Countries Node.js]
- [REST Countries Ruby]
- [REST Countries Go]
- [REST Countries Python]
- [REST Countries Java]
- [world-currencies]

[world-currencies]: https://github.com/wiredmax/world-currencies
[REST Countries Node.js]: https://github.com/aredo/restcountries
[REST Countries Ruby]: https://github.com/davidesantangelo/restcountry
[REST Countries Go]: https://github.com/alediaferia/gocountries
[REST Countries Python]: https://github.com/SteinRobert/python-restcountries
[REST Countries PHP]: https://github.com/hamedhaghi/countries-client
[Countries of the world]: http://countries.petethompson.net
[REST Countries]: https://github.com/apilayer/restcountries
[Original Project]: https://github.com/apilayer/restcountries/
[donation]: https://www.paypal.me/amatosg/15
[donate]: https://www.paypal.me/amatosg/15
[REST Countries Java]: https://github.com/awais2075/restcountries

---

# Migrating from v3.1 to v4

The v4 API is available at `https://restcountries.com/v4/`. Below are the changes you need to
account for when upgrading from v3.1.

## Base URL

```
# v3.1
https://restcountries.com/v3.1/{endpoint}

# v4
https://restcountries.com/v4/{endpoint}
```

## Fields with breaking shape changes

These fields exist in both versions but have a **different structure** in v4:

| Field             | v3.1 shape                          | v4 shape                                       |
| ----------------- | ----------------------------------- | ---------------------------------------------- |
| `name.nativeName` | `Map<langCode, {official, common}>` | `List<{lang, official, common}>`               |
| `languages`       | `Map<iso639_2, languageName>`       | `List<{iso639_1, iso639_2, name, nativeName}>` |
| `currencies`      | `Map<currencyCode, {name, symbol}>` | `List<{code, name, symbol}>`                   |
| `translations`    | `Map<langCode, {official, common}>` | `List<{lang, official, common}>`               |
| `demonyms`        | `Map<lang, {m, f}>`                 | `List<{lang, male, female}>`                   |
| `gini`            | `Map<year, value>`                  | `List<{year, value}>`                          |

## Removed fields

| Field                             | Replacement                                    |
| --------------------------------- | ---------------------------------------------- |
| `latlng`                          | Use `geolocation` (`{latitude, longitude}`)    |
| `flags` (object with svg/png/alt) | Merged into `flag` — see below                 |
| `flag` (emoji string)             | Moved inside the `flag` object as `flag.emoji` |

### `flag` / `flags` consolidation

In v3.1 there were two separate fields. In v4 they are a single `flag` object:

```json
// v3.1
"flag": "🇦🇼",
"flags": { "svg": "...", "png": "...", "alt": "..." }

// v4
"flag": { "svg": "...", "png": "...", "alt": "...", "emoji": "🇦🇼" }
```

## New fields in v4

| Field             | Description                                                             |
| ----------------- | ----------------------------------------------------------------------- |
| `callingCodes`    | Complete calling codes as a flat string list (e.g. `["297"]`)           |
| `geolocation`     | Named `{latitude, longitude}` object replacing the `latlng` array       |
| `sovereignState`  | `cca3` of the governing sovereign state; `""` for independent countries |
| `regionalBlocs`   | Regional/trade bloc memberships                                         |
| `religion`        | Religious group breakdown with population and percentage                |
| `ethnicity`       | Ethnic group breakdown with percentage                                  |
| `government`      | Government type and current leaders                                     |
| `density`         | Population density in people/km²                                        |
| `gdp`             | GDP total and per-capita in USD                                         |
| `hdi`             | Human Development Index score (0.0–1.0)                                 |
| `nationalHoliday` | National/independence day date string                                   |
| `anthem`          | Name of the national anthem                                             |

For the full field reference see [FIELDS_V4.md](FIELDS_V4.md).
