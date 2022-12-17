package com.c16.flywithme_admin.data.response


import com.c16.flywithme_admin.data.model.DataAdmin
import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("data")
    val `data`: DataAdmin,
    @SerializedName("message")
    val message: String,
    @SerializedName("status")
    val status: String,
    @SerializedName("token")
    val token: String
)