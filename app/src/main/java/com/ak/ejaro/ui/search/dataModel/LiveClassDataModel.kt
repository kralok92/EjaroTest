package com.ak.ejaro.ui.search.dataModel


import com.google.gson.annotations.SerializedName

data class LiveClassDataModel(
    @SerializedName("data")
    val liveData: LiveClassDataItem.LiveData?,
    @SerializedName("message")
    val message: String,
    @SerializedName("status")
    val status: Boolean
)