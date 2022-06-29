package com.ak.vendor.NetworkUtils.Coroutine

import com.ak.vendor.dataModel.HomeDataModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("General/Home")
    suspend fun getHomeData(): Response<HomeDataModel>

}