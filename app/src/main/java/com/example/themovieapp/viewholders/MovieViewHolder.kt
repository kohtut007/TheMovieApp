package com.example.themovieapp.viewholders

import androidx.recyclerview.widget.RecyclerView
import com.example.themovieapp.databinding.ViewHolderMovieBinding
import com.example.themovieapp.model.Movie

class MovieViewHolder(private val binding: ViewHolderMovieBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(movie: Movie) {
        // Binding the data to the views
        binding.tvMovieName.text = movie.name
        binding.tvMovieRating.text = movie.rating.toString()
        binding.ivMovieImage.setImageResource(movie.imageUrl) // For image resource
        binding.rbMovieRating.rating = movie.rating.toFloat() / 2  // Assuming rating out of 10
    }
}
