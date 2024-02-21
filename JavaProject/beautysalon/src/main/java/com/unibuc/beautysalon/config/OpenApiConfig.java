package com.unibuc.beautysalon.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                contact = @Contact(
                        name = "Amalia",
                        email = "amalia.geman@gmai.com",
                        url = "https://github.com/gemanamalia"
                ),
                description = "OpenApi Documentation for Beauty Salon",
                title = "OpenApi Beauty Salon",
                version = "1.0"
        ),
        servers = {
                @Server(
                        description = "Local ENV",
                        url = "http://localhost:8080"
                )
        }
)

public class OpenApiConfig {

}
