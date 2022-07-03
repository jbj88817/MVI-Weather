package us.bojie.mvi_weather.domain.repository

import us.bojie.mvi_weather.domain.util.Resource
import us.bojie.mvi_weather.domain.weather.WeatherInfo

interface WeatherRepository {

    suspend fun getWeatherData(lat: Double, long: Double) : Resource<WeatherInfo>
}