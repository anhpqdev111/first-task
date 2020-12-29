package vn.com.anhpq.firsttask.utils

import vn.com.anhpq.firsttask.data.model.Employee
import vn.com.anhpq.firsttask.data.model.Store

object Constant {

    object KeySharedPref {
        const val Store = "KeyStore"
        const val PassKey = "PassKey"
    }

    object KeyBundle {
        const val Employee = "Employee"
    }

    const val NAME_SHARED = "first_task_shared"

    fun getEmployese(): ArrayList<Employee> {
        return arrayListOf(
            Employee("emp001", "a=1Ac1233", "AP", "Anh", Store("store01", "ABV Store", "E600 Simu")),
            Employee("emp002", "b=121aAn3", "TC", "Quan", Store("store01", "ABV Store", "E600 Simu"))
        )
    }
}