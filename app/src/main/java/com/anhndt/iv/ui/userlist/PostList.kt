package com.anhndt.iv.ui.userlist

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.anhndt.iv.domain.model.PostModel

@Composable
fun PostList(
    modifier: Modifier = Modifier,
    viewModel: PostViewModel,
    onItemClick: (PostModel) -> Unit
) {
    val uiState = viewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.fetchPosts()
    }

    Box(modifier = modifier.fillMaxSize()) {
        when (val state = uiState.value) {
            is PostUIState.Loading -> LoadingUI()

            is PostUIState.Success -> PostListUi(data = state.posts, onItemClick = onItemClick)

            is PostUIState.Error -> ErrorUI(message = state.message)
        }
    }
}

@Composable
fun PostListUi(
    modifier: Modifier = Modifier,
    data: Map<Long, List<PostModel>>,
    onItemClick: (PostModel) -> Unit
) {
    LazyColumn(modifier = modifier.fillMaxSize()) {
        data.forEach { (userId, posts) ->

            item {
                Text(
                    text = userId.toString(),
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 4.dp).background(
                        color = MaterialTheme.colorScheme.primary),
                    style = MaterialTheme.typography.titleMedium
                )
            }

            items(posts.size, key = { index -> "${index}_${posts[index].id}" }) { index ->
                Column(modifier = modifier.fillMaxWidth()) {
                    PostItem(post = posts[index], onItemClick = onItemClick)
                }
            }

        }
    }
}


@Composable
fun PostItem(modifier: Modifier = Modifier, post: PostModel, onItemClick: (PostModel) -> Unit) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 4.dp)
            .clickable { onItemClick(post) }, horizontalAlignment = Alignment.Start
    ) {
        Text(text = post.title, modifier = Modifier.padding(bottom = 4.dp))
    }
}


@Composable
fun LoadingUI(modifier: Modifier = Modifier) {
    Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = "Loading...")
    }
}

@Composable
fun ErrorUI(modifier: Modifier = Modifier, message: String) {
    Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = message)
    }
}