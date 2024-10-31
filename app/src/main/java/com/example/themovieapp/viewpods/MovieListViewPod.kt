package com.example.themovieapp.viewpods

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.themovieapp.R
import com.example.themovieapp.adapters.MovieAdapter
import com.example.themovieapp.databinding.ViewPodMovieListBinding
import com.example.themovieapp.model.Movie

class MovieListViewPod @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : FrameLayout(context, attrs) {

    private lateinit var binding: ViewPodMovieListBinding
    private lateinit var mMovieAdapter: MovieAdapter

    override fun onFinishInflate() {
        super.onFinishInflate()
        binding = ViewPodMovieListBinding.bind(this) // Assuming `this` refers to the root of the layout
        setUpMovieRecyclerView() // Call this method here
    }


    private fun setUpMovieRecyclerView() {
        // Sample data
        val movies = listOf(
            Movie("Westworld", 8.20, R.drawable.placeholder_wolverine_image),
            Movie("Inception", 8.80, R.drawable.placeholder_wolverine_image),
            Movie("The Dark Knight", 9.00, R.drawable.placeholder_wolverine_image),
            Movie("Interstellar", 8.60, R.drawable.placeholder_wolverine_image),
            Movie("Joker", 8.50, R.drawable.placeholder_wolverine_image)
        )

        mMovieAdapter = MovieAdapter(movies)
        binding.rvMovieList.adapter = mMovieAdapter
        binding.rvMovieList.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
    }
}

