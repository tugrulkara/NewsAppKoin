package com.tugrulkara.newsapp.data.remote.dto

import com.tugrulkara.newsapp.domain.model.ArticleModel

data class NewsDto (
    val status: String,
    val totalResults: Long,
    val articles: List<Article>
)

fun NewsDto.toArticleList(): List<ArticleModel>{
    return articles.map {article ->
        ArticleModel(
            title = article.title,
            description = article.description,
            url = article.url,
            urlToImage = article.urlToImage,
            publishedAt = article.publishedAt,
            content = article.content)
    }
}
