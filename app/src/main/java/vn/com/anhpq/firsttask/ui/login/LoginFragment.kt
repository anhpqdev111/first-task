package vn.com.anhpq.firsttask.ui.login

import android.view.View
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import vn.com.anhpq.firsttask.R
import vn.com.anhpq.firsttask.base.BaseFragment
import vn.com.anhpq.firsttask.data.Resource
import vn.com.anhpq.firsttask.data.model.Store
import vn.com.anhpq.firsttask.databinding.FragmentLoginBinding
import vn.com.anhpq.firsttask.ui.dialog.DialogInputAddress
import vn.com.anhpq.firsttask.utils.Constant
import vn.com.anhpq.firsttask.utils.DeviceUtils

class LoginFragment : BaseFragment<FragmentLoginBinding, LoginViewModel>() {

    // region -> Variables

    private lateinit var mDialogInputAddress: DialogInputAddress
    private var isConnected: Boolean = false
    private var store: String = ""
    private var passKey: String = ""

    // endregion

    // region -> Abs BaseFragment

    override fun getLayoutRes(): Int = R.layout.fragment_login

    override fun clazz(): Class<LoginViewModel> = LoginViewModel::class.java

    override fun settingDataBinding() {
        binding.controller = this
    }

    override fun handleObserver() {
        super.handleObserver()
        viewModel.getEmployeeObs().observe(this, Observer {
            when (it) {
                is Resource.Success -> {
                    viewModel.clearLiveData()
                    Toast.makeText(requireContext(), getString(R.string.login_success), Toast.LENGTH_SHORT).show()

                    sharedPrefs.putString(Constant.KeySharedPref.Store, store)
                    sharedPrefs.putString(Constant.KeySharedPref.PassKey, passKey)
                    navController.navigate(
                        R.id.action_login_to_main,
                        bundleOf(
                            Constant.KeyBundle.Employee to it.data
                        )
                    )
                }
                is Resource.Error -> {
                    Toast.makeText(requireContext(), it.exception, Toast.LENGTH_SHORT).show()
                }
            }
        })
        viewModel.getStoreObs().observe(this, Observer {
            when (it) {
                is Resource.Success -> {
                    isConnected = true
                    mDialogInputAddress.dismiss()
                    updateDataEmployee(it.data)
                    updateStatusConnected()
                    if (passKey.isNotEmpty()) {
                        viewModel.loginWithPasskey(passKey)
                    }
                }
                is Resource.Error -> {
                    isConnected = false
                    Toast.makeText(requireContext(), it.exception, Toast.LENGTH_SHORT).show()
                }
            }
        })
    }

    override fun initView() {
        mDialogInputAddress = DialogInputAddress(requireContext()) {
            if (it.isNullOrEmpty()) {
                Toast.makeText(requireContext(), getString(R.string.address_empty), Toast.LENGTH_SHORT).show()
            } else {
                DeviceUtils.hideKeyBoard(requireContext(), view)
                store = it
                viewModel.connectServer(it)
            }
        }
    }

    override fun initData() {
        super.initData()
        store = sharedPrefs.getString(Constant.KeySharedPref.Store) ?: ""
        passKey = sharedPrefs.getString(Constant.KeySharedPref.PassKey) ?: ""
        if (store.isNotEmpty()) {
            viewModel.connectServer(store)
        }
    }

    // endregion

    // region -> Actions

    fun actionBrowseMain(@Suppress("UNUSED_PARAMETER") view: View) {
        if (avoidDuplicateClick()) {
            return
        }
        DeviceUtils.hideKeyBoard(requireContext(), binding.etPasskey)
        if (isConnected) {
            isConnected = false
            updateStatusConnected()
            updateDataEmployee(null)
        } else {
            if (!mDialogInputAddress.isShowing) {
                mDialogInputAddress.show()
            }
        }
    }

    fun actionLogin(@Suppress("UNUSED_PARAMETER") view: View) {
        if (avoidDuplicateClick()) {
            return
        }
        if (!isConnected) {
            Toast.makeText(requireContext(), getString(R.string.connect_to_store), Toast.LENGTH_SHORT).show()
            return
        }
        DeviceUtils.hideKeyBoard(requireContext(), binding.etPasskey)
        passKey = binding.etPasskey.text.toString()
        if (passKey.isEmpty()) {
            Toast.makeText(requireContext(), getString(R.string.passkey_empty), Toast.LENGTH_SHORT).show()
            binding.etPasskey.requestFocus()
        } else {
            viewModel.loginWithPasskey(passKey)
        }
    }

    // endregion

    // region -> Other

    private fun updateDataEmployee(store: Store?) {
        if (store == null) {
            binding.nameStore.text = getString(R.string.kiolyn_pos)
            binding.nameEmployee.text = ""
            binding.nameEmployee.visibility = View.GONE
        } else {
            binding.nameStore.text = store.nameStore
            binding.nameEmployee.text = store.department
            binding.nameEmployee.visibility = View.VISIBLE
        }
    }

    private fun updateStatusConnected() {
        if (isConnected) {
            binding.btnBrowseMain.text = getString(R.string.disconnect_main)
            binding.btnBrowseMain.setBackgroundResource(R.drawable.bg_disconnect_main)
        } else {
            binding.btnBrowseMain.text = getString(R.string.browse_main)
            binding.btnBrowseMain.setBackgroundResource(R.drawable.bg_browse_main)
        }
    }

    // endregion
}