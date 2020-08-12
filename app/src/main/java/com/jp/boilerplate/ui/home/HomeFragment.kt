package com.jp.boilerplate.ui.home

import android.os.Bundle
import androidx.fragment.app.viewModels
import com.jp.boilerplate.ui.base.BaseFragment
import com.jp.boilerplate.R
import com.jp.boilerplate.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<HomeViewModel, ActivityMainBinding>() {

    override val viewModel by viewModels<HomeViewModel>()

    override fun getViewLayoutRes() = R.layout.fragment_home

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.updateUser()
    }
}
