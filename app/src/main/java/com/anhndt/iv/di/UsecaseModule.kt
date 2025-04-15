package com.anhndt.iv.di

import com.anhndt.iv.data.remote.PostRepository
import com.anhndt.iv.domain.usecase.GetPostUseCase
import com.anhndt.iv.domain.usecase.impl.GetPostUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    @Provides
    fun provideGetPostUseCase(postRepository: PostRepository): GetPostUseCase {
        return GetPostUseCaseImpl(postRepository)
    }

}