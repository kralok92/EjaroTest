package com.ak.vendor.adapter

import android.content.Context
import android.graphics.Point
import android.view.Display
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.WindowManager
import androidx.recyclerview.widget.RecyclerView
import com.ak.vendor.R
import com.ak.vendor.dataModel.ExpertVideo
import com.ak.vendor.databinding.ExpertVideoItemBinding
import com.squareup.picasso.Picasso

class ExpertVideoAdapter(private val mCtx : Context,private val dataList : List<ExpertVideo>) : RecyclerView.Adapter<ExpertVideoAdapter.ExpertHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExpertHolder {

        val binding = ExpertVideoItemBinding.inflate(LayoutInflater.from(mCtx), parent, false)
        if (dataList.size >1)
        binding.root.layoutParams.width = (getScreenWidth() / 1.10).toInt()
        return ExpertHolder(binding)
    }

    override fun onBindViewHolder(holder: ExpertHolder, position: Int) {
        val data = dataList.get(position)
        if (!data.thumbnail.equals("")){
            Picasso.get().load(data.thumbnail)
                .error(R.drawable.background)
                .placeholder(R.drawable.background)
                .into(holder.binding.expertThumbnail)
        }

    }

    override fun getItemCount(): Int = dataList.size

    class ExpertHolder(val binding : ExpertVideoItemBinding) : RecyclerView.ViewHolder(binding.root)

    fun getScreenWidth(): Int {
        val wm = mCtx.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val display: Display = wm.defaultDisplay
        val size = Point()
        display.getSize(size)
        return size.x
    }
}