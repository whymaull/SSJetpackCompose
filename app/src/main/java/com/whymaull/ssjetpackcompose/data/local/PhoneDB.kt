package com.whymaull.ssjetpackcompose.data.local

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [PhoneEntity::class], version = 1, exportSchema = false)
abstract class PhoneDB : RoomDatabase() {

    abstract fun phoneDao() :PhoneDao

}