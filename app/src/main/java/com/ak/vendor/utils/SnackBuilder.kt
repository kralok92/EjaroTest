package com.ak.vendor.utils


import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup.MarginLayoutParams
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.ViewCompat
import com.ak.vendor.R
import com.google.android.material.snackbar.Snackbar

class SnackBuilder(val message : String? ,val type : Int?) {


    private val LENGTH_INDEFINITE = -2
    private val LENGTH_SHORT = -1
    private val LENGTH_LONG = 0
     class Builder(var message : String?=null,
                   var type : Int?=null){

         fun setMessage(messsage : String) = apply { this.message=messsage }
         fun setBackgroundTpye(type : Int) = apply { this.type = type }
         fun build() = SnackBuilder(message,type)
     }

    fun show(mCtx : Context){
       try {
           val snackbar = Snackbar.make((mCtx as Activity).window.decorView.findViewById(android.R.id.content),
               message.toString(),
               LENGTH_LONG
           )
           configSnackbar(snackbar)
           val sbView: View = snackbar.getView()
           val textView = sbView.findViewById<TextView>(com.google.android.material.R.id.snackbar_text)
           textView.setTextColor(mCtx.resources.getColor(R.color.white))
           snackbar.setActionTextColor(mCtx.resources.getColor(R.color.white))
           setRoundBordersBg(mCtx, snackbar, type!!)
           snackbar.show()
       }catch (ex:Exception){
           Toast(mCtx).also {
               LayoutInflater.from(mCtx).inflate(R.layout.custom_toast, null).apply {
                   it.view = this
               }.findViewById<TextView>(R.id.tvMessage).text = message
               it.duration = Toast.LENGTH_LONG
           }.show()
       }

    }

    private fun configSnackbar(snack: Snackbar) {
        addMargins(snack)
        ViewCompat.setElevation(snack.view, 6f)
    }

    private fun addMargins(snack: Snackbar) {
        val params = snack.view.layoutParams as MarginLayoutParams
        params.setMargins(12, 12, 12, 12)
        snack.view.layoutParams = params
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private fun setRoundBordersBg(context: Context, snackbar: Snackbar, type: Int) {
        if (type == 1) snackbar.view.background = context.resources.getDrawable(R.drawable.snack_bg_red,null)
        if (type == 2) snackbar.view.background = context.resources.getDrawable(R.drawable.snack_bg_green,null)
        if (type == 3) snackbar.view.background = context.resources.getDrawable(R.drawable.snack_bg,null)
    }
}