package com.akexorcist.bookapp.db

import android.arch.persistence.room.Room
import android.content.Context

object DatabaseManager {
    private lateinit var bookDatabase: BookDatabase

    fun init(context: Context) {
        bookDatabase = Room.databaseBuilder(context, BookDatabase::class.java, "books.db").build()
    }

    fun get(): BookDatabase = bookDatabase
}