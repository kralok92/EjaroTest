package consumer.yogpath.wellness.home.liveClass.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ak.ejaro.databinding.WellnessItemBinding
import com.ak.ejaro.ui.search.dataModel.LiveClassDataItem
import com.ak.ejaro.utils.ImageLoader.loadByPicasso

class ProgramAdapter(private val mCtx:Context,
                     private val dataList:List<LiveClassDataItem.ProgramLists>):RecyclerView.Adapter<ProgramAdapter.ProgramHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProgramHolder {
      return ProgramHolder(WellnessItemBinding.inflate(LayoutInflater.from(mCtx),parent,false))
    }

    override fun onBindViewHolder(holder: ProgramHolder, position: Int) {

      //  val data = dataList.get(position)

        holder.binding.thumbnail.loadByPicasso("https://storage.googleapis.com/yogpath_vendor_data/No_Image_Available.jpg")

    }
    override fun getItemCount(): Int = 5

    class ProgramHolder(val binding: WellnessItemBinding):RecyclerView.ViewHolder(binding.root)
}