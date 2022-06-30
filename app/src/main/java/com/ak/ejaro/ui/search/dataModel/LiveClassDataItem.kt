package com.ak.ejaro.ui.search.dataModel

import com.google.gson.annotations.SerializedName

sealed class LiveClassDataItem {
    data class LiveData(
        @SerializedName("image")
        val image: String?,
        @SerializedName("programLists")
        val programLists: List<ProgramLists>?,
        @SerializedName("todayLiveClass")
        val todayLiveClass: List<TodayLiveClas>?,
        @SerializedName("topInstructor")
        val topInstructor: List<TopInstructor>?


    ) : LiveClassDataItem()

    data class ProgramLists(
        @SerializedName("programId")
        val programId: String?,
        @SerializedName("classid")
        val classId: String?,
        @SerializedName("consultantCount")
        val consultantCount: String?,
        @SerializedName("icon")
        val icon: String?,
        @SerializedName("liveClassCount")
        val liveClassCount: String?,
        @SerializedName("programName")
        val programName: String?,
        @SerializedName("usersCount")
        val usersCount: String?,
        @SerializedName("videoCount")
        val videoCount: String?

    ) : LiveClassDataItem()

    data class TodayLiveClas(
        @SerializedName("classid")
        val classid: String?,
        @SerializedName("program_id")
        val programId: String?,
        @SerializedName("scheduleId")
        val scheduleId: String?,
        @SerializedName("image")
        val image: String?,
        @SerializedName("starts_in")
        val startsIn: String?,
        @SerializedName("title")
        val title: String?,
        @SerializedName("author")
        val author: String?,
        @SerializedName("class_starttime")
        val classStarttime: String?,
        @SerializedName("class_time")
        val classTime: String?,
        @SerializedName("class_for")
        val class_for: String?,
        @SerializedName("isButton_Visible")
        val isButton_Visible: String?,
        @SerializedName("available_Seat")
        val available_Seat: String?,


    ) : LiveClassDataItem()

    data class TopInstructor(
        @SerializedName("cid")
        val cid: String?,
        @SerializedName("fullname")
        val fullname: String?,
        @SerializedName("photo")
        val photo: String?
    ) : LiveClassDataItem()
}
