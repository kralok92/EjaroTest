package com.ak.vendor.dataModel


import com.google.gson.annotations.SerializedName

data class Professional(
    @SerializedName("achivement_details")
    val achivementDetails: String?,
    @SerializedName("cid")
    val cid: String?,
    @SerializedName("designation")
    val designation: String?,
    @SerializedName("experience")
    val experience: String?,
    @SerializedName("followers")
    val followers: String?,
    @SerializedName("liveclass_count")
    val liveclassCount: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("photo")
    val photo: String?,
    @SerializedName("rating")
    val rating: String?,
    @SerializedName("review")
    val review: String?,
    @SerializedName("sessions")
    val sessions: String?,
    @SerializedName("video_count")
    val videoCount: String?
){
    constructor() : this(null, null, null, null,
        null,null,null,null,null,null,null,null)
}