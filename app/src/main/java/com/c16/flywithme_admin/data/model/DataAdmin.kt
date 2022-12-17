package com.c16.flywithme_admin.data.model


import com.google.gson.annotations.SerializedName

data class DataAdmin(
    @SerializedName("createdAt")
    val createdAt: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("firstName")
    val firstName: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("lastName")
    val lastName: String,
    @SerializedName("password")
    val password: String,
    @SerializedName("roleId")
    val roleId: String,
    @SerializedName("updatedAt")
    val updatedAt: String
)