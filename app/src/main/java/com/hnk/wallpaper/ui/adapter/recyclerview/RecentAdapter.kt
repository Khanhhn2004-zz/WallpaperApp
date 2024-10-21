package com.hnk.wallpaper.ui.adapter.recyclerview

import androidx.recyclerview.widget.DiffUtil
import com.bumptech.glide.Glide
import com.hnk.wallpaper.R
import com.hnk.wallpaper.data.model.Recent
import com.hnk.wallpaper.databinding.ItemWallpaperBinding
import com.hnk.wallpaper.ui.base.BaseBindingAdapter

class RecentAdapter : BaseBindingAdapter<Recent, ItemWallpaperBinding>(
    object : DiffUtil.ItemCallback<Recent>() {
        override fun areItemsTheSame(oldItem: Recent, newItem: Recent) =
            oldItem.id == newItem.id

        override fun areContentsTheSame(
            oldItem: Recent, newItem: Recent
        ): Boolean = oldItem == newItem
    }
) {
    var iClickItem: (String, String) -> Unit = { _, _ -> }
    var iLongClickItem: (Recent) -> Unit = { _ -> }
    var threeDotsClickItem: (Recent) -> Unit = { _ -> }


    override fun onBindViewHolderBase(holder: BaseHolder<ItemWallpaperBinding>, position: Int) {
        with(holder) {
            Glide.with(binding.imWallpaper.context)
                .load(getItem(holder.bindingAdapterPosition).photoUrl)
                .into(binding.imWallpaper)

            binding.imThreeDots.setOnClickListener {
                threeDotsClickItem(getItem(holder.bindingAdapterPosition))
            }
        }
        holder.itemView.setOnClickListener {
            iClickItem(
                getItem(holder.bindingAdapterPosition).photoUrl,
                getItem(holder.bindingAdapterPosition).avgColor
            )
        }
        holder.itemView.setOnLongClickListener {
            iLongClickItem(getItem(holder.bindingAdapterPosition))
            true
        }
    }

    override val layoutIdItem: Int
        get() = R.layout.item_wallpaper
}