package com.example.suitmediaandroidtest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.suitmediaandroidtest.adapter.UserAdapter
import com.example.suitmediaandroidtest.databinding.ActivityThirdBinding
import com.example.suitmediaandroidtest.model.ResponseUserList

class ThirdActivity : AppCompatActivity() {

    private lateinit var binding: ActivityThirdBinding
    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_third)
        binding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
        supportActionBar?.hide()
    }

    private fun initView() {
        with(binding) {
            viewModel.getUserList()

            viewModel.userList.observe(this@ThirdActivity) { list ->
                rvUser.setHasFixedSize(true)
                rvUser.layoutManager = LinearLayoutManager(this@ThirdActivity)
                rvUser.adapter = UserAdapter(list)
            }
        }
    }
}