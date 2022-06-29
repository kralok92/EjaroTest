package com.ak.vendor.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ak.vendor.dataModel.*
import com.ak.vendor.databinding.ViewTypeOneBinding
import com.ak.vendor.databinding.ViewTypeTwoBinding

class HomeNewAdapter : RecyclerView.Adapter<HomeNewViewHolder>(){

    companion object {
        const val TYPE_ONE = 1
        const val TYPE_TWO = 2
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeNewViewHolder {
        return when(viewType){
            TYPE_ONE -> HomeNewViewHolder.OneViewHolder(
                ViewTypeOneBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
            TYPE_TWO -> HomeNewViewHolder.TwoViewHolder(
                ViewTypeTwoBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
            else -> throw IllegalArgumentException("Invalid ViewType Provided")
        }
    }

    override fun onBindViewHolder(holder: HomeNewViewHolder, position: Int) {
        when(holder){
            is HomeNewViewHolder.OneViewHolder -> holder.bind()
            is HomeNewViewHolder.TwoViewHolder -> holder.bind()
        }

    }

    override fun getItemCount(): Int = 10

    override fun getItemViewType(position: Int): Int {

        if (position % 2 == 0) return TYPE_ONE
        else return TYPE_TWO
    }

}