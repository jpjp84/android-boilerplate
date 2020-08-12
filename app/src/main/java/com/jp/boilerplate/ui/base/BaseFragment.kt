package com.jp.boilerplate.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import com.jp.boilerplate.BR

abstract class BaseFragment<VM : ViewModel, VB : ViewDataBinding> : Fragment() {

    protected abstract val viewModel: VM

    @LayoutRes
    abstract fun getViewLayoutRes(): Int

    protected lateinit var viewBinding: VB

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        if (!::viewBinding.isInitialized) {
            viewBinding = DataBindingUtil.inflate(inflater, getViewLayoutRes(), container, false)
            viewBinding.apply {
                this.setVariable(BR.viewModel, viewModel)
                viewBinding.lifecycleOwner = this@BaseFragment
                this.executePendingBindings()
            }
        }

        return viewBinding.root
    }
}