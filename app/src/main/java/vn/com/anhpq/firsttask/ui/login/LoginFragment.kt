package vn.com.anhpq.firsttask.ui.login

import vn.com.anhpq.firsttask.R
import vn.com.anhpq.firsttask.base.BaseFragment
import vn.com.anhpq.firsttask.databinding.FragmentLoginBinding

class LoginFragment : BaseFragment<FragmentLoginBinding, LoginViewModel>() {

    // region -> Abs BaseFragment

    override fun getLayoutRes(): Int = R.layout.fragment_login

    override fun clazz(): Class<LoginViewModel> = LoginViewModel::class.java

    // endregion



}