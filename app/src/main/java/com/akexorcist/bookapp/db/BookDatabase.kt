package com.akexorcist.bookapp.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.akexorcist.bookapp.vo.Book

@Database(
        entities = [
            Book::class
        ],
        version = 1
)
abstract class BookDatabase : RoomDatabase() {
    abstract fun bookDao(): BookDao
}