package com.ak.vendor.utils

import android.content.Context
import android.util.Log
import android.widget.Toast

object Helper {
    private var toast: Toast? = null
    fun showToast(context: Context?, msg: String?) {

    }

    fun log(msg: String) {
        Log.e("yogpathConsumer", msg)
    }


}