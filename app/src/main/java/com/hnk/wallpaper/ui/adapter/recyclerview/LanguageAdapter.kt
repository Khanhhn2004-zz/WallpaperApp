package com.hnk.wallpaper.ui.adapter.recyclerview

import android.view.View
import androidx.recyclerview.widget.DiffUtil
import com.bumptech.glide.Glide
import com.hnk.wallpaper.R
import com.hnk.wallpaper.data.model.Language
import com.hnk.wallpaper.databinding.ItemLanguageBinding
import com.hnk.wallpaper.ui.base.BaseBindingAdapter


/**
 *
 * Show item language
 *
 * @author KhanhHN
 */
class LanguageAdapter : BaseBindingAdapter<Language, ItemLanguageBinding>(
    object : DiffUtil.ItemCallback<Language>() {
        override fun areItemsTheSame(oldItem: Language, newItem: Language): Boolean {
            return oldItem.code == newItem.code
        }

        override fun areContentsTheSame(oldItem: Language, newItem: Language): Boolean =
            oldItem == newItem
    }
) {
    var iClickItem: (result: Int) -> Unit = { _ -> }

    override fun onBindViewHolderBase(holder: BaseHolder<ItemLanguageBinding>, position: Int) {

        with(getItem(holder.bindingAdapterPosition)) {
            with(holder) {
                itemView.isActivated = isSelected
                with(binding) {
                    Glide.with(imFlag.context)
                        .load(avatar)
                        .into(imFlag)
                    tvLanguage.text = name
                    if (isSelected) {
                        imCheck.visibility = View.VISIBLE
                    } else {
                        imCheck.visibility = View.INVISIBLE
                    }

                }
            }
            holder.itemView.setOnClickListener {
                iClickItem(holder.bindingAdapterPosition)
            }
        }
    }

    override val layoutIdItem: Int
        get() = R.layout.item_language

}
