package com.tugrulkara.newsapp.presentation.home.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tugrulkara.newsapp.data.remote.dto.Article
import com.tugrulkara.newsapp.databinding.RowLayoutBinding
import com.tugrulkara.newsapp.util.downloadFromUrl

class HomeRecyclerAdapter(val newsList: List<Article>,private val listener : Listener): RecyclerView.Adapter<HomeRecyclerAdapter.RowHolder>() {

    interface Listener {
        fun onItemClick(article: Article)
    }


    class RowHolder(val itemBinding: RowLayoutBinding): RecyclerView.ViewHolder(itemBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowHolder {
        val itemBinding = RowLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RowHolder(itemBinding)
    }

    override fun getItemCount(): Int {
        return newsList.size
    }

    override fun onBindViewHolder(holder: RowHolder, position: Int) {

        holder.itemBinding.newsImage.downloadFromUrl(newsList[position].urlToImage)
        holder.itemBinding.newsTitle.text=newsList[position].title
        holder.itemBinding.newsDescription.text=newsList[position].description

        holder.itemView.setOnClickListener {
            listener.onItemClick(newsList[position])
        }
    }


}