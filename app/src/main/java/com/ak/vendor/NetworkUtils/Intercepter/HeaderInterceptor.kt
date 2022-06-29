package com.ak.vendor.NetworkUtils.Intercepter

import android.content.Context
import com.ak.vendor.utils.Constants
import okhttp3.Interceptor

class HeaderInterceptor() : Interceptor {

    override fun intercept(chain: Interceptor.Chain): okhttp3.Response {

        var request: okhttp3.Request = chain.request()
        request = request.newBuilder()
            .addHeader("Accept", "application/json")
            .addHeader(
                "Content-Type", "application/json")
            .addHeader("Token", Constants.ApiToken)
            .addHeader("DeviceId", Constants.deviceId)
            .addHeader("DeviceType", Constants.deviceType)
            .build()
        return chain.proceed(request)
    }
}