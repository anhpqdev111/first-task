package vn.com.anhpq.firsttask.data.model

import java.io.Serializable

data class Store(
    var id: String,
    var nameStore: String,
    var department: String
) : Serializable