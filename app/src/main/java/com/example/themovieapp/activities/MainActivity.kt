package com.example.themovieapp.activities

import android.os.Bundle
import android.view.Menu
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.themovieapp.R
import com.example.themovieapp.adapters.BannerAdapter
import com.example.themovieapp.adapters.ShowcaseAdapter
import com.example.themovieapp.databinding.ActivityMainBinding
import com.example.themovieapp.delegate.BannerViewHolderDelegate
import com.example.themovieapp.delegate.MovieViewHolderDelegate
import com.example.themovieapp.delegate.ShowcaseViewHolderDelegate
import com.example.themovieapp.dummy.dummyGenreList
import com.example.themovieapp.viewpods.MovieListViewPod
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity(), BannerViewHolderDelegate, ShowcaseViewHolderDelegate, MovieViewHolderDelegate {

    private lateinit var binding: ActivityMainBinding
    private lateinit var mBannerAdapter: BannerAdapter
    private lateinit var mShowcaseAdapter: ShowcaseAdapter
    private lateinit var mBestPopularMovieListViewPod: MovieListViewPod
    private lateinit var mMoviesByGenreViewPod: MovieListViewPod

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpToolbar()
        setUpViewPods()
        setUpBannerViewPager()
        setUpGenreTabLayout()
        setUpListener()
        setUpShowcaseRecyclerView()
    }

    private fun setUpViewPods() {
        // Access the root view of ViewPodMovieListBinding and cast to MovieListViewPod if it's the custom view you need
        mBestPopularMovieListViewPod = binding.vpBestPopularMovieList.root as MovieListViewPod
        mBestPopularMovieListViewPod.setUpMovieListViewPod(this)

        mMoviesByGenreViewPod = binding.vpMoviesByGenre.root as MovieListViewPod
        mMoviesByGenreViewPod.setUpMovieListViewPod(this)
    }

    private fun setUpShowcaseRecyclerView() {
        mShowcaseAdapter = ShowcaseAdapter(this)
        binding.rvShowcases.adapter = mShowcaseAdapter
        binding.rvShowcases.layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.HORIZONTAL, false)
    }

    private fun setUpListener() {
        binding.tabLayoutGenre.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                Snackbar.make(window.decorView, tab?.text ?: "", Snackbar.LENGTH_LONG).show()
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }
        })
    }

    private fun setUpGenreTabLayout() {
        dummyGenreList.forEach {
            binding.tabLayoutGenre.newTab().apply {
                text = it
                binding.tabLayoutGenre.addTab(this)
            }

        }
    }

    private fun setUpBannerViewPager() {
        mBannerAdapter = BannerAdapter(this)
        binding.viewPagerBanner.adapter = mBannerAdapter

        binding.dotsIndicatorBanner.attachTo(binding.viewPagerBanner)
    }

    private fun setUpToolbar() {
        setSupportActionBar(binding.toolBar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_baseline_menu_white_24dp)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_discover, menu)
        return true
    }

    override fun onTapMovieFromBanner() {
        startActivity(MovieDetailsActivity.newIntent(this))
    }

    override fun onTapMovieFromShowcase() {
        startActivity(MovieDetailsActivity.newIntent(this))

    }

    override fun onTapMovie() {
        startActivity(MovieDetailsActivity.newIntent(this))

    }
}