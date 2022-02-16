package com.network

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.lifecycleScope
import com.network.api.RetrofitClient
import com.network.response.users.Users
import com.network.viewmodel.HomeViewModel
import com.ui.CustomButton
import kotlinx.coroutines.launch

class AppService : AppCompatActivity() {

    lateinit var parent:LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        lifecycleScope.launch {
           // getUsers()
        }
    }
}