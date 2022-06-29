package com.ak.vendor.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ak.vendor.R
import com.ak.vendor.dataModel.BannerDetail
import com.ak.vendor.databinding.BannerItemBinding
import com.squareup.picasso.Picasso

class BannerAdapter(private val mCtx : Context,private val bannerList : List<BannerDetail>) : RecyclerView.Adapter<BannerAdapter.bannerHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): bannerHolder {
     return bannerHolder(BannerItemBinding.inflate(LayoutInflater.from(mCtx),parent,false))
    }

    override fun onBindViewHolder(holder: bannerHolder, position: Int) {
        val data = bannerList.get(position)

        if (!data.image.equals("")){
            Picasso.get().load(data.image)
                .error(R.drawable.background)
                .placeholder(R.drawable.background)
                .into(holder.binding.ivHeader)
        }

    }

    override fun getItemCount(): Int = bannerList.size

    class bannerHolder(val binding : BannerItemBinding) : RecyclerView.ViewHolder(binding.root)
}