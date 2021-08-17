package com.steve.academysteveback.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

  private ApiInfo apiInfo() {
    return new ApiInfoBuilder().title("SteveUser API LIST").description(null).build();
  }


  @Bean
  public Docket userApi() {
    return new Docket(DocumentationType.SWAGGER_2)
            .groupName("USER-API")
            .apiInfo(this.apiInfo())
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.steve.academysteveback.user"))
            .paths(PathSelectors.ant("/**"))
            .build();
  }

/*
  @Bean
  public Docket authApi() {
    return new Docket(DocumentationType.SWAGGER_2)
            .groupName("AUTH-API")
            .apiInfo(this.apiInfo())
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.steve.common.user.project"))
            .paths(PathSelectors.ant("/api/v1/auth/**"))
            .build();
  }


  @Bean
  public Docket supportApi() {
    return new Docket(DocumentationType.SWAGGER_2)
            .groupName("SUPPORT-API")
            .apiInfo(this.apiInfo())
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.steve.common.user.project"))
            .paths(PathSelectors.ant("/api/v1/support/**"))
            .build();
  }

 */
}
