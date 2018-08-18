package com.akexorcist.bookapp.ui

import android.os.AsyncTask
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import com.akexorcist.bookapp.R
import com.akexorcist.bookapp.ui.adapter.BookAdapter
import com.akexorcist.bookapp.vo.Book
import kotlinx.android.synthetic.main.activity_bookmark.*

class BookmarkActivity : AppCompatActivity() {
    private lateinit var adapter: BookAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bookmark)

        adapter = BookAdapter()
        adapter.setListener(object : BookAdapter.Listener {
            override fun onBookClick(book: Book) {
                // TODO Delete selected book
            }
        })
        recyclerViewBook?.layoutManager = LinearLayoutManager(this)
        recyclerViewBook?.adapter = adapter
        getAllBookFromDatabase()
    }

    private fun getAllBookFromDatabase() {
        AsyncTask.execute {
            // TODO Get all books from database
            runOnUiThread {
                // TODO Show all books
            }
        }
    }

    private fun deleteBook(book: Book) {
        AsyncTask.execute {
            // Delete the book from database
        }
        Toast.makeText(this, "${book.title} was delete", Toast.LENGTH_SHORT).show()
        // TODO Refresh book list again
    }

    private fun updateBook(bookList: List<Book>) {
        adapter.setBookList(bookList)
        adapter.notifyDataSetChanged()
    }

    private fun showBook() {
        textViewEmptyBookSaved?.visibility = View.GONE
        recyclerViewBook?.visibility = View.VISIBLE
    }

    private fun showEmpty() {
        textViewEmptyBookSaved?.visibility = View.VISIBLE
        recyclerViewBook?.visibility = View.GONE
    }
}