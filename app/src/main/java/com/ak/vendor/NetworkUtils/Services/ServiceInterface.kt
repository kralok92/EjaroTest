package com.ak.vendor.NetworkUtils.Services


import retrofit2.Call
import retrofit2.http.*

interface ServiceInterface {

    @GET("Register/SendSMS")
    fun sendOtpFromMobile(
        @Query("CountryCode") code: String,
        @Query("Mobile") mobile: String
    ): Call<String>



}