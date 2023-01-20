package com.example.suitmediaandroidtest.api

import com.example.suitmediaandroidtest.model.ResponseUserList
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("/api/users?page=1")
    fun getListUser(): Call<ResponseUserList>
}