package com.hnk.wallpaper.ui.adapter.pager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.hnk.wallpaper.ui.favorite.FavouriteFragment
import com.hnk.wallpaper.ui.home.collections.CollectionsFragment
import com.hnk.wallpaper.ui.home.creative.CreativeFragment
import com.hnk.wallpaper.ui.home.featured.FeaturedFragment
import com.hnk.wallpaper.ui.intro.IntroCreateWallpaperFragment

class HomeViewPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {

    private val featuredFragment : FeaturedFragment by lazy { FeaturedFragment() }
    private val createWallpaperFragment : CreativeFragment by lazy { CreativeFragment() }
    private val collectionsFragment : CollectionsFragment by lazy { CollectionsFragment() }
    private val favouriteFragment : FavouriteFragment by lazy { FavouriteFragment() }
    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> featuredFragment
            1 -> collectionsFragment
            2 -> favouriteFragment
            else -> createWallpaperFragment
        }
    }

    override fun getItemCount(): Int {
        return 4
    }
}
