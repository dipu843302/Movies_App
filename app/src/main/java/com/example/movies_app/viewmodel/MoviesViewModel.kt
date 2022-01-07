package com.example.movies_app.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movies_app.repository.MovieRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MoviesViewModel(private val movieRepository: MovieRepository): ViewModel() {

   init {
       viewModelScope.launch (Dispatchers.IO){
           movieRepository.getMovie()
       }
   }
  fun get()=movieRepository.getData()
}