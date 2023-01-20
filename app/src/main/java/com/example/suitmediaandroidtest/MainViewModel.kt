package com.example.suitmediaandroidtest

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.suitmediaandroidtest.api.ApiConfig
import com.example.suitmediaandroidtest.model.ResponseUserList
import retrofit2.Call
import retrofit2.Response

class MainViewModel (private val app: Application) : AndroidViewModel(app) {
    private val client = ApiConfig.getApiService()

    private val _userList = MutableLiveData<List<ResponseUserList.UserItem>>()
    var userList: LiveData<List<ResponseUserList.UserItem>> = _userList

    fun getUserList() {
        client.getListUser().enqueue(object : retrofit2.Callback<ResponseUserList>{
            override fun onResponse(
                call: Call<ResponseUserList>,
                response: Response<ResponseUserList>
            ) {
                if (response.isSuccessful) {
                    val responseList = response.body()?.data ?: emptyList()

                    _userList.value = responseList
                } else {
                    Toast.makeText(app, "There is something wrong in the cloud", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<ResponseUserList>, t: Throwable) {
                Toast.makeText(app, "There is something wrong with your internet", Toast.LENGTH_SHORT).show()
            }

        })
    }

}