package com.jp.boilerplate.ui.home

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.switchMap
import androidx.lifecycle.viewModelScope
import com.jp.boilerplate.data.entity.User
import com.jp.boilerplate.data.repository.UserRepository
import com.jp.boilerplate.ui.base.BaseViewModel
import com.orhanobut.logger.Logger
import kotlinx.coroutines.launch


class HomeViewModel @ViewModelInject constructor(
    private val userRepository: UserRepository
) : BaseViewModel() {

    private val _forceUpdateUser = MutableLiveData<Boolean>(false)
    private val _user = _forceUpdateUser.switchMap { forceUpdate ->
        userRepository.getUser(forceUpdate)
    }
    val user: LiveData<User> = _user

    init {
        _forceUpdateUser.value = false
        viewModelScope.launch {
//            userRepository.setUser(User(name = "jp", age = 15))
        }

    }

    fun updateUser() {
//        _forceUpdateUser.value = true
    }

}
