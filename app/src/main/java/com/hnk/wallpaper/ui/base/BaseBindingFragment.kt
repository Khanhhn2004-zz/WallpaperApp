package com.hnk.wallpaper.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.hnk.wallpaper.ui.main.MainActivity
import com.hnk.wallpaper.ui.main.MainVM
import timber.log.Timber

abstract class BaseBindingFragment<B : ViewDataBinding, T : BaseViewModel> : BaseFragment() {
    lateinit var binding: B
    lateinit var viewModel: T

    lateinit var mainViewModel: MainVM

    var toast: Toast? = null

    protected abstract fun getViewModel(): Class<T>

    abstract fun getLayoutId(): Int

    protected abstract fun onCreatedView(view: View?, savedInstanceState: Bundle?)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[getViewModel()]
        activity?.let { mainViewModel = ViewModelProvider(it)[MainVM::class.java] }
        onCreatedView(view, savedInstanceState)
    }

    fun showToast(content: String?) {
        Timber.e("khanh  content: ")
        toast?.cancel()
        toast = Toast.makeText(context, content, Toast.LENGTH_SHORT)
        toast?.show()
    }

    protected fun navigateFragment(id: Int, bundle: Bundle? = null) {
        (activity as? MainActivity)?.navController?.let { nav ->
            if (bundle == null) {
                nav.navigate(id)
            } else {
                nav.navigate(id, bundle)
            }
        }
    }

    protected fun popBackStack() {
        (activity as? MainActivity)?.navController?.popBackStack()
    }
}