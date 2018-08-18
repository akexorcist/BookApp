package com.akexorcist.bookapp.vo

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey


@Entity(tableName = "books")
data class Book(@PrimaryKey
                var isbn: String,
                var title: String,
                var subtitle: String,
                var author: String,
                var published: String,
                var publisher: String,
                var pages: Int,
                var website: String)