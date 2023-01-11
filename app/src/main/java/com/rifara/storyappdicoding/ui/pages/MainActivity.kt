package com.rifara.storyappdicoding.ui.pages


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.rifara.storyappdicoding.ui.viewmodel.AuthViewModel
import com.rifara.storyappdicoding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var activityMainBinding: ActivityMainBinding // ViewBinding
    private lateinit var viewModel: AuthViewModel // ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)
        viewModel = ViewModelProvider(this).get(AuthViewModel::class.java)





    }
}