package vn.com.anhpq.firsttask.ui.login

import android.os.Handler
import android.os.Looper
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import vn.com.anhpq.firsttask.base.BaseViewModel
import vn.com.anhpq.firsttask.data.model.Employee
import vn.com.anhpq.firsttask.data.model.Store
import vn.com.anhpq.firsttask.utils.Constant

class LoginViewModel : BaseViewModel() {

    private var mStore = MutableLiveData<Store?>()
    private var mEmployeeRs = MutableLiveData<Employee?>()

    fun connectServer(url: String) {
        showLoading()
        viewModelScope.launch {
            Handler(Looper.getMainLooper()).postDelayed({
                hideLoading()
                if (url.contains("http://") || url.contains("https://")) {
                    mStore.value = Store("store001", "ABC Store", "E600 Simu")
                } else {
                    mStore.value = null
                }
            }, 3000L)
        }
    }

    fun loginWithPasskey(passkey: String) {
        showLoading()
        viewModelScope.launch {
            Handler(Looper.getMainLooper()).postDelayed({
                hideLoading()
                val data = Constant.getEmployese().filter { it.passkey == passkey }
                if (data.isEmpty()) {
                    mEmployeeRs.value = null
                } else {
                    mEmployeeRs.value = data[0]
                }
            }, 2000L)
        }
    }

    fun getEmployeeObs(): MutableLiveData<Employee?> {
        return mEmployeeRs
    }

    fun getStoreObs(): MutableLiveData<Store?> {
        return mStore
    }
}