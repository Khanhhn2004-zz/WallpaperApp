package com.hnk.wallpaper.ui.intro

import android.os.Bundle
import android.view.View
import androidx.viewpager2.widget.ViewPager2
import com.hnk.wallpaper.R
import com.hnk.wallpaper.common.Constant
import com.hnk.wallpaper.data.local.SharedPreferenceHelper
import com.hnk.wallpaper.databinding.FragmentIntroBinding
import com.hnk.wallpaper.ui.adapter.pager.IntroPagerAdapter
import com.hnk.wallpaper.ui.base.BaseBindingFragment

class IntroFragment : BaseBindingFragment<FragmentIntroBinding, IntroVM>() {

    private val introPagerAdapter: IntroPagerAdapter by lazy {
        IntroPagerAdapter()
    }

    override fun getViewModel(): Class<IntroVM> = IntroVM::class.java

    override fun getLayoutId(): Int = R.layout.fragment_intro

    override fun onCreatedView(view: View?, savedInstanceState: Bundle?) {
        initData()
        initView()
        setUpViewPager()
    }

    private fun initData() {
        val introList = resources.getStringArray(R.array.list_intro).toList()
        val titleList = resources.getStringArray(R.array.list_title).toList()

        viewModel.getAllIntro(introList, titleList)
        binding.viewPager2.adapter = introPagerAdapter
        viewModel.listIntro.observe(viewLifecycleOwner) { introList ->
            introPagerAdapter.submitList(introList)
        }
    }

    private fun initView() {
        with(binding) {
            viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    val totalPages = viewPager2.adapter?.itemCount ?: 0
                    if (position == totalPages - 1) {
                        btnGetStarted.text = getString(R.string.get_started)
                    } else {
                        btnGetStarted.text = getString(R.string.next)
                    }
                }
            })
            btnGetStarted.setOnClickListener {
                val currentPosition = viewPager2.currentItem
                val totalPages = viewPager2.adapter?.itemCount ?: 0

                if (currentPosition < totalPages - 1) {
                    viewPager2.setCurrentItem(currentPosition + 1, true)
                } else {
                    SharedPreferenceHelper.storeBoolean(Constant.KEY_SHOW_INTRO, true)
                    navigateFragment(R.id.fragment_permission)
                }
            }
        }
    }

    private fun setUpViewPager() {
        binding.viewPager2.adapter = introPagerAdapter
        binding.dotsIndicator.attachTo(binding.viewPager2)
    }
}
