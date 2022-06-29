package com.ak.vendor.dataModel


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("bannerDetails")
    val bannerDetails: List<BannerDetail>?,
    @SerializedName("category")
    val category: List<Category>?,
    @SerializedName("expertVideos")
    val expertVideos: List<ExpertVideo>?,
    @SerializedName("liveYogaClasses")
    val liveYogaClasses: List<LiveYogaClasse>?,
    @SerializedName("professionals")
    val professionals: List<Professional>?,
    @SerializedName("yogaPosesVideo")
    val yogaPosesVideo: List<YogaPosesVideo>?
)