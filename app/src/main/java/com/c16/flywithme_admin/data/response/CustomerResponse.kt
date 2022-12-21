package com.c16.flywithme_admin.data.response

import com.c16.flywithme_admin.data.model.list_user.User

data class CustomerResponse(
//    @SerializedName("data")
    val `data`: List<User>,
//    @SerializedName("message")
//    val message: String,
//    @SerializedName("status")
//    val status: Boolean
)