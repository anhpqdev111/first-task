package vn.com.anhpq.firsttask.ui.home

import vn.com.anhpq.firsttask.R
import vn.com.anhpq.firsttask.base.BaseFragment
import vn.com.anhpq.firsttask.databinding.FragmentHomeBinding
import vn.com.anhpq.firsttask.ui.ExampleViewModel

class HomeFragment : BaseFragment<FragmentHomeBinding, ExampleViewModel>() {

    override fun getLayoutRes(): Int = R.layout.fragment_home

    override fun clazz(): Class<ExampleViewModel> = ExampleViewModel::class.java
}