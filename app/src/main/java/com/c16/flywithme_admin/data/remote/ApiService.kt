package com.c16.flywithme_admin.data.remote

import com.c16.flywithme_admin.data.request.LoginRequest
import com.c16.flywithme_admin.data.response.CustomerResponse
import com.c16.flywithme_admin.data.response.LoginResponse
import com.c16.flywithme_admin.data.response.flights.FlightsResponse
import retrofit2.*
import retrofit2.http.*

interface ApiService {

    @POST("api/login/admin")
    suspend fun loginAdmin(
        @Body loginRequest: LoginRequest
    ) : Response<LoginResponse>

    //GET LIST DATA CUSTOMER
    @GET("api/users/findAll")
//    @Headers("accept: application/json", "content-type: application/json")
    fun getlistCustomer(): Call<CustomerResponse>

    //GET DATA LIST FLIGHT
    @GET("api/flights/findAll")
    fun getlistFlight(): Call<FlightsResponse>

}