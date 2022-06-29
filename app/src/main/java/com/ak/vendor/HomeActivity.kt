package com.ak.vendor

import android.annotation.SuppressLint
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.ak.vendor.NetworkUtils.Coroutine.Resource
import com.ak.vendor.adapter.HomeAdapter
import com.ak.vendor.dataModel.*
import com.ak.vendor.databinding.ActivityHomeBinding
import com.ak.vendor.utils.ProgressDialogUtil
import com.ak.vendor.utils.SnackBuilder
import com.ak.vendor.viewModels.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint





@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {
    private lateinit var binding : ActivityHomeBinding
    private val viewModel : HomeViewModel by viewModels()
    private lateinit var homeAdapter: HomeAdapter
    private lateinit var mCtx : Context
    private var dataTypeList = ArrayList<Any>()
    private var dataList = ArrayList<Data>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mCtx = this
        init()
        setupObserver()
    }


    private fun init() {
        /**
         * initilization dashboard adapter
         */

        binding.rvHome.layoutManager = LinearLayoutManager(mCtx,
            LinearLayoutManager.VERTICAL,false)
        binding.rvHome.isNestedScrollingEnabled = false
        homeAdapter = HomeAdapter(mCtx,dataTypeList,dataList)
        binding.rvHome.adapter = homeAdapter

    }

    @SuppressLint("NotifyDataSetChanged")
    private fun setupObserver() {
        viewModel.homeListItemsLiveData.observe(this , Observer {
            when(it) {

                is Resource.Loading -> {
                    ProgressDialogUtil.show(mCtx)
                }
                is Resource.Error -> {
                    ProgressDialogUtil.hideLoading()
                    SnackBuilder.Builder()
                        .setMessage(it.errorMessage!!)
                        .setBackgroundTpye(1)
                        .build()
                        .show(mCtx)
                }
                is Resource.Success -> {
                    ProgressDialogUtil.hideLoading()
                    dataTypeList.clear()
                    dataList.clear()

                    it.data?.let {
                        if (it.status!!){
                            it.data?.let {
                                dataList.add(it)
                                if (it.bannerDetails?.size!! > 0) {
                                    dataTypeList.add(BannerDetail())
                                }

                                if (it.expertVideos?.size!! > 0){
                                    dataTypeList.add(ExpertVideo())
                                }

                                if (it.category?.size!! > 0){
                                    dataTypeList.add(Category())

                                }

                                if (it.liveYogaClasses?.size!! > 0){
                                    dataTypeList.add(LiveYogaClasse())
                                }

                                if (it.yogaPosesVideo?.size!! > 0){
                                    dataTypeList.add(YogaPosesVideo())

                                }

                                if (it.professionals?.size!! > 0){
                                    dataTypeList.add(Professional())

                                }

                                /**
                                 * notify dashboard adapter
                                 */
                                homeAdapter.notifyDataSetChanged()

                            }
                        }else{
                            SnackBuilder.Builder()
                                .setMessage(it.message!!)
                                .setBackgroundTpye(3)
                                .build()
                                .show(mCtx)

                        }
                    }
                }

            }




        })

    }

}