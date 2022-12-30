package com.c16.flywithme_admin.data.response.flights.delete


import com.google.gson.annotations.SerializedName

data class DeleteFlightsResponse(
    @SerializedName("message")
    val message: String,
    @SerializedName("status")
    val status: String
)