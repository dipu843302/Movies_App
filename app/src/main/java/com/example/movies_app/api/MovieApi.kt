package com.example.movies_app.api

import com.example.movies_app.model.MoviesList
import retrofit2.Response
import retrofit2.http.GET

interface MovieApi {

    @GET("")
    suspend fun getMovies() : Response<MoviesList>
}