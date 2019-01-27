package com.marcgarcia.moviessample.presentation.ui.movielist

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_tv_show_list.*

class TvShowViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView), LayoutContainer {

    fun bind(item: TvShowViewEntity) {
        Glide.with(containerView.context).load(item.poster.toExternalForm()).into(ivShowImage)
    }

    fun clear() {
        Glide.with(containerView.context).clear(ivShowImage)
    }
}
