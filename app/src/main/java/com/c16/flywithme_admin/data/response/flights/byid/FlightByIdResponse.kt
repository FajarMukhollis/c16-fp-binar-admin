package com.c16.flywithme_admin.data.response.flights.byid


import com.c16.flywithme_admin.data.model.flights.by_id.DataById
import com.google.gson.annotations.SerializedName

data class FlightByIdResponse(
    @SerializedName("data")
    val `data`: DataById?,
    @SerializedName("meesage")
    val meesage: String,
    @SerializedName("status")
    val status: String
)