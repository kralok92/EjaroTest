package com.ak.vendor.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ak.vendor.R
import com.ak.vendor.dataModel.Professional
import com.ak.vendor.databinding.YogaProfessnalItemBinding
import com.squareup.picasso.Picasso

class YogaProfessnalAdapter(val mCtx : Context,val dataList : List<Professional>) : RecyclerView.Adapter<YogaProfessnalAdapter.YogaProfessnalHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): YogaProfessnalHolder {
      return YogaProfessnalHolder(YogaProfessnalItemBinding.inflate(LayoutInflater.from(mCtx),parent,false))
    }

    override fun onBindViewHolder(holder: YogaProfessnalHolder, position: Int) {
        val data = dataList.get(position)
        if (!data.photo.equals("")){
            Picasso.get().load(data.photo)
                .fit()
                .error(R.drawable.user)
                .placeholder(R.drawable.user)
                .into(holder.binding.userImage)
        }

    }

    override fun getItemCount(): Int = dataList.size

    class YogaProfessnalHolder(val binding: YogaProfessnalItemBinding) : RecyclerView.ViewHolder(binding.root)
}