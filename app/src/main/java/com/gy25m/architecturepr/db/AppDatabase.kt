package com.gy25m.architecturepr.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.gy25m.architecturepr.dao.UserDao
import com.gy25m.architecturepr.entity.LoginEntity

@Database(entities = [LoginEntity::class], version = 2, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}