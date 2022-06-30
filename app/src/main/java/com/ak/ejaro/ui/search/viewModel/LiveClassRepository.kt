package com.ak.ejaro.ui.search.viewModel

import com.ak.ejaro.NetworkUtils.Services.DefaultService
import com.ak.ejaro.NetworkUtils.Services.ServiceInterface
import com.ak.ejaro.ui.search.dataModel.LiveClassDataModel
import retrofit2.Call
import retrofit2.Response
import javax.inject.Inject

class LiveClassRepository @Inject constructor(@DefaultService val serviceInterface: ServiceInterface) {

    fun getLiveclass(): Call<LiveClassDataModel> = serviceInterface.getLiveClasses()

    suspend fun getclass(): Response<LiveClassDataModel> = serviceInterface.getClasses()
}