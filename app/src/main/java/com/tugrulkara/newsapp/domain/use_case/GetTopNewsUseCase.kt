package com.tugrulkara.newsapp.domain.use_case

import com.tugrulkara.newsapp.domain.repository.RemoteRepository
import com.tugrulkara.newsapp.util.Resource
import kotlinx.coroutines.flow.flow

class GetTopNewsUseCase(private val remoteRepository: RemoteRepository) {

    suspend operator fun invoke() = flow {

        try {
            emit(Resource.Loading())
            val newsDto=remoteRepository.getTopNews()
            if (newsDto.status.equals("ok")){
                emit(Resource.Success(newsDto.articles))
            }else{
                emit(Resource.Error("Status Failed"))
            }
        }catch (e:Exception){
            emit(Resource.Error(e.localizedMessage))
        }
    }
}