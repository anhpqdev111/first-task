package vn.com.anhpq.firsttask.ui.login

import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import vn.com.anhpq.firsttask.R
import vn.com.anhpq.firsttask.base.BaseFragment
import vn.com.anhpq.firsttask.data.model.Employee
import vn.com.anhpq.firsttask.data.model.Store
import vn.com.anhpq.firsttask.databinding.FragmentLoginBinding
import vn.com.anhpq.firsttask.ui.dialog.DialogInputAddress
import vn.com.anhpq.goal.utils.DeviceUtils

class LoginFragment : BaseFragment<FragmentLoginBinding, LoginViewModel>() {

    // region -> Variables

    private lateinit var mDialogInputAddress: DialogInputAddress
    private var isConnected: Boolean = false

    // endregion

    // region -> Abs BaseFragment

    override fun getLayoutRes(): Int = R.layout.fragment_login

    override fun clazz(): Class<LoginViewModel> = LoginViewModel::class.java

    override fun settingDataBinding() {
        binding.controller = this
    }

    override fun handleObserver() {
        super.handleObserver()
        viewModel.getEmployeeObs().observe(viewLifecycleOwner, Observer {
            if (it == null) {
                Toast.makeText(requireContext(), "Wrong is passkey!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(requireContext(), "Login is successful!", Toast.LENGTH_SHORT).show()
                Handler(Looper.getMainLooper()).postDelayed({
                    navController.navigate(R.id.action_login_to_main)
                }, 1000L)
            }
        })
        viewModel.getStoreObs().observe(viewLifecycleOwner, Observer {
            if (it == null) {
                isConnected = false
                Toast.makeText(requireContext(), "Get data faild", Toast.LENGTH_SHORT).show()
            } else {
                isConnected = true
                mDialogInputAddress.dismiss()
                updateDataEmployee(it)
                updateStatusConnected()
            }
        })
    }

    override fun initView() {
        mDialogInputAddress = DialogInputAddress(requireContext()) {
            if (it.isNullOrEmpty()) {
                Toast.makeText(requireContext(), "Address is empty", Toast.LENGTH_SHORT).show()
            } else {
                DeviceUtils.hideKeyBoard(requireContext(), view)
                viewModel.connectServer(it)
            }
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
//        if (avoidDuplicateClick()) {
//            return
//        }
//        if (!isConnected) {
//            Toast.makeText(requireContext(), "Please connect to the store.", Toast.LENGTH_SHORT).show()
//            return
//        }
//        DeviceUtils.hideKeyBoard(requireContext(), binding.etPasskey)
//        val passKey = binding.etPasskey.text.toString()
//        if (passKey.isEmpty()) {
//            Toast.makeText(requireContext(), "Passkey is not empty", Toast.LENGTH_SHORT).show()
//            binding.etPasskey.requestFocus()
//        } else {
//            viewModel.loginWithPasskey(passKey)
//        }
        viewModel.loginWithPasskey("a=1Ac1233")
    }

    // endregion

    // region -> Other

    private fun updateDataEmployee(store: Store?) {
        if (store == null) {
            binding.nameStore.text = "Kiolyn POS"
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
            binding.btnBrowseMain.text = "disconnect main"
            binding.btnBrowseMain.setBackgroundResource(R.drawable.bg_disconnect_main)
        } else {
            binding.btnBrowseMain.text = "browse main"
            binding.btnBrowseMain.setBackgroundResource(R.drawable.bg_browse_main)
        }
    }

    // endregion
}