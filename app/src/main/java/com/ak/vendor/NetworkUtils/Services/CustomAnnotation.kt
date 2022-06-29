package com.ak.vendor.NetworkUtils.Services

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
annotation class MediaBaseUrl()


@Qualifier
@Documented
@Retention(RetentionPolicy.RUNTIME)
annotation class RetrofitClient()

@Qualifier
@Documented
@Retention(RetentionPolicy.RUNTIME)
annotation class MediaRetrofitClient()



@Qualifier
@Documented
@Retention(RetentionPolicy.RUNTIME)
annotation class DefaultService()



@Qualifier
@Documented
@Retention(RetentionPolicy.RUNTIME)
annotation class MediaService()

@Qualifier
@Documented
@Retention(RetentionPolicy.RUNTIME)
annotation class DefaultApiService()


@Qualifier
@Documented
@Retention(RetentionPolicy.RUNTIME)
annotation class MediaApiService()