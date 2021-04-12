package com.cts.student.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
/**
 * 
 * @author 882851
 * SwaggerConfig class used to configure swagger information
 *
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
/**
*
* @return
*/
@Bean
     public Docket postsApi() {
         return new Docket(DocumentationType.SWAGGER_2)
                 .apiInfo(apiInfo())
                 .select()
                 .paths(PathSelectors.ant("/api/**"))
                 .build();
     }

 
     private ApiInfo apiInfo() {
         return new ApiInfoBuilder()
                 .title("Student Service")
                 .description("Student Service API")
                 .termsOfServiceUrl("http://www.cognizant.com")
                 .version("2.0")
                 .build();
     }
}
