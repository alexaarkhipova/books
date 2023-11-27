package com.example.books.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.books.ui.theme.BooksUiState

@Composable
fun HomeScreen(
    booksUiState: BooksUiState,
    retryAction: () -> Unit,
    modifier: Modifier = Modifier
) {
    when (booksUiState) {
        is BooksUiState.Loading -> LoadingScreen()
        is BooksUiState.Success -> BooksGridScreen(
            books = booksUiState.bookSearch,
            modifier = Modifier
        )
        is BooksUiState.Error -> ErrorScreen(retryAction = retryAction)
        else -> {}
    }
}