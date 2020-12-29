package vn.com.anhpq.firsttask.ui

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import vn.com.anhpq.firsttask.R
import vn.com.anhpq.firsttask.ui.dialog.MyProgressDialog

class FirstTaskActivity : AppCompatActivity() {

    private lateinit var mProgressDialog: MyProgressDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mProgressDialog = MyProgressDialog(this)
    }

    fun showProgress() {
        if (!mProgressDialog.isShowing) {
            mProgressDialog.show()
        }
    }

    fun hideProgress() {
        if (mProgressDialog.isShowing) {
            mProgressDialog.dismiss()
        }
    }
}