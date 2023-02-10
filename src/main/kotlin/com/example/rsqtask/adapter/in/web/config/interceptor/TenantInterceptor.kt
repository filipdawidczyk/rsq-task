package com.example.rsqtask.adapter.`in`.web.config.interceptor

import com.example.rsqtask.adapter.`in`.web.TENANT_ID_HEADER_KEY
import com.example.rsqtask.adapter.`in`.web.exception.MissingHeaderException
import com.example.rsqtask.adapter.out.repository.TenantContext
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.stereotype.Component
import org.springframework.web.servlet.HandlerInterceptor

@Component
internal class TenantInterceptor : HandlerInterceptor {

    override fun preHandle(request: HttpServletRequest, response: HttpServletResponse, handler: Any): Boolean {
        val tenantId = request.getHeader(TENANT_ID_HEADER_KEY)
        if (tenantId.isNullOrEmpty()) {
            throw MissingHeaderException("x-tenant-id header is missing")
        }
        TenantContext.setCurrentTenant(tenantId)
        return true
    }

    override fun afterCompletion(
        request: HttpServletRequest,
        response: HttpServletResponse,
        handler: Any,
        ex: Exception?
    ) {
        TenantContext.clear()
    }

}