package com.ak.vendor

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.ak.vendor.adapter.HomeAdapter
import com.ak.vendor.adapter.HomeNewAdapter
import com.ak.vendor.dataModel.Data
import com.ak.vendor.databinding.ActivityHomeBinding
import com.ak.vendor.databinding.ActivityHomeNewBinding
import com.ak.vendor.viewModels.HomeViewModel

class HomeNewActivity : AppCompatActivity() {
    private lateinit var binding : ActivityHomeNewBinding
    private lateinit var homeAdapter: HomeNewAdapter
    private lateinit var mCtx : Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeNewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mCtx = this
        init()
    }
    private fun init() {

        binding.rvHomenew.layoutManager = LinearLayoutManager(mCtx,
            LinearLayoutManager.VERTICAL,false)
        binding.rvHomenew.isNestedScrollingEnabled = false
        homeAdapter = HomeNewAdapter()
        binding.rvHomenew.adapter = homeAdapter

    }

}