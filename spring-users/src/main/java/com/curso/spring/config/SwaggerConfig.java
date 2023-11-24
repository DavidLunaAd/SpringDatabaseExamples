package com.curso.spring.config;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Admin;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.models.OpenAPI;

//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.service.ApiKey;
//import springfox.documentation.service.AuthorizationScope;
//import springfox.documentation.service.Contact;
//import springfox.documentation.service.SecurityReference;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spi.service.contexts.SecurityContext;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * Configuracion Swagger para la generacion de documentacion de la API REST
 */

@Configuration
public class SwaggerConfig {
	
	@Bean
	  public GroupedOpenApi publicApi() {
	      return GroupedOpenApi.builder()
	              .group("springshop-public")
	              .pathsToMatch("/public/**")
	              .build();
	  }

//	  @Bean
//	  public OpenAPI springShopOpenAPI() {
//	      return new OpenAPI()
//	              .info(new Info().title("SpringShop API")
//	              .description("Spring shop sample application")
//	              .version("v0.0.1")
//	              .license(new License().name("Apache 2.0").url("http://springdoc.org")))
//	              .externalDocs(new ExternalDocumentation()
//	              .description("SpringShop Wiki Documentation")
//	              .url("https://springshop.wiki.github.org/docs"));
//	  }


	
//	 public static final String AUTHORIZATION_HEADER = "Authorization";
//
//	 private ApiKey apiKey(){
//	       return new ApiKey("JWT", AUTHORIZATION_HEADER, "header");
//	 }
//	
//	@Bean
//	public Docket api() {
//		return new Docket(DocumentationType.SWAGGER_2)
//				.apiInfo(apiDetails())
//				.securityContexts(Arrays.asList(securityContext()))
//                .securitySchemes(Arrays.asList(apiKey()))
//				.select()
//				.apis(RequestHandlerSelectors.any())
//				.paths(PathSelectors.any())
//				.build();
//	}
//	
//	 private SecurityContext securityContext(){
//	        return SecurityContext.builder().securityReferences(defaultAuth()).build();
//	    }
//	 
//	 private List<SecurityReference> defaultAuth(){
//	        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
//	        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
//	        authorizationScopes[0] = authorizationScope;
//	        return Arrays.asList(new SecurityReference("JWT", authorizationScopes));
//	    }
//	
//	private ApiInfo apiDetails() {
//		return new ApiInfo("DvD Admin API REST", 
//				"Spring Boot API REST", 
//				"1.0", 
//				"http://localhost/terms", 
//				new Contact("DvD","www.dvd.com","Prueba"),
//				"Prueba",
//				"Prueba",
//				 Collections.emptyList());
//	}

}
