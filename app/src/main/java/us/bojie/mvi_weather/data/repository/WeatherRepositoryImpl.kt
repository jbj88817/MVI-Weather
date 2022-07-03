package us.bojie.mvi_weather.data.repository

import us.bojie.mvi_weather.data.mappers.toWeatherInfo
import us.bojie.mvi_weather.data.remote.WeatherAPI
import us.bojie.mvi_weather.domain.repository.WeatherRepository
import us.bojie.mvi_weather.domain.util.Resource
import us.bojie.mvi_weather.domain.weather.WeatherInfo
import java.lang.Exception
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val api: WeatherAPI
) : WeatherRepository {

    override suspend fun getWeatherData(lat: Double, long: Double): Resource<WeatherInfo> {
        return try {
            Resource.Success(
                data = api.getWeatherData(
                    lat = lat,
                    long = long
                ).toWeatherInfo()
            )
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error(e.message ?: "An unknown error occurred.")
        }
    }
}