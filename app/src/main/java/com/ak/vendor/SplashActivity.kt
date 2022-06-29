package com.ak.vendor

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ak.vendor.adapter.HomeNewAdapter
import com.ak.vendor.databinding.ActivityHomeBinding
import com.ak.vendor.databinding.ActivityHomeNewBinding
import com.ak.vendor.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {
    private lateinit var binding : ActivitySplashBinding
    private lateinit var mCtx : Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mCtx = this

        binding.type1.setOnClickListener{
            val intent = Intent(mCtx, HomeActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
        }

        binding.type2.setOnClickListener{
            val intent = Intent(mCtx, HomeNewActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
        }
    }
}