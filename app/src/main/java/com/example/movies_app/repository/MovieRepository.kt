package com.example.movies_app.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.movies_app.api.MovieApi
import com.example.movies_app.model.MoviesList

class MovieRepository(private val movieApi: MovieApi) {

    private val movieLiveData: MutableLiveData<MoviesList> = MutableLiveData()

    fun getData(): LiveData<MoviesList> {
        return movieLiveData
    }


    suspend fun getMovie() {
        val result = movieApi.getMovies()
        if (result.body() != null) {
            movieLiveData.postValue(result.body())
        }

    }
}