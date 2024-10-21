package com.hnk.wallpaper.ui.base

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AlphaAnimation
import android.view.animation.AnimationSet
import android.view.animation.AnimationUtils
import android.view.animation.DecelerateInterpolator
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

abstract class BaseBindingPagerAdapter<T : Any, B : ViewDataBinding>(
    itemCallback: DiffUtil.ItemCallback<T>
) : PagingDataAdapter<T, BaseBindingPagerAdapter.BaseHolder<B>>(
    itemCallback
) {
    private var lastPosition = -1

    protected abstract val layoutIdItem: Int

    protected abstract fun onBindViewHolderBase(
        holder: BaseHolder<B>,
        position: Int
    )

    class BaseHolder<B : ViewDataBinding>(var binding: B) : RecyclerView.ViewHolder(
        binding.root
    )

    override fun onBindViewHolder(holder: BaseHolder<B>, position: Int) {
        onBindViewHolderBase(holder, holder.bindingAdapterPosition)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseHolder<B> {
        val binding = DataBindingUtil.inflate<B>(
            LayoutInflater.from(parent.context),
            layoutIdItem,
            parent,
            false
        )
        return BaseHolder(binding)
    }

    protected fun setAnimation(viewToAnimate: View, position: Int, context: Context) {
        if (position > lastPosition) {
            val fadeIn = AlphaAnimation(0f, 1f)
            fadeIn.duration = 1000
            fadeIn.interpolator = DecelerateInterpolator()
            val slideInLeft = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left)
            val animationSet = AnimationSet(false)
            animationSet.addAnimation(fadeIn)
            animationSet.addAnimation(slideInLeft)
            viewToAnimate.startAnimation(animationSet)
            lastPosition = position
        }
    }

}