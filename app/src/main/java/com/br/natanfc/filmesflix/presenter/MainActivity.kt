package com.br.natanfc.filmesflix.presenter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.br.natanfc.filmesflix.R
import com.br.natanfc.filmesflix.domain.Movie
import com.br.natanfc.filmesflix.framework.viewmodel.MovieListViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var movieListViewModel: MovieListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        movieListViewModel = ViewModelProvider.NewInstanceFactory().create(MovieListViewModel::class.java)
        movieListViewModel.init()
        initObserver()
        loadVisibility(true)
    }

    private fun initObserver() {
        movieListViewModel.movieList.observe(this, Observer { list ->
            if (list.isNotEmpty()) {
                loadVisibility(false)
                populateList(list)
            }
        })
    }

    private fun populateList(list: List<Movie>) {
        moviesList.apply {
            hasFixedSize()
            adapter = MoviesAdapter(list)
        }
    }

    private fun loadVisibility(isLoading: Boolean) {
        progressbar.visibility = if (isLoading) View.VISIBLE else View.GONE
    }

}