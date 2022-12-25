package com.c16.flywithme_admin.data.model.user

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("id")
    val id: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("password")
    val password: String,
    @SerializedName("firstName")
    val firstName: String,
    @SerializedName("lastName")
    val lastName: String,
    @SerializedName("NIK")
    val nik: Int,
    @SerializedName("address")
    val address: String?,
    @SerializedName("phoneNumber")
    val phoneNumber: String,
    @SerializedName("image")
    val image: String,
    @SerializedName("dateOfBirth")
    val dateOfBirth: String,
    @SerializedName("gender")
    val gender: String,
    @SerializedName("roleId")
    val roleId: String
)

