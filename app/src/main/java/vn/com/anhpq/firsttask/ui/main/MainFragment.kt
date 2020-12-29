package vn.com.anhpq.firsttask.ui.main

import android.view.View
import vn.com.anhpq.firsttask.R
import vn.com.anhpq.firsttask.base.BaseFragment
import vn.com.anhpq.firsttask.databinding.FragmentMainBinding

class MainFragment : BaseFragment<FragmentMainBinding, MainViewModel>() {

    override fun getLayoutRes(): Int = R.layout.fragment_main

    override fun clazz(): Class<MainViewModel> = MainViewModel::class.java

    override fun settingDataBinding() {
        super.settingDataBinding()
        binding.controller = this
    }

    override fun handleObserver() {
        super.handleObserver()

    }

    override fun initView() {
        super.initView()
    }

    fun actionOpenMenu(@Suppress("UNUSED_PARAMETER") view: View) {
        if (avoidDuplicateClick()) {
            return
        }
        if (!binding.drawerLayout.isOpen) {
            binding.drawerLayout.open()
        }
    }
}