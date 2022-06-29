package com.ak.vendor.NetworkUtils.Services

import android.content.Context
import com.google.gson.GsonBuilder
import com.ak.vendor.NetworkUtils.Coroutine.ApiService
import com.ak.vendor.NetworkUtils.Intercepter.ExceptionIntercepter
import com.ak.vendor.NetworkUtils.Intercepter.HeaderInterceptor
import com.ak.vendor.NetworkUtils.Intercepter.NetworkConnectionInterceptor
import com.ak.vendor.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit



@Module
@InstallIn(SingletonComponent::class)
class ApiModule {

    @Provides
    @Defaultbaseurl
    fun provideBaseUrl() : String = Constants.LIVE_BASE_URL



    @Provides
    @MediaBaseUrl
    fun provideMediaBaseUrl() : String = Constants.MEDIA_BASE_URL


    @Provides
    fun provideContext(@ApplicationContext context: Context) : Context{
        return context
    }

    @Provides
    fun providesLoggingInterceptor() : HttpLoggingInterceptor{
        return HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.HEADERS)
            .setLevel(HttpLoggingInterceptor.Level.BODY)
    }


    @Provides
    fun provideOkHttpClient(logging: HttpLoggingInterceptor,context: Context) : OkHttpClient {
        //10 MB
        val cacheSize = 10 * 1024 * 1024
        val cache = Cache(context.cacheDir, cacheSize.toLong())
        return OkHttpClient().newBuilder()
            .connectTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .addInterceptor(logging)
            .addInterceptor(NetworkConnectionInterceptor(context))
            .addInterceptor(ExceptionIntercepter(context))
            .addInterceptor(HeaderInterceptor())
            .cache(cache)
            .build()
    }

    @Provides
    @RetrofitClient
    fun provideRetrofitClient(client: OkHttpClient,@Defaultbaseurl baseUrl: String) : Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(client)
            .addConverterFactory(
                GsonConverterFactory.create(
                    GsonBuilder()
                        .serializeNulls()
                        .setLenient().create()
                )
            )
            .build()

    }


    @Provides
    @MediaRetrofitClient
    fun provideMediaRetrofitClient(client: OkHttpClient,@MediaBaseUrl baseUrl: String) : Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(client)
            .addConverterFactory(
                GsonConverterFactory.create(
                    GsonBuilder()
                        .serializeNulls()
                        .setLenient().create()
                )
            )
            .build()

    }


    @Provides
    @DefaultService
    fun provideService(@RetrofitClient retrofit: Retrofit) : ServiceInterface{
        return retrofit.create(ServiceInterface::class.java)
    }


    @Provides
    @MediaService
    fun provideMediaService(@MediaRetrofitClient retrofit: Retrofit) : ServiceInterface{
        return retrofit.create(ServiceInterface::class.java)
    }


    @Provides
    @MediaApiService
    fun provideMediaApiService(@MediaRetrofitClient retrofit: Retrofit) : ApiService {
        return retrofit.create(ApiService::class.java)
    }



    @Provides
    @DefaultApiService
    fun provideApiService(@RetrofitClient retrofit: Retrofit) : ApiService{
        return retrofit.create(ApiService::class.java)
    }

}