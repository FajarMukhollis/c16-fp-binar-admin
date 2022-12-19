package com.c16.flywithme_admin.data.remote

import com.c16.flywithme_admin.data.request.CustomerRequest
import com.c16.flywithme_admin.data.request.LoginRequest
import com.c16.flywithme_admin.data.response.CustomerResponse
import com.c16.flywithme_admin.data.response.LoginResponse
import retrofit2.*
import retrofit2.http.*

interface ApiService {

    @POST("api/login/admin")
    suspend fun loginAdmin(
        @Body loginRequest: LoginRequest
    ) : Response<LoginResponse>

    //GET DATA CUSTOMER
    @GET("api/users/findAll")
    suspend fun listCustomer(
        @Body CustomerRequest: CustomerRequest
    ) : Call<List<CustomerResponse>>
}