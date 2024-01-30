package com.gy25m.architecturepr.usecase

import android.util.Log
import com.gy25m.architecturepr.dao.UserDao
import com.gy25m.architecturepr.db.AppDatabase
import com.gy25m.architecturepr.entity.LoginEntity
import com.gy25m.architecturepr.repository.LoginRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext
import javax.inject.Inject

class LoginUsecase @Inject constructor(private  val loginRepository: LoginRepository) {


    suspend fun useCaseGetApi()=loginRepository.getData()

    suspend fun saveData() {
        val data = loginRepository.getData()
        data.map {
            LoginEntity(0, userId = it.userId.toString(), id = it.id.toString(), title = it.title, body = it.body)
        }.forEach { loginRepository.saveData(it) }
    }


}