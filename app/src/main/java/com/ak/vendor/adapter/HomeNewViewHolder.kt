package com.ak.vendor.adapter

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.ak.vendor.R
import com.ak.vendor.databinding.BannerLayoutBinding
import com.ak.vendor.databinding.ViewTypeOneBinding
import com.ak.vendor.databinding.ViewTypeTwoBinding
import com.squareup.picasso.Picasso

sealed class HomeNewViewHolder(binding : ViewBinding) : RecyclerView.ViewHolder(binding.root){

    class OneViewHolder(private val binding: ViewTypeOneBinding) : HomeNewViewHolder(binding){
        fun bind(){
            Picasso.get().load("https://storage.googleapis.com/consumer_api_data/HomeScreenBanner/banner_1.png")
                .fit()
                .error(R.drawable.background)
                .placeholder(R.drawable.background)
                .into(binding.ivImage1)

            Picasso.get().load("https://storage.googleapis.com/consumer_api_data/HomeScreenBanner/banner_1.png")
                .fit()
                .error(R.drawable.background)
                .placeholder(R.drawable.background)
                .into(binding.ivImage2)

            Picasso.get().load("https://storage.googleapis.com/consumer_api_data/HomeScreenBanner/banner_1.png")
                .fit()
                .error(R.drawable.background)
                .placeholder(R.drawable.background)
                .into(binding.ivImage3)
        }
    }
    class TwoViewHolder(private val binding: ViewTypeTwoBinding) : HomeNewViewHolder(binding){
        fun bind(){
            Picasso.get().load("https://storage.googleapis.com/consumer_api_data/HomeScreenBanner/banner_1.png")
                .fit()
                .error(R.drawable.background)
                .placeholder(R.drawable.background)
                .into(binding.ivImage1)

            Picasso.get().load("https://storage.googleapis.com/consumer_api_data/HomeScreenBanner/banner_1.png")
                .fit()
                .error(R.drawable.background)
                .placeholder(R.drawable.background)
                .into(binding.ivImage2)

            Picasso.get().load("https://storage.googleapis.com/consumer_api_data/HomeScreenBanner/banner_1.png")
                .fit()
                .error(R.drawable.background)
                .placeholder(R.drawable.background)
                .into(binding.ivImage3)
        }
    }
}
