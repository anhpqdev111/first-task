package vn.com.anhpq.firsttask.ui.login

import android.os.Handler
import android.os.Looper
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import vn.com.anhpq.firsttask.base.BaseViewModel
import vn.com.anhpq.firsttask.data.Resource
import vn.com.anhpq.firsttask.data.model.Employee
import vn.com.anhpq.firsttask.data.model.Store
import vn.com.anhpq.firsttask.utils.Constant

class LoginViewModel : BaseViewModel() {

    private var mStore = MutableLiveData<Resource<Store>>()
    private var mEmployeeRs = MutableLiveData<Resource<Employee>>()

    fun connectServer(url: String) {
        showLoading()
        viewModelScope.launch {
            Handler(Looper.getMainLooper()).postDelayed({
                hideLoading()
                if (url.contains("http://") || url.contains("https://")) {
                    mStore.value = Resource.Success(Store("store001", "ABC Store", "E600 Simu"))
                } else {
                    mStore.value = Resource.Error("Connect store faild!")
                }
            }, 1000L)
        }
    }

    fun loginWithPasskey(passkey: String) {
        showLoading()
        viewModelScope.launch {
            Handler(Looper.getMainLooper()).postDelayed({
                hideLoading()
                val data = Constant.getEmployese().filter { it.passkey == passkey }
                if (data.isEmpty()) {
                    mEmployeeRs.value = Resource.Error("Wrong is passkey!")
                } else {
                    mEmployeeRs.value = Resource.Success(data[0])
                }
            }, 1000L)
        }
    }

    fun getEmployeeObs(): MutableLiveData<Resource<Employee>> {
        return mEmployeeRs
    }

    fun getStoreObs(): MutableLiveData<Resource<Store>> {
        return mStore
    }

    fun clearLiveData() {
        mStore.postValue(null)
        mEmployeeRs.postValue(null)
    }
}