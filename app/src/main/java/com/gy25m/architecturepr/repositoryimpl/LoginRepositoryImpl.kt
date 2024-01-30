package com.gy25m.architecturepr.repositoryimpl

import com.gy25m.architecturepr.apiservice.ApiService
import com.gy25m.architecturepr.db.AppDatabase
import com.gy25m.architecturepr.entity.LoginEntity
import com.gy25m.architecturepr.model.User
import com.gy25m.architecturepr.repository.LoginRepository
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class LoginRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val database: AppDatabase
    ):LoginRepository {

    override suspend fun getData(): List<User> = apiService.getJson()

    override fun saveData(user: LoginEntity) {
        database.userDao().insert(user)
    }

}