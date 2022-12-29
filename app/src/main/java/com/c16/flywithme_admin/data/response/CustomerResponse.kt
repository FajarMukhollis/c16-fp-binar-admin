package com.c16.flywithme_admin.data.response

import com.google.gson.annotations.SerializedName

data class CustomerResponse(
    @SerializedName("dataAdd")
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
        @SerializedName("email")
        val email: String,
        @SerializedName("password")
        val password: String,
        @SerializedName("NIK")
        val nik: String,
        @SerializedName("address")
        val address: String?,
        @SerializedName("phoneNumber")
        val phoneNumber: String?
    )
}