package com.hnk.wallpaper.ui.adapter.pager

import androidx.recyclerview.widget.DiffUtil
import com.bumptech.glide.Glide
import com.hnk.wallpaper.R
import com.hnk.wallpaper.ui.base.BaseBindingAdapter
import com.hnk.wallpaper.data.model.Intro
import com.hnk.wallpaper.databinding.ItemIntroBinding
import com.hnk.wallpaper.databinding.ItemIntroCreativeWallpaperBinding
import timber.log.Timber

class IntroCreateWallpaperPagerAdapter : BaseBindingAdapter<Intro, ItemIntroCreativeWallpaperBinding>(
    object : DiffUtil.ItemCallback<Intro>(){
        override fun areItemsTheSame(oldItem: Intro, newItem: Intro): Boolean {
            return oldItem==newItem
        }
        override fun areContentsTheSame(oldItem: Intro, newItem: Intro): Boolean = oldItem.contentIntro == newItem.contentIntro
    }
){

    override fun onBindViewHolderBase(
        holder: BaseHolder<ItemIntroCreativeWallpaperBinding>,
        position: Int
    ) {
        with(getItem(holder.bindingAdapterPosition)) {
            with(holder){
                with(binding){
                    tvContentTop.text= contentIntro
                    tvContentBottom.text = titleIntro
                    Glide.with(imWallpaper.context)
                        .load(imageIntro)
                        .into(imWallpaper)

                }
            }
        }
    }

    override val layoutIdItem: Int
        get() = R.layout.item_intro_creative_wallpaper
}

