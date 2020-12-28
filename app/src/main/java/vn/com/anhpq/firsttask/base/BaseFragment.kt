package vn.com.anhpq.firsttask.base

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

abstract class BaseFragment<VB : ViewDataBinding, VM : ViewModel> : Fragment() {

    // region -> Variables

    private lateinit var binding: VB
    private lateinit var viewModel: VM

    // endregion

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, getLayoutRes(), container, false)
        binding.lifecycleOwner = this

        // ViewModel
        viewModel = ViewModelProvider(this).get(clazz())

        settingDataBinding()
        handleObserver()
        initView()
        initData()
        return binding.root
    }

    abstract fun getLayoutRes(): Int
    abstract fun clazz(): Class<VM>

    open fun settingDataBinding() {
        Log.d(this::class.java.simpleName, "settingDataBinding")
    }

    open fun handleObserver() {
        Log.d(this::class.java.simpleName, "handleObserver")
    }

    open fun initView() {

    }

    open fun initData() {

    }
}