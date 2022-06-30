package com.ak.ejaro.NetworkUtils.Services

import java.lang.annotation.Documented
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy
import javax.inject.Qualifier


@Qualifier
@Documented
@Retention(RetentionPolicy.RUNTIME)
annotation class Defaultbaseurl()

@Qualifier
@Documented
@Retention(RetentionPolicy.RUNTIME)
annotation class RetrofitClient()



@Qualifier
@Documented
@Retention(RetentionPolicy.RUNTIME)
annotation class DefaultService()


