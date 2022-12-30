package com.c16.flywithme_admin.data.request

data class UpdateFlightsResquest(
    var airPortId: String,
    var destinationId: String,
    var flightNumber: String,
    var airLine: String,
    var from: String,
    var to: String,
    var depatureDate: String,
    var depatureTime: String,
    var arrivalDate: String,
    var arrivalTime: String,
    var capasity: String,
    var typeOfClass: String,
    var classPrice: String
)