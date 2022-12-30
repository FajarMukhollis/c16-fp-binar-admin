package com.c16.flywithme_admin.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.c16.flywithme_admin.data.remote.ApiService
import com.c16.flywithme_admin.data.request.LoginRequest
import com.c16.flywithme_admin.data.response.LoginResponse
import com.c16.flywithme_admin.result.Result

class AdminRepository (
    private val apiService: ApiService
) : IAdminRepository {
    override fun loginAdmin(email: String, pass: String): LiveData<Result<LoginResponse>> = liveData {
        emit(Result.Loading)

        try {
            val response = apiService.loginAdmin(LoginRequest(email, pass))

//            if (response.body()?.status == false) {
            if (!response.body()?.status.toBoolean()) {
                emit(Result.Success(response.body()!!))
//            } else if (response.body()?.status == true) {
            } else if (response.body()?.status.toBoolean()) {
                emit(Result.Error("Email or Password not Found"))
            }
        } catch (e: Exception) {
            emit(Result.Error(e.message.toString()))
        }
    }
}