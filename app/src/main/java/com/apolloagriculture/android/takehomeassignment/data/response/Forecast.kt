package com.apolloagriculture.android.takehomeassignment.data.response


import com.google.gson.annotations.SerializedName

data class Forecast(
    @SerializedName("dayAfterTomorrow")
    val dayAfterTomorrow: DayAfterTomorrow,
    @SerializedName("today")
    val today: Today,
    @SerializedName("tomorrow")
    val tomorrow: Tomorrow
)