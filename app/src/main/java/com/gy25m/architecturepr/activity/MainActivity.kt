package com.gy25m.architecturepr.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.gy25m.architecturepr.R
import com.gy25m.architecturepr.adapter.RecyclerAdapter
import com.gy25m.architecturepr.databinding.ActivityLoginBinding
import com.gy25m.architecturepr.viewmodel.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint
import org.koin.androidx.viewmodel.ext.android.viewModel

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val myViewmodel:LoginViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding:ActivityLoginBinding=DataBindingUtil.setContentView(this,R.layout.activity_login)
        binding.vm=myViewmodel
//        binding.re.adapter=RecyclerAdapter()
        binding.lifecycleOwner=this

    }
}