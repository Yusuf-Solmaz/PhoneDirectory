package com.yusuf.phonedirectory.data.entity

import com.google.gson.annotations.SerializedName

data class ResultKisiler(

    @SerializedName("kisiler")
    var kisiler: List<Kisiler>,

    @SerializedName("success")
    var success: Int

)
