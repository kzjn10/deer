package com.anhndt.iv.ui.userlist

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.anhndt.iv.domain.usecase.GetPostUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class PostViewModel(private val getPostsUseCase: GetPostUseCase) : ViewModel(),
    DefaultLifecycleObserver {

    private val _uiState = MutableStateFlow<PostUIState>(PostUIState.Loading)
    val uiState = _uiState.asStateFlow()
    private var fetchPostJob: Job? = null

    fun fetchPosts() {
        fetchPostJob?.cancel()
        fetchPostJob = viewModelScope.launch (Dispatchers.IO){
            _uiState.value = PostUIState.Loading
            getPostsUseCase.invoke().fold(
                onSuccess = { posts ->
                    _uiState.value = PostUIState.Success(posts)
                },
                onFailure = { error ->
                    _uiState.value = PostUIState.Error(error.message ?: "Unknown error")
                }
            )
        }
    }

    override fun onCleared() {
        fetchPostJob?.cancel()
        super.onCleared()
    }
}