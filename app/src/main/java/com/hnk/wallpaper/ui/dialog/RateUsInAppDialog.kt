package com.hnk.wallpaper.ui.dialog

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import com.hnk.wallpaper.R
import com.hnk.wallpaper.databinding.DialogRateUsOneBinding
import com.hnk.wallpaper.ui.base.BaseBindingDialogFragment
import com.hnk.wallpaper.utils.setOnSafeClick


class RateUsInAppDialog : BaseBindingDialogFragment<DialogRateUsOneBinding>() {
    override val layoutId: Int
        get() = R.layout.dialog_rate_us_one

    override fun onCreatedView(view: View?, savedInstanceState: Bundle?) {
        onClick()
    }
    @SuppressLint("ClickableViewAccessibility")
    private fun onClick() {
        binding.tvAllow.setOnSafeClick {
           dismiss()
        }
        binding.viewBg.setOnClickListener{
            dismiss()
        }
        binding.viewStar.setOnTouchListener { view, event ->
            val touchPositionX = event.x
            val width = binding.viewStar.width
            val starsf = touchPositionX / width * binding.viewStar.numStars
            val stars = (starsf + 1).toInt()
            binding.viewStar.rating = stars.toFloat()
            true
        }
        binding.vRateUs.setOnClickListener {
            dismiss()
        }
    }
}