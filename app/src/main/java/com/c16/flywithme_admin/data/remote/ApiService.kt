package com.c16.flywithme_admin.data.remote

import com.c16.flywithme_admin.data.request.AddFlightsRequest
import com.c16.flywithme_admin.data.request.LoginRequest
import com.c16.flywithme_admin.data.request.UpdateFlightsResquest
import com.c16.flywithme_admin.data.response.CustomerResponse
import com.c16.flywithme_admin.data.response.LoginResponse
import com.c16.flywithme_admin.data.response.flights.FlightsResponse
import com.c16.flywithme_admin.data.response.flights.add.AddFlightsResponse
import com.c16.flywithme_admin.data.response.flights.byid.FlightByIdResponse
import com.c16.flywithme_admin.data.response.flights.delete.DeleteFlightsResponse
import com.c16.flywithme_admin.data.response.flights.update.UpdateFlightsResponse
import retrofit2.*
import retrofit2.http.*

interface ApiService {

    @POST("api/login/admin")
    suspend fun loginAdmin(
        @Body loginRequest: LoginRequest
    ): Response<LoginResponse>

    //GET LIST DATA CUSTOMER
    @GET("api/users/findAll")
    fun getlistCustomer(): Call<CustomerResponse>

    //GET DATA LIST FLIGHT
    @GET("api/flights/findAll")
    fun getlistFlight(): Call<FlightsResponse>

    //GET DATA FLIGHT BY ID (Detail Flight)
    @GET("api/flights/findById/{id}")
    fun getFlightsById(
        @Path("id") id: Int
    ): Call<FlightByIdResponse>

    //POST ADD FLIGHT
    @POST("api/flights/add")
    fun addFlight(
        @Body flights: AddFlightsRequest
    ): Call<AddFlightsResponse>

    //DELETE FLIGHT
    @DELETE("api/flights/delete/{id}")
    fun deleteFlights(
        @Path("id") id: Int,
        @Header("Authorization") token: String
    ): Call<DeleteFlightsResponse>

    //UPDATE FLIGHT
    @PUT("api/flights/update/{id}")
    fun updateFlights(
        @Query("id") id: Int,
        @Body flights: UpdateFlightsResquest
    ): Call<UpdateFlightsResponse>


}