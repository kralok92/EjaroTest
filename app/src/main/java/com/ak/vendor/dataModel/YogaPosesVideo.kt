package com.ak.vendor.dataModel


import com.google.gson.annotations.SerializedName

data class YogaPosesVideo(
    @SerializedName("duration")
    val duration: String?,
    @SerializedName("image")
    val image: String?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("video_count")
    val videoCount: String?
){
    constructor() : this(null, null, null, null)
}