package vn.com.anhpq.firsttask.utils

import vn.com.anhpq.firsttask.data.model.Employee

object Constant {
    fun getEmployese(): ArrayList<Employee> {
        return arrayListOf(
            Employee("emp001", "a=1Ac1233", "ABC Store"),
            Employee("emp002", "b=121aAn3", "Kim Store"),
            Employee("emp003", "3asjA=qk3", "Abh Store"),
            Employee("emp004", "bca_oask1", "Ncm Store"),
            Employee("emp005", "mkak-hsad", "NCT Store"),
            Employee("emp006", "moqi12bsd", "KCM Store"),
            Employee("emp007", "xzma921_1", "KKA Store"),
            Employee("emp008", "najs=12as", "NCC Store")
        )
    }
}