package com.gy25m.architecturepr.repository

import com.gy25m.architecturepr.entity.LoginEntity
import com.gy25m.architecturepr.model.User
import com.gy25m.architecturepr.repositoryimpl.LoginRepositoryImpl
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

interface LoginRepository  {

    suspend fun getData():List<User>

    fun saveData(user: LoginEntity)
}