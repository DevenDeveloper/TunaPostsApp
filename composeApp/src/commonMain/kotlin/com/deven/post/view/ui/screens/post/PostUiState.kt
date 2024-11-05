package com.deven.post.view.ui.screens.post

import com.deven.post.data.models.post.ModelPost

sealed class PostUiState {
    data object Loading : PostUiState()
    data class Success(val posts: List<ModelPost>) : PostUiState()
    data class Error(val message: String) : PostUiState()
}