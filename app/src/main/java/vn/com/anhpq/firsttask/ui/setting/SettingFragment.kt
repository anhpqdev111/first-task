package vn.com.anhpq.firsttask.ui.setting

import vn.com.anhpq.firsttask.R
import vn.com.anhpq.firsttask.base.BaseFragment
import vn.com.anhpq.firsttask.databinding.FragmentSettingBinding
import vn.com.anhpq.firsttask.ui.ExampleViewModel

class SettingFragment : BaseFragment<FragmentSettingBinding, ExampleViewModel>() {
    override fun getLayoutRes(): Int = R.layout.fragment_setting

    override fun clazz(): Class<ExampleViewModel> = ExampleViewModel::class.java
}