package com.tugrulkara.newsapp.domain.repository

import com.tugrulkara.newsapp.data.remote.dto.NewsDto

interface RemoteRepository {

    suspend fun getTopNews():NewsDto

}