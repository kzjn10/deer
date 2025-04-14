package com.anhndt.iv.domain.usecase.impl

import com.anhndt.iv.data.remote.PostRepository
import com.anhndt.iv.domain.model.PostModel
import com.anhndt.iv.domain.usecase.GetPostUseCase

class GetPostUseCaseImpl(private val postRepository: PostRepository) : GetPostUseCase {
    override suspend fun invoke(): Result<Map<Long, List<PostModel>>> {
        try {
            val posts = postRepository.getPosts()
            val groupPostByUser = posts.groupBy { it.userId }
            return Result.success(groupPostByUser)
        } catch (e: Exception) {
            return Result.failure(e)
        }
    }
}