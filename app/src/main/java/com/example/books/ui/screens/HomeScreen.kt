package com.example.books.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.books.data.Book
import com.example.books.ui.theme.BooksUiState

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    booksUiState: BooksUiState,
    retryAction: () -> Unit,
    onBookClicked: (Book) -> Unit
) {
    when (booksUiState) {
        is BooksUiState.Loading -> LoadingScreen()
        is BooksUiState.Success -> BooksGridScreen(
            books = booksUiState.bookSearch,
            modifier = modifier,
            onBookClicked
        )
        is BooksUiState.Error -> ErrorScreen(retryAction = retryAction)
        else -> {}
    }
}