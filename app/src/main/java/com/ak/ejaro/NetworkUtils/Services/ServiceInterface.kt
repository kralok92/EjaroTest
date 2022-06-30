package com.ak.ejaro.NetworkUtils.Services


import com.ak.ejaro.ui.search.dataModel.LiveClassDataModel
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface ServiceInterface {

    @GET("LiveClass/LiveClassLandingPage")
    fun getLiveClasses() : Call<LiveClassDataModel>

    @GET("LiveClass/LiveClassLandingPage")
    suspend fun getClasses() : Response<LiveClassDataModel>
}