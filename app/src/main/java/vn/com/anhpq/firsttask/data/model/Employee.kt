package vn.com.anhpq.firsttask.data.model

import java.io.Serializable

data class Employee(
    var id: String,
    var passkey: String,
    var firstName: String,
    var lastName: String,
    var store: Store
) : Serializable