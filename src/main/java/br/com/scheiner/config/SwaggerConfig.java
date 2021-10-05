package br.com.scheiner.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;

@Configuration
public class SwaggerConfig {

	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI()
				.components(
						new Components().addSecuritySchemes("bearer-jwt",
						new SecurityScheme()
						.type(SecurityScheme.Type.HTTP)
						.scheme("bearer")
						.bearerFormat("JWT")
					    .in(SecurityScheme.In.HEADER)
					    .name("Authorization")))
				.info(new Info().title("App API JWT").version("0.0.1"))
				.addSecurityItem(new SecurityRequirement().addList("bearer-jwt"));
	}
}
