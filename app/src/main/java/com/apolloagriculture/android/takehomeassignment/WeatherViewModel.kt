package com.apolloagriculture.android.takehomeassignment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.apolloagriculture.android.takehomeassignment.data.WeatherRepository
import com.apolloagriculture.android.takehomeassignment.data.response.Forecast
import kotlinx.coroutines.Dispatchers
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { WeatherViewModel(get()) }
}

class WeatherViewModel(private val weatherRepository: WeatherRepository) : ViewModel() {

    fun getWeatherForecast(): LiveData<Forecast> =
        weatherRepository.getForecast()
            .asLiveData(context = viewModelScope.coroutineContext + Dispatchers.IO)

}