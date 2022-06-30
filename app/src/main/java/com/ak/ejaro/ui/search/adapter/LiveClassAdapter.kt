package consumer.yogpath.wellness.home.liveClass.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ak.ejaro.databinding.LiveHeaderBinding
import com.ak.ejaro.databinding.SolutionBasedWellnessLayoutBinding
import com.ak.ejaro.databinding.TodayLiveLayoutBinding
import com.ak.ejaro.databinding.TopInstructorLayoutBinding
import com.ak.ejaro.ui.search.dataModel.LiveClassDataItem
import java.lang.IllegalArgumentException

class LiveClassAdapter(private val mCtx: Context,
                       private val dataType : List<LiveClassDataItem> ):RecyclerView.Adapter<LiveClassViewHolder>() {

    companion object{
        const val TYPE_HEADER =0
        const val TYPE_INSTRUCTOR=1
        const val TYPE_PROGRAM=2
        const val TYPE_TODAY=3
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LiveClassViewHolder {
       return when(viewType){
           TYPE_HEADER -> LiveClassViewHolder.HeaderView(LiveHeaderBinding.inflate(LayoutInflater.from(mCtx),parent,false))
           TYPE_INSTRUCTOR ->LiveClassViewHolder.TopInstructorView(TopInstructorLayoutBinding.inflate(LayoutInflater.from(mCtx),parent,false))
           TYPE_PROGRAM ->LiveClassViewHolder.SolutionBasedLiveView(
               SolutionBasedWellnessLayoutBinding.inflate(LayoutInflater.from(mCtx),parent,false))
           TYPE_TODAY ->LiveClassViewHolder.TodayLiveView(TodayLiveLayoutBinding.inflate(LayoutInflater.from(mCtx),parent,false))
           else -> throw IllegalArgumentException("Invalid View")

       }
    }

    override fun onBindViewHolder(holder: LiveClassViewHolder, position: Int) {
        when(holder){
            is LiveClassViewHolder.HeaderView ->holder.bind(mCtx,dataType[0] as LiveClassDataItem.LiveData)
            is LiveClassViewHolder.TopInstructorView -> {
                val dataList = dataType[0] as LiveClassDataItem.LiveData
                holder.bind(mCtx, dataList.topInstructor!!)
            }
            is LiveClassViewHolder.SolutionBasedLiveView ->{
                val dataList = dataType[0] as LiveClassDataItem.LiveData
                holder.bind(mCtx, dataList.programLists!!)
            }
            is LiveClassViewHolder.TodayLiveView ->{
                val dataList = dataType[0] as LiveClassDataItem.LiveData
                holder.bind(mCtx, dataList.todayLiveClass!!)
            }

        }
    }


    override fun getItemViewType(position: Int): Int {
        return when(dataType[position]){
            is LiveClassDataItem.LiveData -> TYPE_HEADER
            is LiveClassDataItem.TopInstructor -> TYPE_INSTRUCTOR
            is LiveClassDataItem.ProgramLists -> TYPE_PROGRAM
            is LiveClassDataItem.TodayLiveClas -> TYPE_TODAY
        }
    }

    override fun getItemCount(): Int = dataType.size
}