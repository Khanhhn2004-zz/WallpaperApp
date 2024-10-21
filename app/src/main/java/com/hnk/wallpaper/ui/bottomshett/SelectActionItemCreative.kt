package com.hnk.wallpaper.ui.bottomshett

import android.os.Bundle
import android.view.View
import com.example.myapplication.base.BaseBottomSheetDialogFragment
import com.hnk.wallpaper.R
import com.hnk.wallpaper.data.model.Creative
import com.hnk.wallpaper.databinding.BottomSheetActionItemCreativeBinding
import com.hnk.wallpaper.utils.setOnSafeClick

class SelectActionItemCreative :
    BaseBottomSheetDialogFragment<BottomSheetActionItemCreativeBinding>() {
    private lateinit var mPhoto: Creative

    var onClickSetWallpaper: ((Creative) -> Unit) = { _ -> }
    var onClickDelete: ((Creative) -> Unit) = { _ -> }
    var onClickShareWallpaper: ((Creative) -> Unit) = { _ -> }

    override val layoutId = R.layout.bottom_sheet_action_item_creative

    override fun onCreatedView(view: View?, savedInstanceState: Bundle?) {
        initAction()
    }

    fun showBottomSheet(photo: Creative) {
        mPhoto = photo
    }

    private fun initAction() {
        with(binding) {
            tvDelete.setOnSafeClick {
                onClickDelete(mPhoto)
                dismiss()
            }
            tvSetWallpaper.setOnSafeClick {
                onClickSetWallpaper(mPhoto)
                dismiss()
            }
            tvShare.setOnSafeClick {
                onClickShareWallpaper(mPhoto)
                dismiss()
            }
        }
    }
}