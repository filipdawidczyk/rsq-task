package com.example.rsqtask.adapter.`in`.web.config

import com.example.rsqtask.adapter.`in`.web.config.interceptor.TenantInterceptor
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
internal class WebConfig : WebMvcConfigurer {

    @Autowired
    private lateinit var tenantInterceptor: TenantInterceptor

    override fun addInterceptors(registry: InterceptorRegistry) {
        registry.addInterceptor(tenantInterceptor)
    }
}