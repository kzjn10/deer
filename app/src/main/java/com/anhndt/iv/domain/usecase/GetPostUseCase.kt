package com.anhndt.iv.domain.usecase

import com.anhndt.iv.domain.model.PostModel

interface GetPostUseCase {
    suspend operator fun invoke(): Result<Map<Long, List<PostModel>>>
}


