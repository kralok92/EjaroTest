package consumer.yogpath.wellness.home.liveClass.adapter

import android.content.Context
import android.graphics.Point
import android.view.Display
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.WindowManager
import androidx.recyclerview.widget.RecyclerView
import com.ak.ejaro.databinding.TopInstructorItemBinding
import com.ak.ejaro.ui.search.dataModel.LiveClassDataItem
import com.ak.ejaro.utils.ImageLoader.loadByPicasso


class TopInstructorAdapter(private val mCtx:Context,
                           private val dataList:List<LiveClassDataItem.TopInstructor>):RecyclerView.Adapter<TopInstructorAdapter.TopInstructorHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopInstructorHolder {
        val binding = TopInstructorItemBinding.inflate(LayoutInflater.from(mCtx),parent,false)
            binding.root.layoutParams.width = (getScreenWidth() / 3.20).toInt()
        return TopInstructorHolder(binding)
    }

    override fun onBindViewHolder(holder: TopInstructorHolder, position: Int) {

        val data = dataList.get(position)
        holder.binding.ivInstructor.loadByPicasso(data.photo)
        holder.binding.tvUserName.text = data.fullname




    }

    override fun getItemCount(): Int = dataList.size

    class TopInstructorHolder(val binding: TopInstructorItemBinding):RecyclerView.ViewHolder(binding.root)



    fun getScreenWidth(): Int {
        val wm = mCtx.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val display: Display = wm.defaultDisplay
        val size = Point()
        display.getSize(size)
        return size.x
    }
}