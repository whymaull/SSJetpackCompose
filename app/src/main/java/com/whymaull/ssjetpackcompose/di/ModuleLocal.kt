package com.whymaull.ssjetpackcompose.di

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import com.whymaull.ssjetpackcompose.data.local.PhoneDB

object ModuleLocal {

    fun provideDB (application: Application) = Room
        .databaseBuilder(application, PhoneDB::class.java, "phone.db")
        .fallbackToDestructiveMigration()
        .build()

    fun provideDao (database: PhoneDB) = database.phoneDao()

}