package com.ak.ejaro.NetworkUtils.Intercepter

import android.content.Context
import okhttp3.Interceptor
import okhttp3.Response

class NetworkConnectionInterceptor(private var mCtx : Context) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        if (!NetworkConnectionBuilder.isAvailable(mCtx)) throw NoConnectivityException()
        return chain.proceed(chain.request())
    }


}