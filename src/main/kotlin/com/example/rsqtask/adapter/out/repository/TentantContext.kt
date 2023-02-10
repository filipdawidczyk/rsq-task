package com.example.rsqtask.adapter.out.repository

object TenantContext {
    private val currentTenant = ThreadLocal<String>()

    fun getCurrentTenant(): String? = currentTenant.get()

    fun setCurrentTenant(tenant: String) {
        currentTenant.set(tenant)
    }

    fun clear() {
        currentTenant.remove()
    }
}