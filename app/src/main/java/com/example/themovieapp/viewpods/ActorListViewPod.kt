package com.example.themovieapp.viewpods

import android.content.Context
import android.util.AttributeSet
import android.widget.RelativeLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.themovieapp.adapters.ActorAdapter
import com.example.themovieapp.databinding.ViewPodActorListBinding
import com.example.themovieapp.databinding.ViewPodMovieListBinding

class ActorListViewPod @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : RelativeLayout(context, attrs) {

    private lateinit var binding: ViewPodActorListBinding
    private lateinit var mActorAdapter: ActorAdapter

    override fun onFinishInflate() {
        super.onFinishInflate()
        binding = ViewPodActorListBinding.bind(this) // Assuming `this` refers to the root of the layout
        setUpActorRecyclerView()
    }

    private fun setUpActorRecyclerView() {
        mActorAdapter = ActorAdapter()
        binding.rvBestActors.adapter = mActorAdapter
        binding.rvBestActors.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

    }
}