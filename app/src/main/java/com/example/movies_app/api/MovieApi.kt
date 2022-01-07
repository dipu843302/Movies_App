package com.example.movies_app.api

import com.example.movies_app.model.MoviesList
import retrofit2.Response
import retrofit2.http.GET

interface MovieApi {

    @GET("Dcosta2205/cd3bf4cfdf6911fb26ae95672adb468e/raw/62d68fac146598cdba379317011ac9aa1aca8621/movies_db")
    suspend fun getMovies() : Response<MoviesList>
}