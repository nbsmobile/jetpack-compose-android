package com.nbs.moviecompose.presentation.detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.google.android.material.appbar.AppBarLayout
import com.nbs.moviecompose.BuildConfig
import com.nbs.moviecompose.databinding.ActivityDetailBinding
import com.nbs.moviecompose.domain.response.Movie
import com.nbs.moviecompose.presentation.MainActivity
import com.nbs.moviecompose.utils.emptyString

class DetailActivity : AppCompatActivity() {

    companion object {
        fun start(context: Context, movie: Movie) {
            Intent(context, DetailActivity::class.java).apply {
                putExtra("movie", movie)
                context.startActivity(this)
            }
        }
    }

    private var movie: Movie? = null

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            btnDetailAddToFavorite.setOnClickListener {
                Toast.makeText(this@DetailActivity, "Favorite Movie", Toast.LENGTH_SHORT).show()
            }
            btnDetailWatchTrailer.setOnClickListener {
                Toast.makeText(this@DetailActivity, "Watch Trailer", Toast.LENGTH_SHORT).show()
            }
        }

        initUI()

        movie = intent.getParcelableExtra("movie")
        movie?.let { setData(it) }

    }

    private fun initUI() {
        with(binding) {
            setSupportActionBar(toolbarDetail)
            supportActionBar?.title = emptyString()
            supportActionBar?.setDisplayShowHomeEnabled(true)

            //Collapsing toolbar title
            var isCollapsed = false
            var scrollRange = -1
            appBarDetail.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { appBarLayout, verticalOffset ->
                if (scrollRange == -1) {
                    scrollRange = appBarLayout?.totalScrollRange!!
                }
                if (scrollRange + verticalOffset == 0) {
                    detailCollapseContainer.title = movie?.title.orEmpty()
                    isCollapsed = true
                } else if (isCollapsed) {
                    detailCollapseContainer.title = emptyString()
                    isCollapsed = false
                }
            })
        }
    }

    private fun setData(movie: Movie) {
        binding.apply {
            Glide.with(this@DetailActivity)
                .load(BuildConfig.IMAGE_BASE_URL + movie.backdropPath)
                .into(imgDetailPoster)

            tvDetailTitle.text = movie.title
            tvLanguage.text = movie.releaseDate
            tvDetailSynopsis.text = movie.overview
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        MainActivity.start(this)
        finish()
    }
}