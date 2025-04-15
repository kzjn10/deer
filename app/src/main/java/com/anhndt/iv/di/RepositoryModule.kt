package com.anhndt.iv.di

import com.anhndt.iv.data.api.ApiService
import com.anhndt.iv.data.remote.PostRepository
import com.anhndt.iv.data.remote.impl.PostRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    fun providePostRepository(apiService: ApiService): PostRepository {
        return PostRepositoryImpl(apiService)
    }

}