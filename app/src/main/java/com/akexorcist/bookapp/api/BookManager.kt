package com.akexorcist.bookapp.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object BookManager {
    fun init(): BookService {
        val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                // TODO Change base url
                .baseUrl("http://www.example.com")
                .build()
        return retrofit.create(BookService::class.java)
    }
}