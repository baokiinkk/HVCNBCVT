package com.baokiiin.hvcnbcvt.data.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable
import java.lang.RuntimeException

data class ResponseError(
    @SerializedName("status_code")
    val status_code: Int,
    @SerializedName("status_message")
    val status_message: String,
    val param_errors: String? = null
) : RuntimeException(), Serializable