package com.c16.flywithme_admin.data.model.flights.add


import com.google.gson.annotations.SerializedName

data class DataAdd(
    @SerializedName("newFlight")
    val newFlight: NewFlight
)