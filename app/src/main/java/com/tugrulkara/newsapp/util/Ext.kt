package com.tugrulkara.newsapp.util

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.tugrulkara.newsapp.R

fun ImageView.downloadFromUrl(url: String?){

    val options = RequestOptions()
        .placeholder(R.drawable.ic_launcher_foreground)
        .error(R.mipmap.ic_launcher_round)

    Glide.with(context)
        .setDefaultRequestOptions(options)
        .load(url)
        .into(this)

}
