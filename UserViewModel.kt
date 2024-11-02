package com.example.lab0312bt02

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class UserViewModel : ViewModel() {

    private val _users = MutableLiveData<List<User>>()
    val users: LiveData<List<User>> get() = _users

    init {
        loadUsers()
    }

    private fun loadUsers() {
        viewModelScope.launch {
            try {
                val userList = ApiClient.apiService.getUsers()
                _users.value = userList
            } catch (e: Exception) {
                // Xử lý lỗi nếu cần
                Log.e("UserViewModel", "Lỗi khi tải dữ liệu người dùng", e)

            }

        }
    }
}