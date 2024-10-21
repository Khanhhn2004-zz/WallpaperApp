package com.hnk.wallpaper.ui.adapter.recyclerview

import androidx.recyclerview.widget.DiffUtil
import com.bumptech.glide.Glide
import com.hnk.wallpaper.R
import com.hnk.wallpaper.data.model.ItemFavorite
import com.hnk.wallpaper.databinding.ItemWallpaperBinding
import com.hnk.wallpaper.ui.base.BaseBindingAdapter

class FavoriteAdapter : BaseBindingAdapter<ItemFavorite, ItemWallpaperBinding>(
    object : DiffUtil.ItemCallback<ItemFavorite>() {
        override fun areItemsTheSame(oldItem: ItemFavorite, newItem: ItemFavorite) =
            oldItem.id == newItem.id

        override fun areContentsTheSame(
            oldItem: ItemFavorite, newItem: ItemFavorite
        ): Boolean = oldItem == newItem
    }) {

    var iClickItem: (String, String) -> Unit = { _, _ -> }
    var iLongClickItem: (String, Int, String, String) -> Unit = { _, _, _, _ -> }
    var threeDotsClickItem: (String, Int, String, String) -> Unit = { _, _, _, _ -> }

    override fun onBindViewHolderBase(holder: BaseHolder<ItemWallpaperBinding>, position: Int) {
        with(getItem(holder.bindingAdapterPosition)) {
            Glide.with(holder.binding.imWallpaper.context)
                .load(photoUri)
                .into(holder.binding.imWallpaper)

            holder.binding.imThreeDots.setOnClickListener {
                threeDotsClickItem(photoUrl, downloadId, photoUri, avgColor)
            }
            holder.itemView.setOnClickListener {
                iClickItem(photoUrl, avgColor)
            }
            holder.itemView.setOnLongClickListener {
                iLongClickItem(photoUrl, downloadId, photoUri, avgColor)
                true
            }
        }
    }

    override val layoutIdItem: Int
        get() = R.layout.item_wallpaper
}