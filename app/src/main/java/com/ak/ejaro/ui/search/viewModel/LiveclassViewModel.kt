package com.ak.ejaro.ui.search.viewModel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ak.ejaro.NetworkUtils.Coroutine.Resource
import com.ak.ejaro.NetworkUtils.Intercepter.NoConnectivityException
import com.ak.ejaro.NetworkUtils.Services.ResponseHandler
import com.ak.ejaro.NetworkUtils.Services.ServiceWrapper
import com.ak.ejaro.ui.search.dataModel.LiveClassDataItem
import com.ak.ejaro.ui.search.dataModel.LiveClassDataModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class LiveclassViewModel @Inject constructor(private val repository: LiveClassRepository) : ViewModel(){

    private val _liveData = MutableLiveData<LiveClassDataItem.LiveData>()
    val liveData : LiveData<LiveClassDataItem.LiveData>
    get() = _liveData


    fun fetchLivedata(mCtx: Context){
        getApiCall(mCtx)
    }
    private fun getApiCall(mCtx : Context) {

        ServiceWrapper.Builder<LiveClassDataModel>()
            .setProgress(true)
            .setService(repository.getLiveclass())
            .setResponseHandler(object : ResponseHandler<LiveClassDataModel>(){
                override fun onStart() {

                }
                override fun onResponse(response: LiveClassDataModel) {
                    if (response.status){
                        response.liveData?.let {
                            with(_liveData) { postValue(response.liveData) }
                        }
                    }
                }
            }).Build().run(mCtx)


    }

    /***
     * using coroutine
     */

    private val _classLiveData = MutableLiveData<Resource<LiveClassDataItem.LiveData>>()
    val classLiveData : LiveData<Resource<LiveClassDataItem.LiveData>>
        get() = _classLiveData


    fun fetchClassData() = viewModelScope.launch{
        _classLiveData.postValue(Resource.Loading())
        try {
            val response = repository.getclass()
            if (response.isSuccessful && response.body()?.status!!) {
                val data = response.body()
                data?.let {
                    _classLiveData.postValue(Resource.Success(it.liveData))
                }
            }else{
                _classLiveData.postValue(response.body()?.message?.let { Resource.Error(it) })
            }
        }catch (ex:Exception){
            when(ex){
                is NoConnectivityException -> _classLiveData.postValue(Resource.Error(ex.message))
            }
        }

    }

}