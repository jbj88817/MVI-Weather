package us.bojie.mvi_weather.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import us.bojie.mvi_weather.data.location.DefaultLocationTracker
import us.bojie.mvi_weather.data.repository.WeatherRepositoryImpl
import us.bojie.mvi_weather.domain.location.LocationTracker
import us.bojie.mvi_weather.domain.repository.WeatherRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindWeatherRepository(weatherRepositoryImpl: WeatherRepositoryImpl) : WeatherRepository
}