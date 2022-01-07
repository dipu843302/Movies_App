package com.example.movies_app.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object  Network {
  private const val BASE_URL="https://gist.githubusercontent.com/"

    fun getInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }

}