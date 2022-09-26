package com.apolloagriculture.android.takehomeassignment

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.annotation.DrawableRes
import com.apolloagriculture.android.takehomeassignment.data.response.Weather
import com.apolloagriculture.android.takehomeassignment.databinding.WeatherItemBinding


class WeatherView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyle: Int = 0,
    defStyleRes: Int = 0
) :
    LinearLayout(context, attributeSet, defStyle, defStyleRes) {

    private var binding: WeatherItemBinding

    init {
        binding = WeatherItemBinding.inflate(LayoutInflater.from(context), this, true)
    }

    fun setData(weather: Weather) {
        binding.weatherIcon.setImageResource(WeatherIcon.getDrawableRes(weather.icon))
        binding.temperature.text = "${weather.lowTemp.toInt()} - ${weather.highTemp.toInt()} C"
        binding.weatherDesc.text = weather.description
    }
}

enum class WeatherIcon(@DrawableRes val res: Int) {
    CLEAR_DAY(R.drawable.ic_weather_clear_day),
    SCATTERED_CLOUDS_DAY(R.drawable.ic_weather_cloud_sun),
    BROKEN_OVERCAST_CLOUDS_DAY(R.drawable.ic_weather_some_clouds);

    companion object {
        @DrawableRes
        fun getDrawableRes(key: String): Int {
            return try {
                valueOf(key.uppercase()).res
            } catch (ex: Exception) {
                R.drawable.ic_weather_clear_day
            }
        }
    }
}