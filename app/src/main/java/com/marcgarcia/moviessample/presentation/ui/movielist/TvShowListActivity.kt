package com.marcgarcia.moviessample.presentation.ui.movielist

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import com.marcgarcia.moviessample.R
import com.marcgarcia.moviessample.presentation.ui.common.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class TvShowListActivity : BaseActivity() {

    @Inject
    lateinit var viewModel: TvShowListViewModel

    private lateinit var adapter: TvShowListAdapter

    override fun bindLayout() = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        createAdapter()
        viewModel.viewState.observe(this, Observer {
            when (it) {
                TvShowViewState.Loading -> {
                    Log.d("MARC", "Loading")
                }
                is TvShowViewState.PopularMovies -> {
                    adapter.submitList(it.movies)
                }
                TvShowViewState.Error -> {
                    Log.d("MARC", "Error")
                }
            }
        })
        if (savedInstanceState == null) {
            viewModel.onViewReady()
        }
    }

    private fun createAdapter() {
        adapter = TvShowListAdapter()
        rvShowsList.adapter = adapter
        rvShowsList.addOnScrollListener(object : RecyclerViewEndlessOnScrollListener() {
            override fun onLoadMore() {
                // Not implemented yet!
            }
        })
    }
}
