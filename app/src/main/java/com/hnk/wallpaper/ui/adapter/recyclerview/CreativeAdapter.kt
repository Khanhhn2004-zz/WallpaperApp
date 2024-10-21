package com.hnk.wallpaper.ui.adapter.recyclerview

import androidx.recyclerview.widget.DiffUtil
import com.bumptech.glide.Glide
import com.hnk.wallpaper.R
import com.hnk.wallpaper.data.model.Creative
import com.hnk.wallpaper.databinding.ItemWallpaperBinding
import com.hnk.wallpaper.ui.base.BaseBindingAdapter
import com.hnk.wallpaper.ui.base.BaseBindingPagerAdapter

class CreativeAdapter : BaseBindingAdapter<Creative, ItemWallpaperBinding>(object :
    DiffUtil.ItemCallback<Creative>() {
    override fun areItemsTheSame(oldItem: Creative, newItem: Creative) =
        oldItem.id == newItem.id

    override fun areContentsTheSame(
        oldItem: Creative, newItem: Creative
    ): Boolean = oldItem == newItem
}) {
    var iClickItem: (Creative) -> Unit = { _ -> }
    var iLongClickItem: (Creative) -> Unit = { _ -> }
    var threeDotsClickItem: (Creative) -> Unit = { _ -> }

    override fun onBindViewHolderBase(holder: BaseHolder<ItemWallpaperBinding>, position: Int) {
        with(holder) {
            Glide.with(binding.imWallpaper.context)
                .load(getItem(holder.bindingAdapterPosition)?.photoUri)
                .into(binding.imWallpaper)

            binding.imThreeDots.setOnClickListener {
                getItem(holder.bindingAdapterPosition)?.let { it1 -> threeDotsClickItem(it1) }
            }
        }
        holder.itemView.setOnClickListener {
            getItem(holder.bindingAdapterPosition)?.let { it1 -> iClickItem(it1) }
        }
        holder.itemView.setOnLongClickListener {
            getItem(holder.bindingAdapterPosition)?.let { it1 -> iLongClickItem(it1) }
            true
        }
    }

    override val layoutIdItem: Int
        get() = R.layout.item_wallpaper
}