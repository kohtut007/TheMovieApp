package com.example.themovieapp.adapters
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.themovieapp.databinding.ViewHolderMovieBinding
import com.example.themovieapp.delegate.MovieViewHolderDelegate
import com.example.themovieapp.viewholders.MovieViewHolder

class MovieAdapter(private val mDelegate: MovieViewHolderDelegate) : RecyclerView.Adapter<MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = ViewHolderMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(view, mDelegate)
    }

    override fun getItemCount(): Int {
        return 10
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
    }
}
