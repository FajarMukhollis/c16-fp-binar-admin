package com.c16.flywithme_admin.data.model.flights.add


import com.google.gson.annotations.SerializedName

data class NewFlight(
//    @SerializedName("id")
//    val id: Int,
    @SerializedName("airPortId")
    val airPortId: String,
    @SerializedName("destinationId")
    val destinationId: String,
    @SerializedName("flightNumber")
    val flightNumber: String,
    @SerializedName("airLine")
    val airLine: String,
    @SerializedName("from")
    val from: String,
    @SerializedName("to")
    val to: String,
    @SerializedName("depatureDate")
    val depatureDate: String,
    @SerializedName("depatureTime")
    val depatureTime: String,
    @SerializedName("arrivalDate")
    val arrivalDate: String,
    @SerializedName("arrivalTime")
    val arrivalTime: String,
    @SerializedName("capasity")
    val capasity: String,
    @SerializedName("economyClassPrice")
    val economyClassPrice: String,
    @SerializedName("businessClassPrice")
    val businessClassPrice: String,
    @SerializedName("firstClassPrice")
    val firstClassPrice: String,
    @SerializedName("typeOfFlight")
    val typeOfFlight: String
//    @SerializedName("createdAt")
//    val createdAt: String,
//    @SerializedName("updatedAt")
//    val updatedAt: String
)