package com.hnk.wallpaper.ui.permission

import android.Manifest
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import com.hnk.wallpaper.R
import com.hnk.wallpaper.databinding.FragmentPermissionBinding
import com.hnk.wallpaper.ui.base.BaseBindingFragment
import com.hnk.wallpaper.ui.dialog.PermissionDialog
import com.hnk.wallpaper.utils.setOnSafeClick

class PermissionFragment : BaseBindingFragment<FragmentPermissionBinding, PermissionVM>() {
    override fun getViewModel(): Class<PermissionVM> = PermissionVM::class.java

    override fun getLayoutId(): Int = R.layout.fragment_permission

    override fun onCreatedView(view: View?, savedInstanceState: Bundle?) {
        initListener()
    }

    private fun initListener() {
        binding.tvAllow.setOnSafeClick {
            requestPermissions()
        }
        binding.tvMayBe.setOnSafeClick {
            navigateFragment(R.id.fragment_home)
        }
    }

    private fun requestPermissions() {
        if (Build.VERSION.SDK_INT >= 33) {
            requestPermissionLauncher.launch(Manifest.permission.READ_MEDIA_IMAGES)
        } else {
            requestPermissionLauncher.launch(Manifest.permission.READ_EXTERNAL_STORAGE)
        }
    }

    private val requestPermissionLauncher =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted: Boolean ->
            if (isGranted) {
                navigateFragment(R.id.fragment_home)
            } else {
                handlePermissionDenied()
            }
        }

    private fun handlePermissionDenied() {
        activity?.let { act ->
            val shouldShowRationaleForImage = if (Build.VERSION.SDK_INT >= 33) {
                shouldShowRequestPermissionRationale(Manifest.permission.READ_MEDIA_IMAGES)
            } else {
                shouldShowRequestPermissionRationale(Manifest.permission.READ_EXTERNAL_STORAGE)
            }

            if (!shouldShowRationaleForImage) {
                showPermissionRationaleDialog()
            }
        }
    }

    private fun showPermissionRationaleDialog() {
        PermissionDialog().show(
            childFragmentManager, PermissionDialog().tag
        )
    }
}
