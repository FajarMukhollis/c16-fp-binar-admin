package com.c16.flywithme_admin.data.model.flights


import com.google.gson.annotations.SerializedName

data class Seat(
    @SerializedName("bookingId")
    val bookingId: Int,
    @SerializedName("createdAt")
    val createdAt: String,
    @SerializedName("flightId")
    val flightId: Int,
    @SerializedName("id")
    val id: Int,
    @SerializedName("seatNumber")
    val seatNumber: String,
    @SerializedName("updatedAt")
    val updatedAt: String
)