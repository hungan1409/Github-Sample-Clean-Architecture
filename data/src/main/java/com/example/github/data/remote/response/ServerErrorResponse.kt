package com.example.github.data.remote.response

import com.google.gson.JsonObject
import com.google.gson.annotations.SerializedName

data class ServerErrorResponse(
    @SerializedName("message")
    val message: String? = null,

    @SerializedName("errors")
    val errors: List<JsonObject>? = null
)