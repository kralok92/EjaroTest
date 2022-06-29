package com.ak.vendor.repository

import com.ak.vendor.dataModel.HomeDataModel
import com.ak.vendor.NetworkUtils.Coroutine.ApiService
import com.ak.vendor.NetworkUtils.Services.DefaultApiService
import retrofit2.Response
import javax.inject.Inject

class HomeRepository@Inject constructor(@DefaultApiService val apiService : ApiService) {

    suspend fun getdashboardData() : Response<HomeDataModel> {
        return apiService.getHomeData()
    }


}