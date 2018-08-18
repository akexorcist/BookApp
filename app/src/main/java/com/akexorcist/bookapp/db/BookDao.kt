package com.akexorcist.bookapp.db

import android.arch.persistence.room.*
import com.akexorcist.bookapp.vo.Book

@Dao
interface BookDao {
    @Query("SELECT * FROM books")
    fun getAllBooks(): List<Book>

    @Query("SELECT * FROM books WHERE isbn = :isbn")
    fun getBookByIsbn(isbn: String): Book?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addBook(vararg book: Book)

    @Delete
    fun deleteBook(book: Book)
}