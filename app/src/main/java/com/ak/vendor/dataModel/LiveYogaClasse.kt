package com.ak.vendor.dataModel


import com.google.gson.annotations.SerializedName

data class LiveYogaClasse(
    @SerializedName("author")
    val author: String?,
    @SerializedName("class_starttime")
    val classStarttime: String?,
    @SerializedName("classid")
    val classid: String?,
    @SerializedName("image")
    val image: String?,
    @SerializedName("starts_in")
    val startsIn: String?,
    @SerializedName("title")
    val title: String?
){
    constructor() : this(null, null, null, null, null,null)
}