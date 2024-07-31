package com.example.weatherproject.data.repositoryModule.WeatherRepositoryImpl

import com.example.weatherproject.data.dto.MovieDto
import com.example.weatherproject.data.network.MovieApi
import com.example.weatherproject.data.repositoryModule.repository.MovieRepository
import retrofit2.Response
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(private val apiService:MovieApi) : MovieRepository {
    override suspend fun requestMovieChart(
        key: String,
        targetDt: String
    ): Response<MovieDto.GetMovieResult> {
        return apiService.requestMovieChart(key,targetDt)
    }
}