package com.ak.vendor.utils
import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.Window
import com.ak.vendor.R


object ProgressDialogUtil {

    var dialog: Dialog? = null
    fun show(context: Context?) {
        dialog = Dialog(context!!)
        dialog!!.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog!!.setContentView(R.layout.layout_dialog_utils)
        dialog!!.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog!!.setCancelable(false)
        try {
            dialog!!.show()
        } catch (e: Exception) {
        }
    }

    fun hideLoading() {
        try {
            if (dialog != null) {
                dialog!!.dismiss()
            }
        } catch (e: Exception) {
        }
    }

}