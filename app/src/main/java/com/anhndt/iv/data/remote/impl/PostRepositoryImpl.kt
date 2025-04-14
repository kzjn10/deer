package com.anhndt.iv.data.remote.impl

import com.anhndt.iv.data.api.ApiService
import com.anhndt.iv.data.remote.PostRepository
import com.anhndt.iv.domain.model.PostModel

class PostRepositoryImpl(
    private val apiService: ApiService
) : PostRepository {
    override suspend fun getPosts(): List<PostModel> {
        return apiService.getPosts().body() ?: emptyList()
    }
}