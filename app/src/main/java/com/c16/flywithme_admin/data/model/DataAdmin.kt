package com.c16.flywithme_admin.data.model


import com.google.gson.annotations.SerializedName

data class DataAdmin(
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
    @SerializedName("roleId")
    val roleId: String,
//    @SerializedName("createdAt")
//    val createdAt: String,
//    @SerializedName("updatedAt")
//    val updatedAt: String
)