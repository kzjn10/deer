package com.anhndt.iv.ui.userlist

import com.anhndt.iv.domain.model.PostModel

sealed class PostUIState {
    object Loading : PostUIState()
    data class Success(val posts: Map<Long, List<PostModel>>) : PostUIState()
    data class Error(val message: String) : PostUIState()

}