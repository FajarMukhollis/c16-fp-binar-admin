package com.c16.flywithme_admin.data.response

import com.google.gson.annotations.SerializedName

data class CustomerResponse(
    @SerializedName("data")
    val `data`: ArrayList<User>,
    @SerializedName("message")
    val message: String,
    @SerializedName("status")
    val status: Boolean
){
    data class User(
        @SerializedName("id")
        val id: String,
        @SerializedName("firstName")
        val firstName: String,
        @SerializedName("lastName")
        val lastName: String,
    )
}