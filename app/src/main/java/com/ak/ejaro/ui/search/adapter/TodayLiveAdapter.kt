package consumer.yogpath.wellness.home.liveClass.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ak.ejaro.databinding.TodayItemBinding
import com.ak.ejaro.ui.search.dataModel.LiveClassDataItem
import com.ak.ejaro.utils.ImageLoader.loadByPicasso

class TodayLiveAdapter(private val mCtx:Context,
                       private val dataList:List<LiveClassDataItem.TodayLiveClas>):RecyclerView.Adapter<TodayLiveAdapter.TodayLiveHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodayLiveHolder {
      return TodayLiveHolder(TodayItemBinding.inflate(LayoutInflater.from(mCtx),parent,false))
    }

    override fun onBindViewHolder(holder: TodayLiveHolder, position: Int) {
       // val data = dataList[position]
        holder.binding.thumbnail.loadByPicasso("https://storage.googleapis.com/yogpath_vendor_data/No_Image_Available.jpg")



    }

    override fun getItemCount(): Int = 5

    class TodayLiveHolder(val binding: TodayItemBinding):RecyclerView.ViewHolder(binding.root)
}