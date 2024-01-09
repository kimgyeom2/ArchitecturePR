package com.gy25m.architecturepr.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.gy25m.architecturepr.entity.LoginEntity
import com.gy25m.architecturepr.model.User

@Dao
interface UserDao {
    @Insert
    fun insert(user: LoginEntity)

}