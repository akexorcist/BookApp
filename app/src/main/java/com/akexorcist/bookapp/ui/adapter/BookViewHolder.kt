package com.akexorcist.bookapp.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.view_book_item.*

class BookViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView), LayoutContainer {
    fun setTitle(title: String) {
        textViewTitle?.text = title
    }

    fun setSubTitle(subTitle: String) {
        textViewSubTitle?.text = subTitle
    }

    fun setAuthor(author: String) {
        textViewAuthor?.text = author
    }

    fun setIsbn(isbn: String) {
        textViewIsbn?.text = isbn
    }

    fun setPageCount(pageCount: Int) {
        textViewPageCount?.text = String.format("%s pages", pageCount)
    }

    fun setOnBookClickListener(listener: View.OnClickListener) {
        itemView.setOnClickListener(listener)
    }
}