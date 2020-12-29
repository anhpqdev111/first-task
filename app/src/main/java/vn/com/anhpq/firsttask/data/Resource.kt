package vn.com.anhpq.firsttask.data

sealed class Resource<out T: Any> {
    data class Success<out T : Any>(val data: T) : Resource<T>()
    data class Error(val exception: String) : Resource<Nothing>()
}