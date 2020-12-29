package vn.com.anhpq.firsttask.ui.dialog

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Window
import vn.com.anhpq.firsttask.R

class MyProgressDialog(context: Context) : Dialog(context, R.style.MyDialog) {

    init {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.my_dialog_progress)
        setCancelable(false)
    }
}