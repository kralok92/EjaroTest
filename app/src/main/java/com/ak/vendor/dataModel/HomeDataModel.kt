package com.ak.vendor.dataModel


import com.google.gson.annotations.SerializedName

data class HomeDataModel(
    @SerializedName("data")
    val `data`: Data?,
    @SerializedName("message")
    val message: String?,
    @SerializedName("status")
    val status: Boolean?
)