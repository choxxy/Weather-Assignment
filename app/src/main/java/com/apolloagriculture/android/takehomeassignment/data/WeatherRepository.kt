package com.apolloagriculture.android.takehomeassignment.data

import kotlinx.coroutines.flow.flow
import org.koin.dsl.module


val repositoryModule = module {
    factory { WeatherRepository(get()) }
}


class WeatherRepository(private val weatherApi: WeatherApi) {
    fun getForecast() = flow {
        emit(weatherApi.getWeather())
    }
}