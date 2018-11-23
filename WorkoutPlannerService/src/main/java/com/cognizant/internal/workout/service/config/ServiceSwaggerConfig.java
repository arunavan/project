package com.cognizant.internal.workout.service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.ApiKeyVehicle;
import springfox.documentation.swagger.web.SecurityConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger 2 Configuration File
 *
 */
@Configuration
@EnableSwagger2
public class ServiceSwaggerConfig {

    /**
     * Configure Swagger initialization parameter
     *
     * @return Docket details required by swagger to configure
     */
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage("com.cognizant.internal.workout.service.rest")).paths(PathSelectors.any()).build();
    }

    /**
     * Set the authentication style
     *
     * @return SecurityConfiguration the security configuration
     */
   // @Bean
    public SecurityConfiguration security() {
        return new SecurityConfiguration(null, null, null, null, null, ApiKeyVehicle.HEADER, "Authorization", null);
    }

}
