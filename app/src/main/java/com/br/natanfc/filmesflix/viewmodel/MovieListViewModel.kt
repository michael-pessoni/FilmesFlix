package com.br.natanfc.filmesflix.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.br.natanfc.filmesflix.model.Movie

class MovieListViewModel: ViewModel() {

    private val listOfMovies = arrayListOf<Movie>(
        Movie(
            id = 0,
            "Titanic",
            null,
            null,
            null
        ),
        Movie(
            id = 1,
            "Central do Brasil",
            null,
            null,
            null
        )
    )

    private var _movieList = MutableLiveData<List<Movie>>()
    val movieList: LiveData<List<Movie>>
    get() = _movieList

    fun init() {
        getAllMovies()
    }

    private fun getAllMovies() {
        _movieList.postValue(listOfMovies)
    }

}