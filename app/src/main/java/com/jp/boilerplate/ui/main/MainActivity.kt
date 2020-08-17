package com.jp.boilerplate.ui.main

import android.os.Bundle
import androidx.activity.viewModels
import com.jp.boilerplate.R
import com.jp.boilerplate.databinding.ActivityMainBinding
import com.jp.boilerplate.ui.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<MainViewModel, ActivityMainBinding>() {

    override val viewModel by viewModels<MainViewModel>()

    override fun getViewLayoutRes() = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.updateUser()
    }
}
