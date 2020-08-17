package com.jp.boilerplate.ui.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.jp.boilerplate.R
import com.jp.boilerplate.data.meta.Result
import com.jp.boilerplate.databinding.ActivityMainBinding
import com.jp.boilerplate.ui.base.BaseFragment
import com.orhanobut.logger.Logger
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<HomeViewModel, ActivityMainBinding>() {

    override val viewModel by viewModels<HomeViewModel>()

    override fun getViewLayoutRes() = R.layout.fragment_home

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setNavigation()
    }

    private fun setNavigation() {
        viewModel.user.observe(this.viewLifecycleOwner, Observer {
            Logger.d("Updated User : $it")
        })

        viewModel.dataLoading.observe(this.viewLifecycleOwner, Observer {
            when (it.status) {
                Result.Status.LOADING -> {
                    Logger.d("Loading...")
                }
                else -> {
                    Logger.d("Loading finish!")
                }
            }
        })
    }
}
