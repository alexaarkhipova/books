package com.example.books

import BooksApp
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.books.ui.screens.BookDetailScreen
import com.example.books.ui.theme.BooksTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BooksTheme {
                BooksApp(
                    onBookClicked = { book ->
                        setContent {
                            BookDetailScreen(book = book)
                        }
                    }
                )
            }
        }
    }
}

