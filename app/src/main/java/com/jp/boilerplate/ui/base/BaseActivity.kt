package com.jp.boilerplate.ui.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import com.jp.boilerplate.BR

abstract class BaseActivity<VM : ViewModel, VB : ViewDataBinding> : AppCompatActivity() {

    protected abstract val viewModel: VM

    @LayoutRes
    abstract fun getViewLayoutRes(): Int

    protected lateinit var viewBinding: VB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewBinding = DataBindingUtil.setContentView(this, getViewLayoutRes())
        viewBinding.apply {
            this.setVariable(BR.viewModel, viewModel)
            viewBinding.lifecycleOwner = this.lifecycleOwner
            this.executePendingBindings()
        }
    }
}