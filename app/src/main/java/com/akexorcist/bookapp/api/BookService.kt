package com.akexorcist.bookapp.api

import com.akexorcist.bookapp.vo.Book
import retrofit2.Call
import retrofit2.http.GET

interface BookService {
    @GET("/api/v1/books")
    fun getAllBooks(): Call<List<Book>>
}