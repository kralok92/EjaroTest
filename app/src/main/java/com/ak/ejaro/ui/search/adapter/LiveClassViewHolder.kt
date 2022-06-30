package consumer.yogpath.wellness.home.liveClass.adapter

import android.content.Context
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.ak.ejaro.databinding.LiveHeaderBinding
import com.ak.ejaro.databinding.SolutionBasedWellnessLayoutBinding
import com.ak.ejaro.databinding.TodayLiveLayoutBinding
import com.ak.ejaro.databinding.TopInstructorLayoutBinding
import com.ak.ejaro.ui.search.dataModel.LiveClassDataItem

sealed class LiveClassViewHolder(private val binding : ViewBinding): RecyclerView.ViewHolder(binding.root){


    class HeaderView(private val binding : LiveHeaderBinding):LiveClassViewHolder(binding){
        fun bind(mCtx:Context,data : LiveClassDataItem.LiveData){


        }
    }
    class TopInstructorView(private val binding: TopInstructorLayoutBinding):LiveClassViewHolder(binding){
        fun bind(mCtx:Context,data :List<LiveClassDataItem.TopInstructor>){
            val adapter = TopInstructorAdapter(mCtx,data)
            binding.rvRecycler.layoutManager = LinearLayoutManager(mCtx,LinearLayoutManager.HORIZONTAL,false)
            binding.rvRecycler.adapter = adapter
        }
    }
    class SolutionBasedLiveView(private val binding: SolutionBasedWellnessLayoutBinding):LiveClassViewHolder(binding){
        fun bind(mCtx:Context,data :List<LiveClassDataItem.ProgramLists>){

            val adapter = ProgramAdapter(mCtx,data)
            binding.rvRecycler.layoutManager = LinearLayoutManager(mCtx,LinearLayoutManager.VERTICAL,false)
            binding.rvRecycler.adapter = adapter
        }
    }
    class TodayLiveView(private val binding: TodayLiveLayoutBinding):LiveClassViewHolder(binding){
        fun bind(mCtx:Context,data :List<LiveClassDataItem.TodayLiveClas>){

            val adapter = TodayLiveAdapter(mCtx,data)
            binding.rvRecycler.layoutManager = LinearLayoutManager(mCtx,LinearLayoutManager.VERTICAL,false)
            binding.rvRecycler.adapter = adapter

        }
    }

}
