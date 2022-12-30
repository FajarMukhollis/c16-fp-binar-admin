package com.c16.flywithme_admin.data.repository

import androidx.lifecycle.LiveData
import com.c16.flywithme_admin.data.response.LoginResponse
import com.c16.flywithme_admin.result.Result

interface IAdminRepository {
    fun loginAdmin(email: String, pass: String): LiveData<Result<LoginResponse>>
}