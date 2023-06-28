package com.tugrulkara.newsapp.data.remote

import com.tugrulkara.newsapp.data.remote.dto.NewsDto
import com.tugrulkara.newsapp.util.Constants.API_COUNTRY
import com.tugrulkara.newsapp.util.Constants.API_KEY
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {


    @GET("top-headlines")
    suspend fun getTopNews(
        @Query("country") country:String =API_COUNTRY,
        @Query("apiKey") apiKey:String=API_KEY
    ): NewsDto

}