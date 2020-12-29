package vn.com.anhpq.firsttask.ui.dialog

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Window
import androidx.databinding.DataBindingUtil
import vn.com.anhpq.firsttask.R
import vn.com.anhpq.firsttask.databinding.DialogInputAddressBinding

class DialogInputAddress(context: Context, private val callBackOnConnet: ((String?) -> Unit)) :
    Dialog(context, R.style.MyDialog) {

    private lateinit var binding: DialogInputAddressBinding

    init {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.dialog_input_address, null, false)
        setContentView(binding.root)
        setCancelable(true)
        initView()
    }

    private fun initView() {
        binding.btnConnect.setOnClickListener {
            callBackOnConnet.invoke(binding.etAddress.text.toString())
        }
    }
}