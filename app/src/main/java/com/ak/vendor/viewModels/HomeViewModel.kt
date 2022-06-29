package com.ak.vendor.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ak.vendor.dataModel.HomeDataModel
import com.ak.vendor.NetworkUtils.Coroutine.Resource
import com.ak.vendor.repository.HomeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: HomeRepository) : ViewModel(){

    private val _homeListItemsLiveData = MutableLiveData<Resource<HomeDataModel>>()
    val homeListItemsLiveData: LiveData<Resource<HomeDataModel>>
        get() = _homeListItemsLiveData


    init {
        fetchHome()
    }

    fun fetchHome() = viewModelScope.launch {
        homeDataCall()
    }

    private suspend fun homeDataCall(){
        _homeListItemsLiveData.postValue(Resource.Loading())
        try{
            val data =  repository.getdashboardData()
            _homeListItemsLiveData.postValue(handleResponse(data))
        }
        catch (ex : Exception){
            when(ex){
                is IOException -> _homeListItemsLiveData.postValue(Resource.Error(ex.message.toString()))
                else -> _homeListItemsLiveData.postValue(Resource.Error("Something Went Wrong"))
            }
        }
    }

    private fun handleResponse(response: Response<HomeDataModel>): Resource<HomeDataModel> {
        if (response.isSuccessful) {
            response.body()?.let {
                return Resource.Success(it)
            }
        }
        return Resource.Error(response.message())
    }







}