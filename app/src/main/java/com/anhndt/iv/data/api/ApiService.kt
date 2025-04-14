package com.anhndt.iv.data.api

import com.anhndt.iv.domain.model.PostModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("posts")
    suspend fun getPosts(): Response<List<PostModel>>


}