# REST Countries APIs

Country data API. 250+ countries, 80+ fields per record, sub-150ms responses.

```bash
curl "https://api.restcountries.com/countries/v5?limit=1&pretty=1" \
  -H "Authorization: Bearer rc_live_demo"
```

[restcountries.com](https://restcountries.com) · [Docs](https://restcountries.com/docs) · [support@restcountries.com](mailto:support@restcountries.com)

---

## What you get

| | |
| --- | --- |
| **Coverage** | 250+ countries, including dependencies and disputed territories |
| **Fields** | 80+ per record across 14+ groups |
| **Localization** | Country names in 25+ languages |
| **Sources** | UN, World Bank, native country datasets, Wikipedia |
| **Freshness** | 4h sync cadence; populations and leaders tracked live |
| **Performance** | <150ms average response |
| **Reliability** | Public status page, uptime monitoring |

Fields include: names, ISO codes, capitals, flags, currencies, languages,
geography, borders, calling codes, time zones, political leaders, demographics
and memberships (EU, NATO, G7, G20, and more).

Full reference at [restcountries.com/docs](https://restcountries.com/docs).

---

## Quick reference (sample of endpoints)

```
GET /countries/v5                               List all countries
GET /countries/v5?q=Canada                      Query all countries
GET /countries/v5?response_fields=...           Trim the response
GET /countries/v5?response_fields_omit=...      Omit certain fields from the response
GET /countries/v5/code/CA                       Read across multiple codes (codes.alpha_2, codes.alpha_3, codes.fips, etc)
GET /countries/v5/codes.alpha_2/CA              ISO 3166-1 read
GET /countries/v5/names.common/Canada           Country name read
GET /countries/v5?region=Europe                 Filter by region
GET /countries/v5?memberships=EU,NATO           Filter by membership
```

Auth: `Authorization: Bearer <your-key>` — get one at
    [restcountries.com/sign-up](https://restcountries.com/sign-up).

Full docs can be found at
[restcountries.com/docs](https://restcountries.com/docs).

---

## Code samples

### cURL

```bash
curl "https://api.restcountries.com/countries/v5/name/CA?pretty=1" \
  -H "Authorization: Bearer rc_live_demo"
```

### JavaScript

```javascript
const response = await fetch(
    'https://api.restcountries.com/countries/v5/name/CA',
    { headers: { 'Authorization': 'Bearer rc_live_demo' } }
);
const payload = await response.json();

// payload.data.objects[0].names.common        => "Canada"
// payload.data.objects[0].population          => 41575585
// payload.data.objects[0].currencies[0].code  => "CAD"
// payload.data.objects[0].memberships.g7      => true
```

### Node.js

```javascript
import fetch from 'node-fetch';

const response = await fetch(
    'https://api.restcountries.com/countries/v5?region=Europe&memberships=EU',
    { headers: { Authorization: 'Bearer rc_live_demo' } }
);
const payload = await response.json();
```

### Python

```python
import requests

response = requests.get(
    'https://api.restcountries.com/countries/v5',
    params={'response_fields': 'codes.alpha_2,names.common', 'sort': 'names.common'},
    headers={'Authorization': 'Bearer rc_live_demo'},
)
payload = response.json()
```

### PHP

```php
$ch = curl_init('https://api.restcountries.com/countries/v5/name/CA');
curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
curl_setopt($ch, CURLOPT_HTTPHEADER, ['Authorization: Bearer rc_live_demo']);
$response = curl_exec($ch);
curl_close($ch);
$payload = json_decode($response, true);
```

The `rc_live_demo` key is shared and rate-limited but live. It will only return
country data for `Canada` but should give you a sense for the response shape.

Get your own at API key at
[restcountries.com/sign-up](https://restcountries.com/sign-up).

---

## FAQ

**I was hitting the old hosted endpoint. What now?**

The old endpoints are no longer active — the previous API wasn't designed in a
way that made keeping them running alongside the new one practical. Sign up at
[restcountries.com/sign-up](https://restcountries.com/sign-up), then email
[support@restcountries.com](mailto:support@restcountries.com) from the address
you sign up with and mention you were a previous user. We'll do our best to help
you migrate things.

**I was self-hosting from the MPL-2.0 source. Do I have to move?**

No. You can keep running whatever version you have — the license is unchanged.
If you want to move to the hosted version, the path above applies.

**Is there a free tier?**

Yes. There is a permanent free allotment for existing users of the legacy
project, and a free tier available to everyone. See
[restcountries.com](https://restcountries.com) for current plan details.

**What changed in v5 versus the old schema?**

The shape is similar by design. The main differences are: records are now
reconciled across multiple authoritative sources. Fast-moving fields like
population and political leaders are tracked continuously rather than frozen at
import; and the inconsistencies that accumulated over six years of organic
growth have been cleaned up. The full field reference is at
[restcountries.com/docs](https://restcountries.com/docs).

**I was building on top of the project.**

If you maintain a library, integration, or tutorial that points at the old
endpoints or schema, please reach out at
[support@restcountries.com](mailto:support@restcountries.com). We'll help you
update, and where useful, link to your work from the new docs.

**Where's the source?**

The MPL-2.0 source is still in this repo and will stay here. It is no longer
maintained, but it is available to read, fork, or run. New open source pieces —
client libraries, SDKs, standalone helpers — will be published under this
organization as they're released.

---

## New in v5 (relative to v4)

v5 keeps the familiar shape but adds several fields and field groups that
weren't in v4. The notable additions:

| Group | New fields |
| --- | --- |
| **Dates & calendars** | `date.academic_year_start` (month/day), `date.fiscal_year_start` for `government`, `corporate`, and `personal` (month/day, plus a `corporate.basis` of mandated/default/convention) |
| **Number formatting** | `number_format.decimal_separator`, `number_format.thousands_separator` |
| **Memberships** | Discrete booleans replacing v4's `regionalBlocs` list — `memberships.un`, `.eu`, `.eurozone`, `.schengen`, `.nato`, `.commonwealth`, `.oecd`, `.g7`, `.g20`, `.brics`, `.opec`, `.african_union`, `.asean`, `.arab_league` |
| **Classification & lineage** | `classification.un_observer`, `.disputed`, `.dependency`, `.dependency_type`, plus `parent.alpha_2` / `parent.alpha_3` for dependent territories |
| **Codes** | `codes.fips`, `codes.gec` |
| **Geography** | `area.miles` alongside `area.kilometers` |
| **Capitals** | `capitals` entries now carry coordinates and role attributes (primary, constitutional, administrative, executive, legislative, judicial) |
| **Flags** | `flag.unicode`, `flag.html_entity`, and `flag.description` (alt text) alongside the emoji and image URLs |
| **Links** | `links.wikipedia`, `links.official` alongside `links.google_maps` and `links.open_street_maps` |
| **Leaders** | `leaders` is now a first-class field, each with `assets`, `attributes`, `links`, `name`, and `title` |
| **Other** | `uuid` stable per-country identifier, and an `assets` container for associated visual assets |

Each new scalar or array field is independently readable and searchable (e.g.
`/countries/v5/memberships.nato/true`, `/countries/v5/codes.gec?q=GM`). The full
field reference is at [restcountries.com/docs](https://restcountries.com/docs).

---

## The MPL-2.0 release (old codebase)

This repository has been the home of the MPL-2.0 source for REST Countries APIs
since 2020, and that code is staying here. It will not be maintained going
forward — no new features, no bug fixes, no dependency updates — but it remains
available under the same license for anyone who wants to read it, fork it, or
run it.

If you are self-hosting and things are working, carry on. The license hasn't
changed and there is no obligation to move.

That said, the self-hosted version is now frozen in time. It won't gain the data
improvements, the live population and leader tracking, the multi-source
reconciliation, or the reliability improvements that the hosted API has. If
uptime and data freshness matter to your use case, the hosted API at
[restcountries.com](https://restcountries.com) is the right path forward.

Going forward, new open source pieces will also be published here: a JavaScript
client library for browser and Node, language SDKs as demand justifies them, and
small standalone helpers for ISO codes, name normalization, and similar — all
under permissive licenses. Watch this repo for releases.

To the original author, and to everyone who built on top of the project across
six years of requests, integrations, tutorials, and pull requests: the work you
did is why this is worth continuing. Thank you.

---

## Gratitude

REST Countries APIs ran for six years on the work of one developer. It served
well over a billion requests and quietly became part of the plumbing for sign-up
flows, address forms, and analytics pipelines across the web.

The new team is committed to carrying that forward with the same intent: a
simple, dependable, developer-first API that does one thing exceptionally well.
Honest pricing. A free tier that's actually useful. Infrastructure designed to stay up.

For migration help, feature requests, pricing questions, or anything else:
[support@restcountries.com](mailto:support@restcountries.com).
