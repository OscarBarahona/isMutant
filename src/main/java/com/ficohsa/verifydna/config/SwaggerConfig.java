package com.ficohsa.verifydna.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.ficohsa.verifydna.controller"))
				.paths(PathSelectors.regex("/.*")).build().apiInfo(apiInfo());
	}

	public Docket apiDocket() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.codmind.swaggerapi.controllers"))
				.paths(PathSelectors.any()).build().apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Prueba Técnica - Programador (Back-end)")
				.description("Sabrás si un humano es mutante, si encuentras más de una secuencia de cuatro letras\r\n"
						+ "iguales, de forma oblicua, horizontal o vertical. \r\n" + "")
				.version("1.0").build();
	}
}
