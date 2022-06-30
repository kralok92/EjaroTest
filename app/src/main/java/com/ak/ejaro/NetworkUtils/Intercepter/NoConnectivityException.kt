package com.ak.ejaro.NetworkUtils.Intercepter

import java.io.IOException

class NoConnectivityException : IOException() {

    override val message: String
        get() = "Make sure you have an active data connection"
}