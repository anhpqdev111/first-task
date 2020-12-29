package vn.com.anhpq.firsttask.base

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.findNavController
import vn.com.anhpq.firsttask.ui.FirstTaskActivity
import vn.com.anhpq.firsttask.utils.SharedPrefsUtils

abstract class BaseFragment<VB : ViewDataBinding, VM : BaseViewModel> : Fragment() {

    companion object {
        private var onTimeClickItem: Long = System.currentTimeMillis()
    }
    // region -> Variables

    protected lateinit var binding: VB
    protected lateinit var viewModel: VM
    protected lateinit var navController: NavController
    protected lateinit var sharedPrefs: SharedPrefsUtils
    // endregion

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, getLayoutRes(), container, false)
        binding.lifecycleOwner = this

        // ViewModel
        viewModel = ViewModelProvider(this).get(clazz())
        sharedPrefs = SharedPrefsUtils(requireContext())
        settingDataBinding()
        handleObserver()
        initView()
        initData()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // NavController
        navController = view.findNavController()
    }

    abstract fun getLayoutRes(): Int
    abstract fun clazz(): Class<VM>

    open fun settingDataBinding() {
        Log.d(this::class.java.simpleName, "settingDataBinding")
    }

    open fun handleObserver() {
        Log.d(this::class.java.simpleName, "handleObserver")
        viewModel.getIsLoadingObs().observe(viewLifecycleOwner, Observer { isLoading ->
            if (activity is FirstTaskActivity) {
                if (isLoading) {
                    (activity as FirstTaskActivity).showProgress()
                } else {
                    (activity as FirstTaskActivity).hideProgress()
                }
            }

        })
    }

    open fun initView() {

    }

    open fun initData() {

    }

    protected fun avoidDuplicateClick(): Boolean {
        val now = System.currentTimeMillis()
        if (now - onTimeClickItem < 400L) {
            return true
        }
        onTimeClickItem = now
        return false
    }
}