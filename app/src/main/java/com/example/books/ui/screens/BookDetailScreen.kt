package com.example.books.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.books.R
import com.example.books.data.Book

@Composable
fun BookDetailScreen(book: Book) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AsyncImage(
            modifier = Modifier.fillMaxSize(),
            model = ImageRequest.Builder(context = LocalContext.current)
                .data(book.imageLink?.replace("http", "https"))
                .crossfade(true)
                .build(),
            error = painterResource(id = R.drawable.ic_book_96),
            placeholder = painterResource(id = R.drawable.loading_img),
            contentDescription = stringResource(id = R.string.content_description),
            contentScale = ContentScale.Fit
        )
        }
    }