package com.tugrulkara.newsapp.domain.model

data class ArticleModel(
    val title: String,
    val description: String,
    val url: String,
    val urlToImage: String,
    val publishedAt: String,
    val content: String
)