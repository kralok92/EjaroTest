package com.ak.vendor.adapter

import android.content.Context
import android.graphics.Point
import android.view.Display
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.WindowManager
import androidx.recyclerview.widget.RecyclerView
import com.ak.vendor.R
import com.ak.vendor.dataModel.LiveYogaClasse
import com.ak.vendor.databinding.LiveYogaItemBinding
import com.squareup.picasso.Picasso


class LiveYogaAdapter(val mCtx : Context,val dataList : List<LiveYogaClasse>) : RecyclerView.Adapter<LiveYogaAdapter.LiveYogaHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LiveYogaHolder {
        val binding = LiveYogaItemBinding.inflate(LayoutInflater.from(mCtx), parent, false)
        if (dataList.size > 1)
        binding.root.layoutParams.width = (getScreenWidth() / 1.10).toInt()
        return LiveYogaHolder(binding)
    }

    override fun onBindViewHolder(holder: LiveYogaHolder, position: Int) {
        val data = dataList.get(position)

        if (!data.image.equals("")){
            Picasso.get().load(data.image)
                .fit()
                .error(R.drawable.background)
                .placeholder(R.drawable.background)
                .into(holder.binding.thumbnail)
        }
    }

    override fun getItemCount(): Int = dataList.size

    class LiveYogaHolder(val binding : LiveYogaItemBinding) : RecyclerView.ViewHolder(binding.root)

    fun getScreenWidth(): Int {
        val wm = mCtx.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val display: Display = wm.defaultDisplay
        val size = Point()
        display.getSize(size)
        return size.x
    }
}