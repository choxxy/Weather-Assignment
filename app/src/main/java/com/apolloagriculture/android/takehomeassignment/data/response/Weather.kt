package com.apolloagriculture.android.takehomeassignment.data.response

import com.google.gson.annotations.SerializedName

data class Weather(
    @SerializedName("description")
    val description: String,
    @SerializedName("highTemp")
    val highTemp: Double,
    @SerializedName("icon")
    val icon: String,
    @SerializedName("lowTemp")
    val lowTemp: Double
)