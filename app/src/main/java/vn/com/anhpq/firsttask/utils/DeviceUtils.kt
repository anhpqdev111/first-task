package vn.com.anhpq.firsttask.utils

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText

object DeviceUtils {

    fun hideKeyBoard(context: Context, view: View?) {
        if (view == null) return
        if (view is EditText) {
            view.clearFocus()
        }
        val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager?
        imm?.hideSoftInputFromWindow(view.windowToken, 0)
    }
}