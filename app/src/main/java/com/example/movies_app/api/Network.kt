package com.example.movies_app.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object  Network {
  private const val BASE_URL="https://gist.githubusercontent.com/Dcosta2205/cd3bf4cfdf6911fb26ae95672adb468e/raw/62d68fac146598cdba379317011ac9aa1aca8621/movies_db"

    fun getInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }

}