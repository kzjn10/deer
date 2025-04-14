package com.anhndt.iv.ui.detail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import com.anhndt.iv.domain.model.PostModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PostDetail(modifier: Modifier, data: PostModel, onBackPress: () -> Unit) {
    var scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(
        state = rememberTopAppBarState()
    )
    Scaffold(modifier = modifier.fillMaxSize().nestedScroll(scrollBehavior.nestedScrollConnection), topBar = {
        TopAppBar(
            title = { Text(text = "Post Detail") },
            scrollBehavior = scrollBehavior,
            navigationIcon = {
                IconButton(
                    onClick = onBackPress,
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Default.ArrowBack,
                        contentDescription = "Back"
                    )
                }
            }
        )
    }) { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            Column() {
                Text(text = "UID: ${data.userId}")
                Text(text = "ID: ${data.id}")
                Text(text = "Title: ${data.title}")
                Text(text = "Body: ${data.body}")
            }
        }
    }
}