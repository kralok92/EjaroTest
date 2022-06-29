package com.ak.vendor.dataModel


import com.google.gson.annotations.SerializedName

 data class BannerDetail(
    @SerializedName("banner_link")
    val bannerLink: String?,
    @SerializedName("category")
    val category: String?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("image")
    val image: String?,
    @SerializedName("title")
    val title: String?
){

     constructor() : this(null,null,null,null,null)
 }