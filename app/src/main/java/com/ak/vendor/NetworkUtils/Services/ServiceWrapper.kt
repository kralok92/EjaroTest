package com.ak.vendor.NetworkUtils.Services

import android.content.Context
import com.ak.vendor.utils.ProgressDialogUtil
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ServiceWrapper<T>(
                        val isCustomProgress: Boolean?,
                        val responseHandler: ResponseHandler<T>?,
                        val call : Call<T>?) {


    class Builder<T>(var isCustomProgress: Boolean?=null,
                     var responseHandler: ResponseHandler<T>? = null,
                     var call : Call<T>? = null)
    {

     fun setProgress(isCustomProgress: Boolean) = apply { this.isCustomProgress = isCustomProgress }
     fun setResponseHandler(responseHandler: ResponseHandler<T>) = apply { this.responseHandler = responseHandler }
     fun setService(call : Call<T>)  = apply { this.call = call }
     fun Build() = ServiceWrapper(isCustomProgress,responseHandler,call)

    }

    fun run(mCtx : Context){
        if (isCustomProgress != false){ ProgressDialogUtil.show(mCtx)}
        call!!.enqueue(object : Callback<T> {
            override fun onResponse(call: Call<T>, response: Response<T>) {
                ProgressDialogUtil.hideLoading()
                if (response.isSuccessful) {
                    if (responseHandler != null) {
                        if (response.body() != null) {
                            responseHandler.onResponse(response.body()!!)
                        }
                    }
                }
            }

            override fun onFailure(call: Call<T>, throwable: Throwable) {
                ProgressDialogUtil.hideLoading()
                responseHandler?.onFailure(mCtx,throwable)
            }
        })



    }



}