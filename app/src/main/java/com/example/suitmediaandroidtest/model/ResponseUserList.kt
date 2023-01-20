package com.example.suitmediaandroidtest.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class ResponseUserList(

    @field:SerializedName("page")
    val page: Int? = null,

    @field:SerializedName("per_page")
    val perPage: Int? = null,

    @field:SerializedName("total")
    val total: Int? = null,

    @field:SerializedName("total_pages")
    val totalPages: Int? = null,

    @field:SerializedName("data")
    val data: List<UserItem>? = null
) : Parcelable {

    @Parcelize
    data class UserItem(
        @field:SerializedName("email")
        val email: String? = null,

        @field:SerializedName("first_name")
        val first_name: String? = null,

        @field:SerializedName("last_name")
        val last_name: String? = null,

        @field:SerializedName("avatar")
        val avatar: String? = null
    ) : Parcelable
}
