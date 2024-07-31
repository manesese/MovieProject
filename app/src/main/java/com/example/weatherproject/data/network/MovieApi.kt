package com.example.weatherproject.data.network

import com.example.weatherproject.data.dto.MovieDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {

    @GET("kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json")
    suspend fun requestMovieChart(
        @Query("key") key:String,
        @Query("targetDt") targetDt:String
    ):Response<MovieDto.GetMovieResult>
}