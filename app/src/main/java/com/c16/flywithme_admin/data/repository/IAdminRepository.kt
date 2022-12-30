package com.c16.flywithme_admin.data.repository

import androidx.lifecycle.LiveData
import com.c16.flywithme_admin.data.model.DataAdmin
import com.c16.flywithme_admin.data.model.login.AdminLogin
import com.c16.flywithme_admin.result.Result

interface IAdminRepository {
    fun loginAdmin(email: String, pass: String): LiveData<Result<AdminLogin>>

    fun getDetailAdmin(
        id: String
    ): LiveData<Result<DataAdmin>>
}