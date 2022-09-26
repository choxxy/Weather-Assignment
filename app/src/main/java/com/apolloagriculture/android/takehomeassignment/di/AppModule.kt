package com.apolloagriculture.android.takehomeassignment.di

import com.apolloagriculture.android.takehomeassignment.BuildConfig
import com.apolloagriculture.android.takehomeassignment.data.WeatherApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val appModule = module {
    factory { provideOkhttpClient() }
    factory { provideWeatherApi(get()) }
}


fun provideOkhttpClient(): OkHttpClient {
    val httpInterceptor = HttpLoggingInterceptor()
    httpInterceptor.level = HttpLoggingInterceptor.Level.BODY
    val client = OkHttpClient.Builder()

    if (BuildConfig.DEBUG) {
        client.addInterceptor(httpInterceptor)
    }
    return client.build()
}



fun provideWeatherApi(client: OkHttpClient): WeatherApi =
    Retrofit.Builder()
        .baseUrl("https://s3.eu-west-1.amazonaws.com/assets.apolloagriculture.com/recruitment/android/")
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(WeatherApi::class.java)