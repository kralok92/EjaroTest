package com.ak.vendor.NetworkUtils.Intercepter

import android.content.Context
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.widget.TextView
import android.widget.Toast
import com.ak.vendor.R
import com.ak.vendor.utils.SnackBuilder
import okhttp3.Interceptor
import okhttp3.Response

class ExceptionIntercepter(val mCtx : Context) : Interceptor {


    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val response = chain.proceed(request)
        when (response.code) {
            400 -> onError("The request hostname is invalid")
            401 -> onError("The request requires user authentication")
            403 -> onError("The server understood the request, but is refusing to fulfill it")
            404 -> onError("The server has not found anything matching the Request-URI")
            409 -> onError("The request could not be completed due to a conflict with the current state of the resource")
            500 -> onError("The server encountered an unexpected condition which prevented it from fulfilling the request")
            else -> {
            }
        }
        return response
    }

    private fun onError(error: String) {
        try {
            SnackBuilder.Builder()
            .setMessage(error)
            .setBackgroundTpye(3)
            .build()
            .show(mCtx)
        }catch (ex:Exception){
            Handler(Looper.getMainLooper()).post(Runnable {
                Toast(mCtx).also {
                    LayoutInflater.from(mCtx).inflate(R.layout.custom_toast, null).apply {
                        it.view = this
                    }.findViewById<TextView>(R.id.tvMessage).text = error
                    it.duration = Toast.LENGTH_LONG
                }.show()

            })
        }


    }


}