package com.hnk.wallpaper.ui.adapter.recyclerview

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.recyclerview.widget.DiffUtil
import com.bumptech.glide.Glide
import com.hnk.wallpaper.R
import com.hnk.wallpaper.data.model.ItemPhoto
import com.hnk.wallpaper.databinding.ItemWallpaperBinding
import com.hnk.wallpaper.ui.base.BaseBindingPagerAdapter

class WallpaperPagingAdapter : BaseBindingPagerAdapter<ItemPhoto, ItemWallpaperBinding>(
    object : DiffUtil.ItemCallback<ItemPhoto>() {
        override fun areItemsTheSame(oldItem: ItemPhoto, newItem: ItemPhoto) =
            oldItem.id == newItem.id

        override fun areContentsTheSame(
            oldItem: ItemPhoto, newItem: ItemPhoto
        ): Boolean = oldItem == newItem
    }
) {

    var onClickItem: (String, String) -> Unit = { _, _ -> }
    var onLongClickItem: (String, String) -> Unit = { _, _ -> }
    var onThreeDotsClickItem: (String, String) -> Unit = { _, _ -> }

    override fun onBindViewHolderBase(holder: BaseHolder<ItemWallpaperBinding>, position: Int) {
        getItem(holder.bindingAdapterPosition)?.let { item ->
            holder.binding.apply {
                val avgColorInt = Color.parseColor(item.avgColor)
                Glide.with(imWallpaper.context)
                    .load(item.src?.portrait)
                    .placeholder(ColorDrawable(avgColorInt))
                    .into(imWallpaper)

                imThreeDots.setOnClickListener {
                    item.src?.original?.let { url ->
                        item.avgColor?.let { color -> onThreeDotsClickItem(url, color) }
                    }
                }
            }
            holder.itemView.setOnClickListener {
                item.src?.original?.let { url ->
                    item.avgColor?.let { color -> onClickItem(url, color) }
                }
            }
            holder.itemView.setOnLongClickListener {
                item.src?.original?.let { url ->
                    item.avgColor?.let { color -> onThreeDotsClickItem(url, color) }
                }
                true
            }
        }
    }

    override val layoutIdItem: Int
        get() = R.layout.item_wallpaper
}
