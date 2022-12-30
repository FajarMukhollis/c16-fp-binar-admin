package com.c16.flywithme_admin.data.response.flights.update

import com.google.gson.annotations.SerializedName

data class UpdateFlightsResponse(
    @SerializedName("message")
    val message: String,
    @SerializedName("status")
    val status: String
)
