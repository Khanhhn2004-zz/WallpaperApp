package com.hnk.wallpaper.ui.adapter.recyclerview

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.recyclerview.widget.DiffUtil
import com.bumptech.glide.Glide
import com.hnk.wallpaper.R
import com.hnk.wallpaper.data.model.ItemCollection
import com.hnk.wallpaper.databinding.ItemCollectionsBinding
import com.hnk.wallpaper.ui.base.BaseBindingAdapter
import com.hnk.wallpaper.ui.base.BaseBindingAdapter.BaseHolder
import com.hnk.wallpaper.ui.base.BaseBindingPagerAdapter

class CollectionAdapter : BaseBindingPagerAdapter<ItemCollection, ItemCollectionsBinding>(
    object : DiffUtil.ItemCallback<ItemCollection>() {
        override fun areItemsTheSame(oldItem: ItemCollection, newItem: ItemCollection) =
            oldItem.id == newItem.id

        override fun areContentsTheSame(
            oldItem: ItemCollection, newItem: ItemCollection
        ): Boolean = oldItem == newItem
    }
) {

    var onClickItem: (ItemCollection) -> Unit = { _ -> }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolderBase(holder: BaseHolder<ItemCollectionsBinding>, position: Int) {
        getItem(holder.bindingAdapterPosition)?.let { item ->
            holder.binding.apply {
                tvNameCollection.text = item.title
                tvSieCollection.text = "${item.photosCount} ${holder.itemView.context.getString(R.string.wallpaper)}"
                Glide.with(imCollections.context)
                    .load(item.cover)
                    .placeholder(ColorDrawable(Color.parseColor("#B6B6B6")))
                    .into(imCollections)
                holder.itemView.setOnClickListener {
                    onClickItem(item)
                }
            }
        }
    }

    override val layoutIdItem: Int
        get() = R.layout.item_collections
}
