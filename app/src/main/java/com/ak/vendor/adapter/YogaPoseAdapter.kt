package com.ak.vendor.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ak.vendor.R
import com.ak.vendor.dataModel.YogaPosesVideo
import com.ak.vendor.databinding.YogaPoseItemBinding
import com.squareup.picasso.Picasso

class YogaPoseAdapter(val mCtx : Context,val dataList : List<YogaPosesVideo>) : RecyclerView.Adapter<YogaPoseAdapter.YogaPoseHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): YogaPoseHolder {
        val binding = YogaPoseItemBinding.inflate(LayoutInflater.from(mCtx),parent,false)
       return YogaPoseHolder(binding)
    }

    override fun onBindViewHolder(holder: YogaPoseHolder, position: Int) {
        val data = dataList.get(position)

        if (!data.image.equals("")){
            Picasso.get().load(data.image)
                .error(R.drawable.background)
                .placeholder(R.drawable.background)
                .into(holder.binding.thumbnail)
        }

    }

    override fun getItemCount(): Int = dataList.size

    class YogaPoseHolder(val binding : YogaPoseItemBinding) : RecyclerView.ViewHolder(binding.root)
}