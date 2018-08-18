package com.akexorcist.bookapp.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.akexorcist.bookapp.R
import com.akexorcist.bookapp.vo.Book

class BookAdapter : RecyclerView.Adapter<BookViewHolder>() {
    private var bookList: List<Book>? = null
    private var listener: Listener? = null

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): BookViewHolder =
            BookViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.view_book_item, parent, false))

    override fun getItemCount(): Int = bookList?.size ?: 0

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        val book = bookList?.get(position)
        book?.let { _ ->
            holder.setTitle(book.title)
            holder.setSubTitle(book.subtitle)
            holder.setAuthor(book.author)
            holder.setIsbn(book.isbn)
            holder.setPageCount(book.pages)
            holder.setOnBookClickListener(View.OnClickListener {
                listener?.onBookClick(book)
            })
        }
    }

    fun setBookList(bookList: List<Book>) {
        this.bookList = bookList
    }

    fun setListener(listener: Listener) {
        this.listener = listener
    }

    interface Listener {
        fun onBookClick(book: Book)
    }
}