package com.example.themovieapp.viewholders

import androidx.recyclerview.widget.RecyclerView
import com.example.themovieapp.databinding.ViewHolderMovieBinding
import com.example.themovieapp.delegate.MovieViewHolderDelegate

class MovieViewHolder(
    private val binding: ViewHolderMovieBinding,
    mDelegate: MovieViewHolderDelegate
) : RecyclerView.ViewHolder(binding.root) {

    init {
        itemView.setOnClickListener {
            mDelegate.onTapMovie()
        }
    }
}
