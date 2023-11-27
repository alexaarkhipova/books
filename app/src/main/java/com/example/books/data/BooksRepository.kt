package com.example.books.data

import com.example.books.network.model.BookService

interface BooksRepository {
    suspend fun getBooks(query: String, maxResults: Int) : List<Book>
}

class NetworkBooksRepository(
    private val bookService: BookService
) : BooksRepository {
    override suspend fun getBooks(
        query: String,
        maxResults: Int
    ): List<Book> = bookService.bookSearch(query, maxResults).items.map { items ->
        Book(
            previewLink = items.volumeInfo?.previewLink,
            imageLink = items.volumeInfo?.imageLinks?.thumbnail
        )
    }
}