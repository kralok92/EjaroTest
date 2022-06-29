package com.ak.vendor.dataModel


import com.google.gson.annotations.SerializedName

data class Category(
    @SerializedName("category_name")
    val categoryName: String?,
    @SerializedName("categoryid")
    val categoryid: String?,
    @SerializedName("image")
    val image: String?
) {
    constructor() : this(null, null, null)
}
