package com.deven.post.view.ui.screens.post

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.deven.post.data.models.post.ModelPost
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun PostScreen() {
    val viewModel: PostViewModel = koinViewModel()
    val uiState by viewModel.uiStatePost.collectAsStateWithLifecycle()
    when (uiState) {
        is PostUiState.Loading -> {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentSize(Alignment.Center)
            ) {
                CircularProgressIndicator(color = MaterialTheme.colors.primary)
            }
        }

        is PostUiState.Success -> {
            val posts = (uiState as PostUiState.Success).posts
            LazyColumn {
                items(posts) { post ->
                    PostItem(post = post)
                }
            }
        }

        is PostUiState.Error -> {
            val errorMessage = (uiState as PostUiState.Error).message
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentSize(Alignment.Center)
            ) {
                Text(
                    text = errorMessage,
                    color = MaterialTheme.colors.error,
                    style = MaterialTheme.typography.body1,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Composable
fun PostItem(post: ModelPost) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {

        Text(text = "Title: ${post.title ?: "N/A"}", style = MaterialTheme.typography.h6)

        Text(text = "Body: ${post.body ?: "N/A"}", style = MaterialTheme.typography.body2)
    }
}