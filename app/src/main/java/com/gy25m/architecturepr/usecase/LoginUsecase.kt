package com.gy25m.architecturepr.usecase

import android.util.Log
import com.gy25m.architecturepr.dao.UserDao
import com.gy25m.architecturepr.db.AppDatabase
import com.gy25m.architecturepr.entity.LoginEntity
import com.gy25m.architecturepr.repository.LoginRepository
import javax.inject.Inject

class LoginUsecase @Inject constructor(private  val loginRepository: LoginRepository) {


    fun useCaseGetApi()=loginRepository.getData()

    var aa :MutableList<LoginEntity> = mutableListOf()
    fun saveData() {
        loginRepository.getData()
            .map {
                it.forEach {
                    aa.add(LoginEntity(0,userId = it.userId.toString(), id = it.id.toString(), title = it.title, body = it.body))
                }
                aa.forEach {
                    loginRepository.saveData(it)
                }


            }.subscribe()
    }


}