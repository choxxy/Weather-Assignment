package com.apolloagriculture.android.takehomeassignment.data

import com.apolloagriculture.android.takehomeassignment.data.response.Forecast
import retrofit2.http.GET

interface WeatherApi {
    @GET("weather.json")
    suspend fun getWeather(): Forecast
}