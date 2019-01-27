package com.marcgarcia.moviessample.presentation.ui.movielist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.marcgarcia.moviessample.R

class TvShowListAdapter : ListAdapter<TvShowViewEntity, TvShowViewHolder>(ModularDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.item_tv_show_list,
            parent,
            false
        )
        return TvShowViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: TvShowViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun onViewRecycled(holder: TvShowViewHolder) {
        holder.clear()
    }

    private class ModularDiffCallback : DiffUtil.ItemCallback<TvShowViewEntity>() {
        override fun areItemsTheSame(oldItem: TvShowViewEntity, newItem: TvShowViewEntity): Boolean =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: TvShowViewEntity, newItem: TvShowViewEntity): Boolean =
            oldItem == newItem
    }
}
