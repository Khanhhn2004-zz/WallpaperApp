package com.hnk.wallpaper.ui.dialog

import android.os.Bundle
import android.view.View
import com.bumptech.glide.Glide
import com.hnk.wallpaper.R
import com.hnk.wallpaper.data.enties.Photo
import com.hnk.wallpaper.data.model.ItemDownload
import com.hnk.wallpaper.databinding.DialogRemoveItemBinding
import com.hnk.wallpaper.ui.base.BaseBindingDialogFragment
import com.hnk.wallpaper.utils.setOnSafeClick
import timber.log.Timber

class RemoveItemDialog : BaseBindingDialogFragment<DialogRemoveItemBinding>() {

    private lateinit var mPhoto: ItemDownload
    var onClickSure: ((ItemDownload) -> Unit) = { _ -> }

    override val layoutId: Int
        get() = R.layout.dialog_remove_item

    override fun onCreatedView(view: View?, savedInstanceState: Bundle?) {
        Glide.with(this).load(mPhoto.photoUrl).into(binding.imWallpaper)
        onClick()
    }

    fun showBottomSheet(photo: ItemDownload) {
        mPhoto = photo
    }

    private fun onClick() {
        binding.tvSure.setOnSafeClick {
            onClickSure(mPhoto)
            dismiss()
        }
        binding.tvNo.setOnSafeClick {
            dismiss()
        }
        binding.viewBg.setOnSafeClick {
            dismiss()
        }
    }
}