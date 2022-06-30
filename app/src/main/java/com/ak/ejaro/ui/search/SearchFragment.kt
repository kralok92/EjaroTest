package com.ak.ejaro.ui.search

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.ak.ejaro.databinding.FragmentSearchBinding
import com.ak.ejaro.ui.search.dataModel.LiveClassDataItem
import com.ak.ejaro.ui.search.viewModel.LiveclassViewModel
import consumer.yogpath.wellness.home.liveClass.adapter.LiveClassAdapter
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class SearchFragment : Fragment() {

    val viewModel : LiveclassViewModel by viewModels()
    private lateinit var binding : FragmentSearchBinding
    private lateinit var adapterLive: LiveClassAdapter
    private lateinit var mCtx : Context
    private var typeList = ArrayList<LiveClassDataItem>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mCtx = requireActivity()
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentSearchBinding.inflate(inflater, container, false)
        init()
        fetchAndObserveData()
        return binding.root
    }



    private fun init() {
        /**
         * initilization  adapter
         */

        binding.rvSearch.layoutManager = LinearLayoutManager(mCtx,
            LinearLayoutManager.VERTICAL,false)
        binding.rvSearch.isNestedScrollingEnabled = false
        adapterLive = LiveClassAdapter(mCtx,typeList)
        binding.rvSearch.adapter = adapterLive

    }

    @SuppressLint("NotifyDataSetChanged")
    private fun fetchAndObserveData(){

        /**
         * fetch live data
         */

        viewModel.fetchLivedata(mCtx)
        viewModel.liveData.observe(viewLifecycleOwner, Observer {
            val data = it as LiveClassDataItem.LiveData
            typeList.add(data)
            if (data.topInstructor?.size!! > 0) {
                typeList.add(data.topInstructor[0])
            }
            if (data.programLists?.size!! > 0) {
                typeList.add(data.programLists[0])
            }
            if (data.todayLiveClass?.size!! > 0) {
                typeList.add(data.todayLiveClass[0])
            }
            adapterLive.notifyDataSetChanged()
        })
    }
}