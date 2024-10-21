package com.hnk.wallpaper.ui.adapter.pager

import androidx.recyclerview.widget.DiffUtil
import com.bumptech.glide.Glide
import com.hnk.wallpaper.R
import com.hnk.wallpaper.ui.base.BaseBindingAdapter
import com.hnk.wallpaper.data.model.Intro
import com.hnk.wallpaper.databinding.ItemIntroBinding
import timber.log.Timber

class IntroPagerAdapter : BaseBindingAdapter<Intro, ItemIntroBinding>(
    object : DiffUtil.ItemCallback<Intro>(){
        override fun areItemsTheSame(oldItem: Intro, newItem: Intro): Boolean {
            return oldItem==newItem
        }
        override fun areContentsTheSame(oldItem: Intro, newItem: Intro): Boolean = oldItem.contentIntro == newItem.contentIntro
    }
){
    override fun onBindViewHolderBase(holder: BaseHolder<ItemIntroBinding>, position: Int) {
        with(getItem(holder.adapterPosition)) {
            with(holder){
                with(binding){
                    tvContentIntro.text= contentIntro
                    tvTitle.text = titleIntro
                    Glide.with(imIntro.context)
                        .load(imageIntro)
                        .into(imIntro)

                }
            }
        }
    }

    override val layoutIdItem: Int
        get() = R.layout.item_intro
}

