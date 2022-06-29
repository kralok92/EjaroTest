package com.ak.vendor.dataModel


import com.google.gson.annotations.SerializedName

data class ExpertVideo(
    @SerializedName("category")
    val category: String?,
    @SerializedName("thumbnail")
    val thumbnail: String?
)
{
    constructor():this(null,null)
}