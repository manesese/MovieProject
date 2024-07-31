package com.example.weatherproject.data.repositoryModule.repository

import com.example.weatherproject.data.dto.MovieDto
import retrofit2.Response

interface MovieRepository {

    suspend fun requestMovieChart(
        key:String,
        targetDt:String
    ):Response<MovieDto.GetMovieResult>
}