package com.akexorcist.bookapp.ui

import android.content.Intent
import android.os.AsyncTask
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import com.akexorcist.bookapp.R
import com.akexorcist.bookapp.ui.adapter.BookAdapter
import com.akexorcist.bookapp.vo.Book
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var adapter: BookAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = BookAdapter()
        adapter.setListener(object : BookAdapter.Listener {
            override fun onBookClick(book: Book) {
                // TODO Save selected book to database
            }
        })
        recyclerViewBook?.layoutManager = LinearLayoutManager(this)
        recyclerViewBook?.adapter = adapter

        buttonBookmark?.setOnClickListener { goToBookmark() }

        // TODO Get all books from web service
        // TODO Show loading
    }

    private fun showLoading() {
        recyclerViewBook?.visibility = View.GONE
        progressBar?.visibility = View.VISIBLE
    }

    private fun showContent() {
        recyclerViewBook?.visibility = View.VISIBLE
        progressBar?.visibility = View.GONE
    }

    private fun showUnavailable(message: String?) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun updateBookList(bookList: List<Book>?) {
        bookList?.let {
            adapter.setBookList(bookList)
            adapter.notifyDataSetChanged()
        }
    }

    private fun goToBookmark() {
        val intent = Intent(this, BookmarkActivity::class.java)
        startActivity(intent)
    }

    private fun saveBook(book: Book) {
        // Run in background thread
        AsyncTask.execute {
            // TODO Save the book to database
        }
        Toast.makeText(this, "${book.title} was saved", Toast.LENGTH_SHORT).show()
    }
}
