package com.hnk.wallpaper.ui.home

import android.os.Bundle
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.viewpager2.widget.ViewPager2
import com.hnk.wallpaper.R
import com.hnk.wallpaper.common.Constant
import com.hnk.wallpaper.databinding.FragmentHomeBinding
import com.hnk.wallpaper.ui.adapter.pager.HomeViewPagerAdapter
import com.hnk.wallpaper.ui.base.BaseBindingFragment
import com.hnk.wallpaper.ui.dialog.RateUsInAppDialog
import com.hnk.wallpaper.utils.gone
import com.hnk.wallpaper.utils.setOnSafeClick
import com.hnk.wallpaper.utils.visible
import nl.psdcompany.duonavigationdrawer.views.DuoDrawerLayout

class HomeFragment : BaseBindingFragment<FragmentHomeBinding, HomeVM>() {

    private var mBackPressedCallback = object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
            activity?.finish()
        }
    }

    private val mRateUsDialogFragment: RateUsInAppDialog by lazy  {
        RateUsInAppDialog()
    }

    override fun getViewModel(): Class<HomeVM> = HomeVM::class.java

    override fun getLayoutId(): Int = R.layout.fragment_home

    override fun onCreatedView(view: View?, savedInstanceState: Bundle?) {
        activity?.onBackPressedDispatcher?.addCallback(
            viewLifecycleOwner,
            mBackPressedCallback
        )
        observeViewModel()
        initView()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        mBackPressedCallback.remove()
    }

    private fun initView() {
        setupDrawerItemClickListener()
        HomeViewPagerAdapter(childFragmentManager, lifecycle).apply {
            binding.viewPager2.adapter = this
            binding.viewPager2.isUserInputEnabled = false
            binding.viewPager2.offscreenPageLimit =2
            binding.bottomNavigation.setOnItemSelectedListener { item ->
                binding.viewPager2.currentItem = when (item.itemId) {
                    R.id.collections_fragment -> 1
                    R.id.favorite_fragment -> 2
                    R.id.creative_fragment -> 3
                    else -> 0
                }
                toggleViews(item.itemId == R.id.creative_fragment || item.itemId == R.id.favorite_fragment)
                true
            }
        }

        binding.viewPager2.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                when (position) {
                    0 -> binding.bottomNavigation.selectedItemId = R.id.home_fragment
                    1 -> binding.bottomNavigation.selectedItemId = R.id.collections_fragment
                    2 -> binding.bottomNavigation.selectedItemId = R.id.favorite_fragment
                    3 -> binding.bottomNavigation.selectedItemId = R.id.creative_fragment
                }
            }
        })

        binding.imSearch.setOnSafeClick {
            navigateFragment(R.id.fragment_search)
        }
    }

    private fun observeViewModel() {
        mainViewModel.isNightMode.observe(viewLifecycleOwner) { isNightMode ->
            binding.tvDarkTheme.text = if (isNightMode) {
                getString(R.string.switch_to_day_mode)
            } else {
                getString(R.string.switch_to_night_mode)
            }
        }

        binding.tvDarkTheme.setOnClickListener {
            mainViewModel.toggleNightMode()
        }
    }

    private fun toggleViews(isSearchSelected: Boolean) {
        if (isSearchSelected) {
            binding.imMenu.gone()
            binding.imSearch.gone()
        } else {
            binding.imMenu.visible()
            binding.imSearch.visible()
        }
    }

    private fun setupDrawerItemClickListener() {
        binding.drawerLayout.setDrawerLockMode(DuoDrawerLayout.LOCK_MODE_LOCKED_CLOSED)
        binding.imMenu.setOnSafeClick { binding.drawerLayout.openDrawer() }
        binding.tvHome.setOnSafeClick {
            val currentFragmentId = binding.viewPager2.currentItem
            if (currentFragmentId != 0) {
                navigateFragment(R.id.fragment_home)
            } else {
                binding.drawerLayout.closeDrawer()
            }
        }

        binding.tvDownload.setOnSafeClick { navigateFragment(R.id.fragment_download) }
        binding.tvRecent.setOnSafeClick { navigateFragment(R.id.fragment_recent) }
        binding.imBack.setOnSafeClick { binding.drawerLayout.closeDrawer() }
        binding.tvPrivicy.setOnSafeClick { navigateFragment(R.id.fragment_privicy) }
        binding.tvLanguage.setOnSafeClick {
            Bundle().apply {
                putBoolean(Constant.KEY_LANGUAGE, true)
                navigateFragment(R.id.fragment_language_setting, this)
            }
        }
        binding.tvRateThisApp.setOnSafeClick { mRateUsDialogFragment.show(childFragmentManager,mRateUsDialogFragment.tag) }
        binding.tvShareWithFriend.setOnSafeClick {}
    }
}