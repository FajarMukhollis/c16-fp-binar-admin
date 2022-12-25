package com.c16.flywithme_admin.data.response.flights


import com.c16.flywithme_admin.data.model.flights.DataFlights
import com.google.gson.annotations.SerializedName

data class FlightsResponse(
    @SerializedName("data")
    val `data`: ArrayList<DataFlights>,
    @SerializedName("meesage")
    val meesage: String,
    @SerializedName("status")
    val status: String
)