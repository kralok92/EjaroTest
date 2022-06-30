package com.ak.ejaro.utils

import android.content.Context
import android.webkit.URLUtil
import android.widget.ImageView
import com.ak.ejaro.R
import com.bumptech.glide.Glide
import com.makeramen.roundedimageview.RoundedImageView
import com.squareup.picasso.Picasso
import java.lang.System.load

object ImageLoader {


    fun ImageView.loadByPicasso( url : String?){
        if (URLUtil.isValidUrl(url)){
            Picasso.get().load(url)
                .placeholder(R.drawable.loading_animation)
                .error(R.drawable.ic_broken_image)
                .into(this)
        }else{
            this.setImageResource(R.drawable.ic_broken_image)
        }
    }
    fun ImageView.loadByGlide(url : String?){
        if (URLUtil.isValidUrl(url)){
            Glide.with(this)
                .load(url)
                .centerCrop()
                .placeholder(R.drawable.loading_animation)
                .error(R.drawable.ic_broken_image)
                .into(this)
        }else{
            this.setImageResource(R.drawable.ic_broken_image)
        }
    }

}