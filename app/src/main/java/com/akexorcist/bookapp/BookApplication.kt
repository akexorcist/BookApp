package com.akexorcist.bookapp

import android.app.Application
import com.akexorcist.bookapp.db.DatabaseManager

class BookApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        DatabaseManager.init(applicationContext)
    }
}