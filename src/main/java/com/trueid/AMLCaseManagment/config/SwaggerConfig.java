package com.trueid.AMLCaseManagment.config;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;

import io.swagger.models.parameters.Parameter;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Contact;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

	public static final String AUTHORIZATION_HEADER = "Authorization";

	private static final Set<String> DEFAULT_PRODUCES_CONSUMES = new HashSet<String>(Arrays.asList("application/json"));

	/*
	 * @Bean public Docket api() { return new
	 * Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
	 * .securityContexts(Arrays.asList(securityContext())).securitySchemes(Arrays.
	 * asList(apiKey())).select()
	 * .apis(RequestHandlerSelectors.any()).paths(PathSelectors.any()).build(); }
	 */

	  @Bean
	  public Docket api() {
	    ParameterBuilder parameterBuilder = new ParameterBuilder();
	    parameterBuilder.name("Authorization")
			    .modelRef(new ModelRef("string"))
			    .parameterType("header")
			    .description("JWT token")
			    .required(true)
			    .build();
	    List<springfox.documentation.service.Parameter> parameters = new ArrayList<>();
	    parameters.add((springfox.documentation.service.Parameter) parameterBuilder.build());
	    return new Docket(DocumentationType.SWAGGER_2)
		    .produces(DEFAULT_PRODUCES_CONSUMES)
		    .consumes(DEFAULT_PRODUCES_CONSUMES)
		    .select()
		    .build()
		    // Setting globalOperationParameters ensures that authentication header is applied to all APIs
		    .globalOperationParameters(parameters);
	  }

	private SecurityContext securityContext() {
		return SecurityContext.builder().securityReferences(defaultAuth()).build();
	}

	private List<SecurityReference> defaultAuth() {
		AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
		AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
		authorizationScopes[0] = authorizationScope;
		return Arrays.asList(new SecurityReference("JWT", authorizationScopes));
	}
}