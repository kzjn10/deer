package com.anhndt.iv.data.remote

import com.anhndt.iv.domain.model.PostModel

interface PostRepository {
   suspend fun getPosts(): List<PostModel>
}