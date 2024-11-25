package com.example.themovieapp.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Parcelable.Creator
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.themovieapp.R
import com.example.themovieapp.databinding.ActivityMovieDetailsBinding
import com.example.themovieapp.viewpods.ActorListViewPod

class MovieDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMovieDetailsBinding

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, MovieDetailsActivity::class.java)
        }
    }

    // ViewPods
    lateinit var actorsViewPod: ActorListViewPod
    lateinit var creatorsViewPod: ActorListViewPod
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMovieDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpViewPods()
        setUpListeners()
    }

    private fun setUpListeners() {
        binding.btnBack.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
    }

    private fun setUpViewPods() {
        actorsViewPod = binding.vpActors.root
        actorsViewPod.setUpActorViewPod(
            backgroundColorReference = R.color.colorPrimary,
            titleText = getString(R.string.lbl_actors),
            moreTitleText = ""
        )

        creatorsViewPod = binding.vpCreators.root
        creatorsViewPod.setUpActorViewPod(
            backgroundColorReference = R.color.colorPrimary,
            titleText = getString(R.string.lbl_creators),
            moreTitleText = getString(R.string.lbl_more_creators)
        )
    }
}