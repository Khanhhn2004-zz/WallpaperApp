package com.hnk.wallpaper.ui.adapter.pager

import androidx.recyclerview.widget.DiffUtil
import com.bumptech.glide.Glide
import com.hnk.wallpaper.R
import com.hnk.wallpaper.data.model.ItemPhoto
import com.hnk.wallpaper.databinding.ItemBannerBinding
import com.hnk.wallpaper.ui.base.BaseBindingAdapter

class BannerPagerAdapter : BaseBindingAdapter<ItemPhoto, ItemBannerBinding>(
    object : DiffUtil.ItemCallback<ItemPhoto>() {
        override fun areItemsTheSame(oldItem: ItemPhoto, newItem: ItemPhoto): Boolean {
            return oldItem.id == newItem.id
        }
        override fun areContentsTheSame(oldItem: ItemPhoto, newItem: ItemPhoto): Boolean =
            oldItem == newItem
    }
) {
    var iClickItem: (String, String) -> Unit = { _, _ -> }

    override fun onBindViewHolderBase(holder: BaseHolder<ItemBannerBinding>, position: Int) {
        with(holder) {
            with(binding) {
                Glide.with(imWallpaper.context)
                    .load(getItem(position).src?.landscape)
                    .into(imWallpaper)
            }
            itemView.setOnClickListener {
                iClickItem(
                    getItem(holder.bindingAdapterPosition).src?.landscape!!,
                    getItem(holder.bindingAdapterPosition).avgColor!!
                )
            }
        }
    }

    override val layoutIdItem: Int
        get() = R.layout.item_banner
}