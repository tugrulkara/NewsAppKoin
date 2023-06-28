package com.tugrulkara.newsapp.data.repository

import com.tugrulkara.newsapp.data.remote.NewsApi
import com.tugrulkara.newsapp.data.remote.dto.NewsDto
import com.tugrulkara.newsapp.domain.repository.RemoteRepository

class RemoteRepositoryImpl(private val api:NewsApi): RemoteRepository {
    override suspend fun getTopNews(): NewsDto {
        return api.getTopNews()
    }
}