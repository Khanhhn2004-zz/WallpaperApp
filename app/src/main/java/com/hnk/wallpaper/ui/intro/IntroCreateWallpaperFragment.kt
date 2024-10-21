package com.hnk.wallpaper.ui.intro

import android.os.Bundle
import android.view.View
import com.hnk.wallpaper.R
import com.hnk.wallpaper.common.Constant
import com.hnk.wallpaper.data.local.SharedPreferenceHelper
import com.hnk.wallpaper.databinding.FragmentIntroCreateWallpaperBinding
import com.hnk.wallpaper.ui.adapter.pager.IntroCreateWallpaperPagerAdapter
import com.hnk.wallpaper.ui.base.BaseBindingFragment
import com.hnk.wallpaper.utils.setOnSafeClick

class IntroCreateWallpaperFragment :
    BaseBindingFragment<FragmentIntroCreateWallpaperBinding, IntroCreateWallppaperVM>() {
    private val introCreateWallpaperPagerAdapter: IntroCreateWallpaperPagerAdapter by lazy {
        IntroCreateWallpaperPagerAdapter()
    }

    override fun getViewModel(): Class<IntroCreateWallppaperVM> =
        IntroCreateWallppaperVM::class.java

    override fun getLayoutId(): Int = R.layout.fragment_intro_create_wallpaper

    override fun onCreatedView(view: View?, savedInstanceState: Bundle?) {
        initData()
        initView()
        setUpViewPager()
    }


    private fun initData() {
        viewModel.getAllIntro()
        binding.viewPager2.adapter = introCreateWallpaperPagerAdapter
        viewModel.listIntro.observe(viewLifecycleOwner) { introList ->
            introCreateWallpaperPagerAdapter.submitList(introList)
        }
    }

    private fun initView() {
        with(binding) {
            tvNext.setOnClickListener {
                val currentPosition = viewPager2.currentItem
                val totalPages = viewPager2.adapter?.itemCount ?: 0

                if (currentPosition < totalPages - 1) {
                    viewPager2.setCurrentItem(currentPosition + 1, true)
                } else {
                    navigateFragment(R.id.fragment_permission)
                    SharedPreferenceHelper.storeBoolean(Constant.KEY_SHOW_INTRO_CREATIVE,true)
                }
            }
            tvSkip.setOnSafeClick {
            }
        }
    }

    private fun setUpViewPager() {
        binding.viewPager2.adapter = introCreateWallpaperPagerAdapter
        binding.dotsIndicator.attachTo(binding.viewPager2)
    }
}