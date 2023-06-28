package com.tugrulkara.newsapp.data.remote.dto

data class NewsDto (
    val status: String,
    val totalResults: Long,
    val articles: List<Article>
)
