package vn.com.anhpq.firsttask.utils

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences

class SharedPrefsUtils(private val context: Context) {

    private var sharedPreferences: SharedPreferences = context.getSharedPreferences(Constant.NAME_SHARED, MODE_PRIVATE)

    fun putString(key: String, value: String) {
        sharedPreferences.edit().putString(key, value).apply()
    }

    fun getString(key: String): String? {
        return sharedPreferences.getString(key, null)
    }

    fun clearString(key: String) {
        sharedPreferences.edit().putString(key, null).apply()
    }
}