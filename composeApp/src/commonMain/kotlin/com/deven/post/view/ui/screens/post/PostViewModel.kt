package com.deven.post.view.ui.screens.post

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.deven.post.impl.PostsRepository
import com.deven.post.impl.PostsRepositoryImpl
import com.deven.post.impl.client
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class PostViewModel(
) : KoinComponent, ViewModel() {
    private val postRepository: PostsRepository by inject()
    private val _uiState = MutableStateFlow<PostUiState>(PostUiState.Loading)
    val uiStatePost: StateFlow<PostUiState> = _uiState.asStateFlow()
    init {
        viewModelScope.launch {
            _uiState.value = PostUiState.Loading
            try {
                val response = withContext(Dispatchers.IO) { postRepository.fetchPost() }
                _uiState.value = PostUiState.Success(response)
            } catch (e: Exception) {
                _uiState.value = PostUiState.Error("Failed to load posts :: " +e.message)
            }
        }
    }
}