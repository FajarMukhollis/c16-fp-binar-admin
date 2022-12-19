package com.c16.flywithme_admin.data.response

import com.google.gson.annotations.SerializedName

data class CustomerResponse(
    @SerializedName("address")
    val address: String,
    @SerializedName("dateOfBirth")
    val dateOfBirth: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("firstName")
    val firstName: String,
    @SerializedName("gender")
    val gender: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("image")
    val image: String,
    @SerializedName("lastName")
    val lastName: String,
    @SerializedName("NIK")
    val nik: Int,
    @SerializedName("password")
    val password: String,
    @SerializedName("phoneNumber")
    val phoneNumber: String,
    @SerializedName("roleId")
    val roleId: String
)
