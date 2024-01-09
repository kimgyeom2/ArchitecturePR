package com.gy25m.architecturepr.viewmodel

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gy25m.architecturepr.model.User
import com.gy25m.architecturepr.usecase.LoginUsecase
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.coroutines.coroutineScope
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val loginUsecase: LoginUsecase):ViewModel() {

    var content:MutableLiveData<List<User>> = MutableLiveData(listOf())


    fun btnClick(){
           var cc= loginUsecase.useCaseGetApi()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    content.value=it
                },{})

    }

    fun saveData(){
        loginUsecase.saveData()
    }



    

}