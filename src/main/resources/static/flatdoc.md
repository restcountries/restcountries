REST Countries 🇵🇪
=======

Get information about countries via a RESTful API

*Current version: 3.1*

# About this Project

This project is inspired on restcountries.eu by Fayder Florez. Although the original project has now
moved to
a subscription base API, this project is still Open Source and Free to use.

## Important Information

* The structure of V2 has been reverted to its original form from the [Original Project] to maintain
  compatibility.
* ***Only the latest version will receive updates and improvements.***

# REST Countries

You can access API through https://restcountries.com/v3.1/all but in order to get a faster response,
you should filter the results by the fields you need.
Like

``` html
https://restcountries.com/v3.1/all?fields=name,flags`
``` 

# Contributing

Any help is always welcome! Just edit the relevant file and create a new Merge Request or you can
also
donate using [Patreon](https://www.patreon.com/amatos)
or [PayPal](https://www.paypal.me/amatosg/15).

# Donations

This are getting out of control (in a positive way).
I'm getting about 4 million hits **each day** and that means CPU ussage (sometimes at 99%) and also
bandwidth consumption (120 GB **per day!**) so costs have obviously increased. **Please**, consider
making a donation on [Patreon](https://www.patreon.com/amatos)
or [PayPal](https://www.paypal.me/amatosg/15). This will help me pay the server's bills

# Fields (mandatory)

You can check the [FIELDS.md](https://gitlab.com/restcountries/restcountries/-/blob/master/FIELDS.md) file to get a description for each field (thanks to
@ePascalC!). You **must** specify the fields you need (up to 10 fields) when calling the `all` endpoints.

# API Endpoints

## Using this Project

- [Famosos](https://famosos.com)
- [Cultural Care](https://www.culturalcare.world/)
- [Covidata](https://worldcovidata.com/)
- [Asendia](https://tracking.asendia.com)
- [Picker](https://mwb.pickerexpress.com/#/login)

# Endpoints

Below are described the REST endpoints available that you can use to search for countries

## Latest added Enpoint

### Independent

Now you can get all independent (or not independent) countries by calling this endpoint:

``` html
https://restcountries.com/v3.1/independent?status=true
```

If you don't specify the status, true will be taken as default. You can mix it with the `fields`
filter like this:

``` html
https://restcountries.com/v3.1/independent?status=true&fields=languages,capital
```

## All
You **must** specify the fields you need (up to 10 fields) when calling the `all` endpoints,
otherwise you'll get a `bad request` response. Please see [this issue](https://gitlab.com/restcountries/restcountries/-/issues/265)
for more information. This applies to all versions.
``` html
https://restcountries.com/v3.1/all
```

## Name

**Search** by country name. If you want to get an exact match, use the next endpoint. It can be the
common or official value

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

Search by country's full name. It can be the common or official value

``` html
https://restcountries.com/v3.1/name/{name}?fullText=true
```

``` html
https://restcountries.com/v3.1/name/aruba?fullText=true
```

## Code

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

Search by cca2, ccn3, cca3 or cioc country code (yes, any!)

``` html
https://restcountries.com/v3.1/alpha?codes={code},{code},{code}
```

``` html
https://restcountries.com/v3.1/alpha?codes=170,no,est,pe
```

## Currency

Search by currency code or name

``` html
https://restcountries.com/v3.1/currency/{currency}
```

``` html
https://restcountries.com/v3.1/currency/cop
```

### Demonym

Now you can search by how a citizen is called.

``` html
https://restcountries.com/v3.1/demonym/{demonym}
```

``` html
https://restcountries.com/v3.1/demonym/peruvian
```

## Language

Search by language code or name

``` html
https://restcountries.com/v3.1/lang/{language}
```

``` html
https://restcountries.com/v3.1/lang/cop
```

``` html
https://restcountries.com/v3.1/lang/spanish
```

## Capital city

Search by capital city

``` html
https://restcountries.com/v3.1/capital/{capital}
```

``` html
https://restcountries.com/v3.1/capital/tallinn
```

## Calling code

In version 3, calling codes are in the _idd_ object. There is no implementation
to search by calling codes in V3.

## Region

Search by region (replace X with the version you want to use)

``` html
https://restcountries.com/v3.1/region/{region}
```

``` html
https://restcountries.com/v3.1/region/europe
```

## Subregions

You can search by subregions (replace X with the version you want to use)

``` html
https://restcountries.com/v3.1/subregion/{subregion}
```

``` html
https://restcountries.com/v3.1/subregion/Northern Europe
```

## Translation

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

## Filter Response

You can filter the output of your request to include only the specified fields.

``` html
https://restcountries.com/v3.1/{service}?fields={field},{field},{field}
```

``` html
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
