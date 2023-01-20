package com.example.suitmediaandroidtest.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.suitmediaandroidtest.databinding.AdapterUserBinding
import com.example.suitmediaandroidtest.model.ResponseUserList

class UserAdapter(private val list: List<ResponseUserList.UserItem>) :
    RecyclerView.Adapter<UserAdapter.UserItemViewHolder>() {

    inner class UserItemViewHolder(private val binding : AdapterUserBinding) :
        RecyclerView.ViewHolder(binding.root){

        fun bind(item: ResponseUserList.UserItem) {
            with(binding) {
                item.apply {
                    Glide.with(itemView.context)
                        .load(item.avatar)
                        .apply(RequestOptions.circleCropTransform())
                        .into(ivUserPhoto)

                    tvNamaUser.text = "$first_name $last_name"
                    tvEmailUser.text = email
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserItemViewHolder =
        UserItemViewHolder(
            AdapterUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    override fun onBindViewHolder(holder: UserItemViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size
}