package com.example.weatherproject.view.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherproject.data.repositoryModule.WeatherRepositoryImpl.MovieRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(private val movieRepositoryImpl: MovieRepositoryImpl) :
    ViewModel() {
    fun requestMovieChart(
        key: String,
        targetDt: String
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            movieRepositoryImpl.requestMovieChart(key, targetDt).let {
                if (it.isSuccessful) {
                    Timber.e("성공")
                } else {
                    Timber.e("실패")
                }
            }
        }
    }
}