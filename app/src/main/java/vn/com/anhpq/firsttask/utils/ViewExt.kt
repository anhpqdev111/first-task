package vn.com.anhpq.firsttask.utils

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

inline fun FragmentManager.trans(func: FragmentTransaction.() -> FragmentTransaction) {
    beginTransaction().func().commit()
}

fun FragmentActivity.replace(fragment: Fragment, container: Int) {
    supportFragmentManager.trans { replace(container, fragment) }
}