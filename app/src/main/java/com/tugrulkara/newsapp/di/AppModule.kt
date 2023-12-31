package com.tugrulkara.newsapp.di

import com.tugrulkara.newsapp.data.remote.NewsApi
import com.tugrulkara.newsapp.data.repository.RemoteRepositoryImpl
import com.tugrulkara.newsapp.domain.repository.RemoteRepository
import com.tugrulkara.newsapp.domain.use_case.GetTopNewsUseCase
import com.tugrulkara.newsapp.presentation.home.HomeViewModel
import com.tugrulkara.newsapp.util.Constants.BASE_URL
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val appModule= module {

    single {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsApi::class.java)
    }

    single<RemoteRepository> {
        RemoteRepositoryImpl(get())
    }

    single {
        GetTopNewsUseCase(get())
    }

    viewModel {
        HomeViewModel(get())
    }


}