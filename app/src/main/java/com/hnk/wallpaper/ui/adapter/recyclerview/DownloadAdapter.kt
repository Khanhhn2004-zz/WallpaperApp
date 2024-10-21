package com.hnk.wallpaper.ui.adapter.recyclerview

import androidx.recyclerview.widget.DiffUtil
import com.bumptech.glide.Glide
import com.hnk.wallpaper.R
import com.hnk.wallpaper.data.model.ItemDownload
import com.hnk.wallpaper.databinding.ItemWallpaperBinding
import com.hnk.wallpaper.ui.base.BaseBindingAdapter
import timber.log.Timber

class DownloadAdapter : BaseBindingAdapter<ItemDownload, ItemWallpaperBinding>(object :
    DiffUtil.ItemCallback<ItemDownload>() {
    override fun areItemsTheSame(oldItem: ItemDownload, newItem: ItemDownload) =
        oldItem.id == newItem.id

    override fun areContentsTheSame(
        oldItem: ItemDownload, newItem: ItemDownload
    ): Boolean = oldItem == newItem
}) {
    var iClickItem: (ItemDownload) -> Unit = { _-> }
    var iLongClickItem: (ItemDownload: ItemDownload) -> Unit = { _ -> }
    var threeDotsClickItem: (ItemDownload) -> Unit = { _ -> }

    override fun onBindViewHolderBase(holder: BaseHolder<ItemWallpaperBinding>, position: Int) {
        with(holder) {
            Glide.with(binding.imWallpaper.context)
                .load(getItem(holder.bindingAdapterPosition).photoUri)
                .into(binding.imWallpaper)

            binding.imThreeDots.setOnClickListener {
                threeDotsClickItem(getItem(holder.bindingAdapterPosition))
            }
        }
        holder.itemView.setOnClickListener {
            iClickItem(getItem(holder.bindingAdapterPosition))
        }
        holder.itemView.setOnLongClickListener {
            iLongClickItem(getItem(holder.bindingAdapterPosition))
            true
        }
    }

    override val layoutIdItem: Int
        get() = R.layout.item_wallpaper
}