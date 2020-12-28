package vn.com.anhpq.firsttask.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import vn.com.anhpq.firsttask.dagger.component.AppComponent
import vn.com.anhpq.firsttask.dagger.component.DaggerAppComponent
import vn.com.anhpq.firsttask.ui.login.LoginViewModel

abstract class BaseViewModel : ViewModel() {
    private val injector: AppComponent = DaggerAppComponent
        .builder()
        .build()

    private var isLoading = MutableLiveData<Boolean>()

    init {
        inject()
    }

    /**
     * Injects the required dependencies
     */
    private fun inject() {
        when (this) {
            is LoginViewModel -> injector.inject(this)
        }
    }

    fun showLoading() {
        isLoading.value = true
    }

    fun hideLoading() {
        isLoading.value = false
    }

    override fun onCleared() {
        super.onCleared()
        isLoading.value = null
    }
}