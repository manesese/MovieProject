package com.example.weatherproject.data.dto

import kotlinx.serialization.Serializable

object MovieDto {

    @Serializable
    data class GetMovieResult(
        val boxOfficeResult: GetBoxOfficeResult
    )

    @Serializable
    data class GetBoxOfficeResult(
        val boxofficeType: String,
        val showRange: String,
        val dailyBoxOfficeList: List<GetBoxOfficeList>
    )

    @Serializable
    data class GetBoxOfficeList(
        val rnum: String,
        val rank: String,
        val rankInten: String,
        val rankOldAndNew: String,
        val movieCd: String,
        val movieNm: String,
        val openDt: String,
        val salesAmt: String,
        val salesShare: String,
        val salesInten: String,
        val salesChange: String,
        val salesAcc: String,
        val audiCnt: String,
        val audiInten: String,
        val audiChange: String,
        val audiAcc: String,
        val scrnCnt: String,
        val showCnt: String,
    )

}