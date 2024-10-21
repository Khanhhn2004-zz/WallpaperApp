package com.hnk.wallpaper.ui.base

import android.os.Bundle
import android.view.View
import com.hnk.wallpaper.R
import com.hnk.wallpaper.common.Constant
import com.hnk.wallpaper.data.local.SharedPreferenceHelper
import com.hnk.wallpaper.databinding.FragmentLanguageBinding
import com.hnk.wallpaper.ui.adapter.recyclerview.LanguageAdapter
import com.hnk.wallpaper.ui.language.LanguageVM
import com.hnk.wallpaper.utils.LanguageUtil.changeLang
import com.hnk.wallpaper.utils.setOnSafeClick
import timber.log.Timber

abstract class BaseLanguageFragment : BaseBindingFragment<FragmentLanguageBinding, LanguageVM>() {
    private val languageAdapter: LanguageAdapter by lazy {
        LanguageAdapter().apply {
            iClickItem = { pos ->
                viewModel.selectItemThreadLanguage(pos)
            }
        }
    }

    override fun getViewModel(): Class<LanguageVM> = LanguageVM::class.java

    override fun getLayoutId(): Int = R.layout.fragment_language

    override fun onCreatedView(view: View?, savedInstanceState: Bundle?) {
        initData()
        initListener()
    }

    protected open fun initListener() {
        binding.tvDone.setOnSafeClick {
            changeLanguage()
            actionDone()
        }
    }

    private fun initData() {
        binding.rclLanguage.adapter = languageAdapter
        viewModel.getAllLanguage()
        viewModel.listLanguage.observe(viewLifecycleOwner) {
            languageAdapter.submitList(it)
        }
    }

    protected open fun actionDone() {}

    private fun changeLanguage() {
        viewModel.checkLanguageSelected()?.let { code ->
            SharedPreferenceHelper.storeString(Constant.KEY_LANGUAGE, code)
            context?.changeLang(code)
            activity?.intent?.also { intent ->
                startActivity(intent)
                activity?.finish()
                intent.putExtra("language_changed", true)
            }
        }
    }

}

