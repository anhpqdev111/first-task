package vn.com.anhpq.firsttask.ui.area

import vn.com.anhpq.firsttask.R
import vn.com.anhpq.firsttask.base.BaseFragment
import vn.com.anhpq.firsttask.databinding.FragmentAreaBinding
import vn.com.anhpq.firsttask.ui.ExampleViewModel

class AreaFragment : BaseFragment<FragmentAreaBinding, ExampleViewModel>() {
    override fun getLayoutRes(): Int = R.layout.fragment_area

    override fun clazz(): Class<ExampleViewModel> = ExampleViewModel::class.java
}