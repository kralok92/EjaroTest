package com.ak.vendor.NetworkUtils.Intercepter

import android.content.Context
import android.net.ConnectivityManager

object NetworkConnectionBuilder {
    fun isAvailable(mCtx: Context): Boolean {
        val connectivityManager = mCtx.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetworkInfo = connectivityManager.activeNetworkInfo
        return activeNetworkInfo != null && activeNetworkInfo.isConnected
    }
}