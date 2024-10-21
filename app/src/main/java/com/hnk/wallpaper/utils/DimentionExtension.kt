package com.hnk.wallpaper.utils


import android.content.res.Resources
import com.hnk.wallpaper.common.Constant

fun getScreenWidth(): Int {
    return Resources.getSystem().displayMetrics.widthPixels
}

fun getScreenHeight(): Int {
    return Resources.getSystem().displayMetrics.heightPixels
}

fun Int.pxToDp(): Float {
    return (this / Resources.getSystem().displayMetrics.density)
}

fun Int.dpToPx(): Float {
    return this * Resources.getSystem().displayMetrics.density
}

fun Float.dpToPx(): Float {
    return this * Resources.getSystem().displayMetrics.density
}

fun Int.spToPx(): Float {
    return this * Resources.getSystem().displayMetrics.scaledDensity
}

fun Int.convertSizeFromProgress(): Float {
    return (((Constant.MAX_SIZE - Constant.MIN_SIZE) * this / 100) + Constant.MIN_SIZE).toFloat()
}