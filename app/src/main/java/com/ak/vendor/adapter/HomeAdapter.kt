package com.ak.vendor.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.ak.vendor.R
import com.ak.vendor.dataModel.*
import com.ak.vendor.databinding.BannerLayoutBinding
import com.ak.vendor.databinding.HomeCommanLayoutBinding

class HomeAdapter(private val mCtx : Context, private val dataTypeList : List<Any>, val dataList:List<Data>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        const val TYPE_BANNER = 0
        const val TYPE_EXPERT = 1
        const val TYPE_CATEGORY = 2
        const val TYPE_LIVE = 3
        const val TYPE_POSE = 4
        const val TYPE_PROFESSNAL = 5
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        when(viewType){

            TYPE_BANNER -> return BannerHolder(BannerLayoutBinding.inflate(LayoutInflater.from(mCtx),parent,false))
            TYPE_EXPERT -> return ItemHolder(HomeCommanLayoutBinding.inflate(LayoutInflater.from(mCtx),parent,false))
            TYPE_CATEGORY -> return ItemHolder(HomeCommanLayoutBinding.inflate(LayoutInflater.from(mCtx),parent,false))
            TYPE_LIVE -> return ItemHolder(HomeCommanLayoutBinding.inflate(LayoutInflater.from(mCtx),parent,false))
            TYPE_POSE -> return ItemHolder(HomeCommanLayoutBinding.inflate(LayoutInflater.from(mCtx),parent,false))
            TYPE_PROFESSNAL -> return ItemHolder(HomeCommanLayoutBinding.inflate(LayoutInflater.from(mCtx),parent,false))
            else -> throw IllegalArgumentException("Invalid ViewType Provided")
        }


    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder.itemViewType){

           TYPE_BANNER -> bannerView(holder as BannerHolder)
           TYPE_EXPERT -> expertView(holder as ItemHolder)
           TYPE_CATEGORY -> YogaView(holder as ItemHolder)
           TYPE_LIVE -> liveClassView(holder as ItemHolder)
           TYPE_POSE -> YogaPoseView(holder as ItemHolder)
           TYPE_PROFESSNAL -> professnalView(holder as ItemHolder)

       }
    }

    private fun bannerView(holder : BannerHolder) {
        val adapter = dataList.get(0).bannerDetails?.let { BannerAdapter(mCtx, it) }
        holder.binding.bannerPager.adapter = adapter

    }
    private fun expertView(holder : ItemHolder){

        holder.binding.tvTitle.text = mCtx.resources.getString(R.string.Explore_Videos)
        val adapter = dataList.get(0).expertVideos?.let { ExpertVideoAdapter(mCtx, it) }
        holder.binding.rvRecycler.layoutManager = LinearLayoutManager(mCtx,LinearLayoutManager.HORIZONTAL,false)
        holder.binding.rvRecycler.isNestedScrollingEnabled = false
        holder.binding.rvRecycler.adapter = adapter

    }
    private fun YogaView(holder : ItemHolder){
        holder.binding.tvTitle.text = mCtx.resources.getString(R.string.yoga_for)
        val adapter = dataList.get(0).category?.let { CategoryVideoAdapter(mCtx, it) }
        holder.binding.rvRecycler.layoutManager = StaggeredGridLayoutManager(2,LinearLayoutManager.VERTICAL)
        holder.binding.rvRecycler.isNestedScrollingEnabled = false
        holder.binding.rvRecycler.adapter = adapter
    }


    private fun liveClassView(holder : ItemHolder){
        holder.binding.tvTitle.text = mCtx.resources.getString(R.string.live_yoga)
        val adapter = dataList.get(0).liveYogaClasses?.let { LiveYogaAdapter(mCtx, it) }
        holder.binding.rvRecycler.layoutManager = LinearLayoutManager(mCtx,LinearLayoutManager.HORIZONTAL,false)
        holder.binding.rvRecycler.isNestedScrollingEnabled = false
        holder.binding.rvRecycler.adapter = adapter
    }
    private fun YogaPoseView(holder : ItemHolder){
        holder.binding.tvTitle.text = mCtx.resources.getString(R.string.yoga_pose)
        val adapter = dataList.get(0).yogaPosesVideo?.let { YogaPoseAdapter(mCtx, it) }
        holder.binding.rvRecycler.layoutManager = LinearLayoutManager(mCtx,LinearLayoutManager.VERTICAL,false)
        holder.binding.rvRecycler.isNestedScrollingEnabled = false
        holder.binding.rvRecycler.adapter = adapter
    }
    private fun professnalView(holder : ItemHolder){
        holder.binding.tvTitle.text = mCtx.resources.getString(R.string.yoga_professnals)
        val adapter = dataList.get(0).professionals?.let { YogaProfessnalAdapter(mCtx, it) }
        holder.binding.rvRecycler.layoutManager = LinearLayoutManager(mCtx,LinearLayoutManager.VERTICAL,false)
        holder.binding.rvRecycler.isNestedScrollingEnabled = false
        holder.binding.rvRecycler.adapter = adapter
    }

    override fun getItemViewType(position: Int): Int {
        val data = dataTypeList.get(position)
        when(data){

         is BannerDetail -> return TYPE_BANNER
         is ExpertVideo -> return TYPE_EXPERT
         is Category -> return TYPE_CATEGORY
         is LiveYogaClasse -> return TYPE_LIVE
         is YogaPosesVideo  -> return TYPE_POSE
         is Professional    -> return TYPE_PROFESSNAL

        }
        return super.getItemViewType(position)
    }


    override fun getItemCount(): Int = dataTypeList.size


    class BannerHolder(val binding : BannerLayoutBinding) : RecyclerView.ViewHolder(binding.root)
    class ItemHolder(val binding : HomeCommanLayoutBinding)   : RecyclerView.ViewHolder(binding.root)

}