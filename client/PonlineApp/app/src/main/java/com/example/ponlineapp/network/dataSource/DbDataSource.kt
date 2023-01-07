package com.example.ponlineapp.network.dataSource

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.ponlineapp.network.modelDatabase.User
import com.example.ponlineapp.network.modelDatabase.UserDao

@Database(entities = [User::class], version = 1)
abstract class DbDataSource : RoomDatabase() {

    abstract fun userDao(): UserDao
}