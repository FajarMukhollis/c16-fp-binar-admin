package com.c16.flywithme_admin.di

import com.c16.flywithme_admin.data.remote.ApiConfig
import com.c16.flywithme_admin.data.repository.AdminRepository
import com.c16.flywithme_admin.data.repository.IAdminRepository
import com.c16.flywithme_admin.data.use_case.AdminInteract
import com.c16.flywithme_admin.data.use_case.AdminUseCase


object Injection {

    private fun provideUserRepository(): IAdminRepository {
        val apiConfig = ApiConfig.getApiService()
        return AdminRepository(apiConfig)
    }

    fun provideUserUseCase(): AdminUseCase {
        val repository = provideUserRepository()
        return AdminInteract(repository)
    }

}