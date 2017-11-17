package org.tars.ats.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket

@Configuration
class SwaggerConfig {
    @Bean
    fun testApi(): Docket {
        return Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("org.tars.ats"))
                .paths(PathSelectors.any()).build()
    }

    private fun apiInfo(): ApiInfo {
        return ApiInfoBuilder()
                .title("Web APIs")
                .description("由swagger自动创建")
                .termsOfServiceUrl("")
                .version("1.0")
                .build()
    }
}
