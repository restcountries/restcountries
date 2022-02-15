package dev.amatos.restcountries;

import io.micronaut.runtime.Micronaut;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;


@OpenAPIDefinition(
        info = @Info(
                title = "rest-countries",
                version = "3.1",
                description = "Get information about countries via a RESTful API",
                license = @License(name = "Mozilla Public License MPL 2.0", url = "https://www.mozilla.org/en-US/MPL/2.0/"),
                contact = @Contact(url = "https://restcountries.com", name = "Alejandro Matos")
        )
)
public class Application {
    public static void main(String[] args) {
        Micronaut.run(Application.class, args);
    }
}
