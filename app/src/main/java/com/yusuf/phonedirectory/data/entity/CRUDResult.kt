package com.yusuf.phonedirectory.data.entity

import com.google.gson.annotations.SerializedName

data class CRUDResult(

    @SerializedName("success")
    var success: Int,

    @SerializedName("message")
    var message: String
)
