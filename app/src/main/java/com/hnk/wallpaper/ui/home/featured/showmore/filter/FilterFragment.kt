package com.hnk.wallpaper.ui.home.featured.showmore.filter

import android.os.Bundle
import android.view.View
import com.hnk.wallpaper.R
import com.hnk.wallpaper.databinding.FragmentFilterBinding
import com.hnk.wallpaper.ui.base.BaseBindingFragment
import com.hnk.wallpaper.ui.main.MainActivity
import com.hnk.wallpaper.utils.setOnSafeClick

class FilterFragment : BaseBindingFragment<FragmentFilterBinding, FilterVM>() {
    override fun getViewModel(): Class<FilterVM> = FilterVM::class.java

    override fun getLayoutId(): Int = R.layout.fragment_filter

    override fun onCreatedView(view: View?, savedInstanceState: Bundle?) {
        initView()
    }

    private fun initView() {
        with(binding) {
            imBack.setOnSafeClick {
                if (activity is MainActivity) {
                    (activity as MainActivity).navController.popBackStack()
                }
            }
        }

    }
}