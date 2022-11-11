package com.app.config;



import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
@Configuration
@EnableSwagger2
public class ReimbursementSwaggerConfig {

	
	@Bean
	public Docket postsApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("Reimbursement - Rest API's").apiInfo(apiInfo()).select()
				.paths(regex("/reimbursement.*")).build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Reimbursement Rest Services")
				.description("Sample Documentation Generated Using SWAGGER2 for our Reimbursement Rest API")
				.termsOfServiceUrl("https://www.youtube.com/channel/UCORuRdpN2QTCKnsuEaeK-kQ")
				.license("Java Swagger docs")
				.licenseUrl("sreenithamandapalli1819@gmail.com").version("1.0").build();
	}
	
}

