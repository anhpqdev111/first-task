package vn.com.anhpq.firsttask.ui.main

import android.view.View
import android.widget.Toast
import androidx.activity.addCallback
import vn.com.anhpq.firsttask.R
import vn.com.anhpq.firsttask.base.BaseFragment
import vn.com.anhpq.firsttask.data.model.Employee
import vn.com.anhpq.firsttask.databinding.FragmentMainBinding
import vn.com.anhpq.firsttask.ui.area.AreaFragment
import vn.com.anhpq.firsttask.ui.home.HomeFragment
import vn.com.anhpq.firsttask.ui.setting.SettingFragment
import vn.com.anhpq.firsttask.utils.Constant
import vn.com.anhpq.firsttask.utils.replace

class MainFragment : BaseFragment<FragmentMainBinding, MainViewModel>() {

    override fun getLayoutRes(): Int = R.layout.fragment_main
    private var employee: Employee? = null
    private val homeFragment = HomeFragment()
    private val areaFragment = AreaFragment()
    private val settingFragment = SettingFragment()

    override fun clazz(): Class<MainViewModel> = MainViewModel::class.java

    override fun settingDataBinding() {
        super.settingDataBinding()
        employee = requireArguments().getSerializable(Constant.KeyBundle.Employee) as? Employee
        if (employee == null) {
            requireActivity().finish()
        }
        binding.data = employee
        binding.controller = this
    }

    override fun initView() {
        super.initView()
        requireActivity().replace(homeFragment, binding.layoutMain.id)
        setTitleToolbar(getString(R.string.title_home))
    }

    // region -> Actions

    fun actionOpenMenu(@Suppress("UNUSED_PARAMETER") view: View) {
        if (avoidDuplicateClick()) {
            return
        }
        if (!binding.drawerLayout.isOpen) {
            binding.drawerLayout.open()
        }
    }

    fun actionOpenHome(@Suppress("UNUSED_PARAMETER") view: View) {
        if (avoidDuplicateClick()) {
            return
        }
        if (binding.drawerLayout.isOpen) {
            binding.drawerLayout.close()
        }
        requireActivity().replace(homeFragment, binding.layoutMain.id)
        setTitleToolbar(getString(R.string.title_home))
        Toast.makeText(requireContext(), getString(R.string.title_home), Toast.LENGTH_SHORT).show()
    }

    fun actionOpenAreas(@Suppress("UNUSED_PARAMETER") view: View) {
        if (avoidDuplicateClick()) {
            return
        }
        if (binding.drawerLayout.isOpen) {
            binding.drawerLayout.close()
        }
        requireActivity().replace(areaFragment, binding.layoutMain.id)
        setTitleToolbar(getString(R.string.title_ares))
        Toast.makeText(requireContext(), getString(R.string.title_ares), Toast.LENGTH_SHORT).show()
    }

    fun actionOpenSetting(@Suppress("UNUSED_PARAMETER") view: View) {
        if (avoidDuplicateClick()) {
            return
        }
        if (binding.drawerLayout.isOpen) {
            binding.drawerLayout.close()
        }
        requireActivity().replace(settingFragment, binding.layoutMain.id)
        setTitleToolbar(getString(R.string.title_settings))
        Toast.makeText(requireContext(), getString(R.string.title_settings), Toast.LENGTH_SHORT).show()
    }

    fun actionLogout(@Suppress("UNUSED_PARAMETER") view: View) {
        if (avoidDuplicateClick()) {
            return
        }
        if (binding.drawerLayout.isOpen) {
            binding.drawerLayout.close()
        }
        sharedPrefs.clearString(Constant.KeySharedPref.Store)
        sharedPrefs.clearString(Constant.KeySharedPref.PassKey)
        Toast.makeText(requireContext(), getString(R.string.title_logout), Toast.LENGTH_SHORT).show()
        activity?.onBackPressed()
    }

    // endregion

    // region -> Other

    private fun setTitleToolbar(title: String) {
        binding.tvTitle.text = title
    }

    // endregion
}