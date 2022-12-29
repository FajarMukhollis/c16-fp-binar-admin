package com.c16.flywithme_admin.data.response.flights.add


import com.c16.flywithme_admin.data.model.flights.add.DataAdd
import com.google.gson.annotations.SerializedName

data class AddFlightsResponse(
    @SerializedName("data")
    val dataAdd: DataAdd,
    @SerializedName("message")
    val message: String,
    @SerializedName("status")
    val status: String
)