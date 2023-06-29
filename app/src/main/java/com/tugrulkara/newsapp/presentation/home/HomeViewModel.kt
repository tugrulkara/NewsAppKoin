package com.tugrulkara.newsapp.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tugrulkara.newsapp.data.remote.dto.Article
import com.tugrulkara.newsapp.domain.use_case.GetTopNewsUseCase
import com.tugrulkara.newsapp.util.Resource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HomeViewModel(private val useCase: GetTopNewsUseCase):ViewModel() {

    private val _state= MutableStateFlow<Resource<List<Article>>?>(null)
    val state:StateFlow<Resource<List<Article>>?> = _state

    init {
        getTopNewsData()
    }

    private fun getTopNewsData() = viewModelScope.launch{
        useCase.invoke().collect{
            _state.value=it
        }
    }

}