package com.example.suitmediaandroidtest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.suitmediaandroidtest.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    companion object {
        const val EXTRA_NAME = "extra_name"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_second)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()

        supportActionBar?.hide()
    }

    private fun initView() {
        with(binding) {
            tvNama.text = intent.getStringExtra(EXTRA_NAME)

            btnChooseUser.setOnClickListener {
                startActivity(Intent(this@SecondActivity, ThirdActivity::class.java))
            }
        }
    }
}