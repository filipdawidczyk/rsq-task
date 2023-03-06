package com.example.rsqtask.adapter.`in`.web.config

import io.swagger.v3.oas.annotations.enums.ParameterIn
import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import io.swagger.v3.oas.models.media.StringSchema
import io.swagger.v3.oas.models.parameters.Parameter
import io.swagger.v3.oas.models.servers.Server
import org.springdoc.core.customizers.OpenApiCustomizer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
internal class OpenApiConfiguration {

    @Bean
    fun openApi(): OpenAPI {
        val info = Info().also {
            it.title = "RSQ TASK"
            it.description = "Handle app by swagger. Go ahead!"
        }
        return OpenAPI()
            .info(info)
            .servers(mutableListOf(Server().also { it.url = "http://localhost:8080/" }))
    }

    @Bean
    fun openApiCustomizer(): OpenApiCustomizer {
        return OpenApiCustomizer { openApi ->
            openApi.paths.values.map { pathItem ->
                pathItem
                    .readOperations()
                    .forEach { operation ->
                        operation.addParametersItem(
                            Parameter().name("x-tenant-id")
                                .schema(StringSchema())
                                .`in`(ParameterIn.HEADER.toString())
                                .required(false)
                        )
                    }
            }
        }
    }

}