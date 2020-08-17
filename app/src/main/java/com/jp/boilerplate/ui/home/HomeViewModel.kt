package com.jp.boilerplate.ui.home

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.switchMap
import com.jp.boilerplate.data.entity.User
import com.jp.boilerplate.data.meta.Result
import com.jp.boilerplate.data.repository.UserRepository
import com.jp.boilerplate.ui.base.BaseViewModel


class HomeViewModel @ViewModelInject constructor(
    private val userRepository: UserRepository
) : BaseViewModel() {

    private val _forceUpdateUser = MutableLiveData<Boolean>(false)
    private val _dataLoading = _forceUpdateUser.switchMap { userRepository.refreshUser(it) }
    val dataLoading: LiveData<Result<Void>> = _dataLoading

    private val _user = userRepository.observable()
    val user: LiveData<User> = _user

    init {
        _forceUpdateUser.value = true
    }
}
