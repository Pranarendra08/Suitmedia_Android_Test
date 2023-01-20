package com.example.suitmediaandroidtest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.suitmediaandroidtest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
        supportActionBar?.hide()
    }

    private fun initView() {
        with(binding) {
            btnNextAct2.setOnClickListener {
                val nama = edtName.text.toString()
                if (nama.equals("")) {
                    edtName.error = "Silahkan Isi Nama Anda"
                    edtName.requestFocus()
                } else {
                    val nextActivity = Intent(this@MainActivity, SecondActivity::class.java)
                    nextActivity.putExtra(SecondActivity.EXTRA_NAME, nama)
                    startActivity(nextActivity)
                }
            }

            btnCheck.setOnClickListener {
                var palindrome = edtPalindrome.text.toString().replace("\\s".toRegex(), "")
                if (palindrome.equals("")) {
                    edtPalindrome.error = "Silahkan Isi Text Palindrome"
                } else {
                    checkPalindrome(palindrome)
                }

            }
        }
    }

    private fun checkPalindrome(palindrome: String) {
        val sb = StringBuilder(palindrome)
        val reverseString = sb.reverse().toString()

        if (reverseString == palindrome) {
            Toast.makeText(this, "Is Palindrome", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(this, "Not Palindrome", Toast.LENGTH_LONG).show()
        }
    }
}