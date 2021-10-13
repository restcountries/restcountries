package dev.amatos.restcountries;

import dev.amatos.restcountries.domain.v2.Country;
import dev.amatos.restcountries.domain.v2.Currency;
import dev.amatos.restcountries.domain.v2.Language;
import dev.amatos.restcountries.domain.v2.RegionalBloc;
import dev.amatos.restcountries.domain.v2.Translations;
import dev.amatos.restcountries.service.v2.CountryServiceV2;
import io.micronaut.test.annotation.MicronautTest;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@MicronautTest
class RestCountriesV2Test {

  @Test
  void getAll() {
    List<Country> countries = CountryServiceV2.getInstance().getAll();
    Assertions.assertFalse(countries.isEmpty());
  }

  @Test
  void getByAlpha2() {
    Country country = CountryServiceV2.getInstance().getByAlpha("CO");
    Assertions.assertNotNull(country);
    Assertions.assertEquals("CO", country.getAlpha2Code());
  }

  @Test
  void getByAlpha3() {
    Country country = CountryServiceV2.getInstance().getByAlpha("COL");
    Assertions.assertNotNull(country);
    Assertions.assertEquals("COL", country.getAlpha3Code());
  }

  @Test
  void getByCodeList() {
    List<Country> countries = CountryServiceV2.getInstance().getByCodeList("CO,NOR,EE");
    Assertions.assertNotNull(countries);
    Assertions.assertFalse(countries.isEmpty());
    Assertions.assertEquals(3, countries.size());

    for (Country country : countries) {
      Assertions.assertTrue(
          country.getAlpha2Code().equals("CO") || country.getAlpha2Code().equals("NO")
              || country.getAlpha2Code().equals("EE"));
    }
  }

  @Test
  void getByCurrency() {
    List<Country> countries = CountryServiceV2.getInstance().getByCurrency("EUR");
    Assertions.assertNotNull(countries);
    Assertions.assertFalse(countries.isEmpty());
    for (Country country : countries) {
      for (Currency currency : country.getCurrencies()) {
        Assertions.assertEquals("EUR", currency.getCode());
      }
    }
  }

  @Test
  void getByName() {
    List<Country> countries = CountryServiceV2.getInstance().getByName("Norway", false);
    Assertions.assertFalse(countries.isEmpty());
    Assertions.assertEquals("Norway", countries.get(0).getName());
  }

  @Test
  void getByNamePriority() {
    List<Country> countries = CountryServiceV2.getInstance().getByName("Iran", false);
    Assertions.assertNotNull(countries);
    Assertions.assertFalse(countries.isEmpty());
    Assertions.assertEquals("Iran (Islamic Republic of)", countries.get(0).getName());

    countries = CountryServiceV2.getInstance().getByName("United", false);
    Assertions.assertNotNull(countries);
    Assertions.assertFalse(countries.isEmpty());
    Assertions.assertEquals("United States Minor Outlying Islands", countries.get(0).getName());
  }

  @Test
  void getByNameAlt() {
    List<Country> countries = CountryServiceV2.getInstance().getByName("Norge", false);
    Assertions.assertNotNull(countries);
    Assertions.assertFalse(countries.isEmpty());
    Assertions.assertEquals("Norway", countries.get(0).getName());
  }

  @Test
  void getByNameFullText() {
    List<Country> countries = CountryServiceV2.getInstance().getByName("Russian Federation", true);
    Assertions.assertNotNull(countries);
    Assertions.assertFalse(countries.isEmpty());
    Assertions.assertEquals("Russian Federation", countries.get(0).getName());
  }

  @Test
  void getByNameFullTextNotFound() {
    List<Country> countries = CountryServiceV2.getInstance().getByName("Russian Fed", true);
    Assertions.assertNotNull(countries);
    Assertions.assertTrue(countries.isEmpty());
  }

  @Test
  void getByCallingCode() {
    List<Country> countries = CountryServiceV2.getInstance().getByCallingCode("57");
    Assertions.assertNotNull(countries);
    Assertions.assertFalse(countries.isEmpty());
    Assertions.assertEquals(1, countries.size());
    Assertions.assertEquals("CO", countries.get(0).getAlpha2Code());
  }

  @Test
  void getByCapital() {
    List<Country> countries = CountryServiceV2.getInstance().getByCapital("Tallinn");
    Assertions.assertNotNull(countries);
    Assertions.assertFalse(countries.isEmpty());
    Assertions.assertEquals(1, countries.size());
    Assertions.assertEquals("EE", countries.get(0).getAlpha2Code());
    Assertions.assertEquals("Eesti", countries.get(0).getNativeName());
  }

  @Test
  void getByRegion() {
    List<Country> countries = CountryServiceV2.getInstance().getByRegion("Europe");
    Assertions.assertNotNull(countries);
    Assertions.assertFalse(countries.isEmpty());
    for (Country country : countries) {
      Assertions.assertEquals("Europe", country.getRegion());
    }
  }

  @Test
  void getBySubregion() {
    List<Country> countries = CountryServiceV2.getInstance().getBySubregion("Northern Europe");
    Assertions.assertNotNull(countries);
    Assertions.assertFalse(countries.isEmpty());
    for (Country country : countries) {
      Assertions.assertEquals("Northern Europe", country.getSubregion());
    }
  }

  @Test
  void getByLanguageCode() {
    List<Country> countries = CountryServiceV2.getInstance().getByLanguage("es");
    Assertions.assertNotNull(countries);
    Assertions.assertFalse(countries.isEmpty());
    for (Country country : countries) {
      for (Language language : country.getLanguages()) {
        if (language.getIso639_1().equals("es")) {
          return;
        }
      }
    }
    Assertions.fail();
  }

  @Test
  void getByDemonym() {
    List<Country> countries = CountryServiceV2.getInstance().getByDemonym("french");
    Assertions.assertNotNull(countries);
    Assertions.assertFalse(countries.isEmpty());
    for (Country country : countries) {
      Assertions.assertEquals("french", country.getDemonym().toLowerCase());
    }
  }

  @Test
  void getByRegionalBloc() {
    List<Country> countries = CountryServiceV2.getInstance().getByRegionalBloc("eu");
    Assertions.assertNotNull(countries);
    Assertions.assertFalse(countries.isEmpty());
    for (Country country : countries) {
      for (RegionalBloc regionalBloc : country.getRegionalBlocs()) {
        if (regionalBloc.getAcronym().equalsIgnoreCase("eu")) {
          return;
        }
      }
    }
    Assertions.fail();
  }

  @Test
  void translations() {
    Country country = CountryServiceV2.getInstance().getByAlpha("COL");
    Assertions.assertNotNull(country);
    Translations translations = country.getTranslations();
    Assertions.assertEquals("Kolumbien", translations.getDe());
    Assertions.assertEquals("Colombia", translations.getEs());
    Assertions.assertEquals("Colombie", translations.getFr());
    Assertions.assertEquals("コロンビア", translations.getJa());
    Assertions.assertEquals("Colombia", translations.getIt());
    Assertions.assertEquals("Colômbia", translations.getBr());
    Assertions.assertEquals("Colômbia", translations.getPt());
  }
}
