package com.ak.vendor.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ak.vendor.R
import com.ak.vendor.dataModel.Category
import com.ak.vendor.databinding.CategoryRectItemBinding
import com.ak.vendor.databinding.CategorySqreItemBinding
import com.squareup.picasso.Picasso

class CategoryVideoAdapter(private val mCtx : Context,private val dataList : List<Category>) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    companion object {
        const val TYPE_RECT = 0
        const val TYPE_SQUARE = 1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        when (viewType) {

            TYPE_RECT -> return RectHolder(
                CategoryRectItemBinding.inflate(
                    LayoutInflater.from(mCtx),
                    parent,
                    false
                )
            )
            TYPE_SQUARE -> return SquareHolder(
                CategorySqreItemBinding.inflate(
                    LayoutInflater.from(
                        mCtx
                    ), parent, false
                )
            )
        }

        return SquareHolder(
            CategorySqreItemBinding.inflate(
                LayoutInflater.from(mCtx),
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val data = dataList.get(position)
        when(holder.itemViewType){
            TYPE_RECT -> rectView(holder as RectHolder,data)
            TYPE_SQUARE -> squareView(holder as SquareHolder,data)

        }

    }

    private fun rectView(holder : RectHolder, data : Category) {

        holder.binding.tvTitle.text = data.categoryName
        if (!data.image.equals("")){
         Picasso.get().load(data.image)
             .error(R.drawable.background)
             .placeholder(R.drawable.background)
             .into(holder.binding.image)
        }
    }
    private fun squareView(holder : SquareHolder, data : Category) {
        holder.binding.tvTitle.text = data.categoryName
        if (!data.image.equals("")){
            Picasso.get().load(data.image)
                .error(R.drawable.background)
                .placeholder(R.drawable.background)
                .into(holder.binding.image)
        }
    }


    override fun getItemViewType(position: Int): Int {
        when(position){

            0 -> return TYPE_RECT
            1 -> return TYPE_SQUARE
            2 -> return TYPE_SQUARE
            3 -> return TYPE_SQUARE
            4 -> return TYPE_RECT
            5 -> return TYPE_SQUARE

        }
        return super.getItemViewType(position)
    }

    override fun getItemCount(): Int = dataList.size
    class RectHolder(val binding : CategoryRectItemBinding) : RecyclerView.ViewHolder(binding.root)
    class SquareHolder(val binding : CategorySqreItemBinding) : RecyclerView.ViewHolder(binding.root)
}