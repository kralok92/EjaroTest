package com.ak.ejaro.NetworkUtils.Services

import android.content.Context
import com.ak.ejaro.NetworkUtils.Intercepter.NoConnectivityException
import com.ak.ejaro.utils.SnackBuilder

abstract class ResponseHandler<T> {
    abstract fun onStart()
    abstract fun onResponse(response: T)

    fun onError(mCtx : Context?,errorResponse: String?) {
        SnackBuilder.Builder()
            .setMessage(errorResponse!!)
            .setBackgroundTpye(3)
            .build()
            .show(mCtx!!)
    }

    fun onFailure(mCtx : Context,throwable: Throwable) {
        if (throwable is NoConnectivityException) {
            onInternetUnavailable(mCtx,throwable.message)
            return
        }
        SnackBuilder.Builder()
            .setMessage(throwable.message!!)
            .setBackgroundTpye(3)
            .build()
            .show(mCtx)
    }

    fun onInternetUnavailable(mCtx : Context,message: String?) {
        SnackBuilder.Builder()
            .setMessage(message!!)
            .setBackgroundTpye(1)
            .build()
            .show(mCtx)
    }

}