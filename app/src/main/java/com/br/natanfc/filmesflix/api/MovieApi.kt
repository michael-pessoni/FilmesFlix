package com.br.natanfc.filmesflix.api

import com.br.natanfc.filmesflix.model.Movie
import retrofit2.http.GET

interface MovieApi {

    @GET("natanfelipe/FilmesFlixJson/master/moviesList")
    fun getAllMovies(): List<Movie>

    //https://raw.githubusercontent.com/natanfelipe/FilmesFlixJson/master/moviesList
}