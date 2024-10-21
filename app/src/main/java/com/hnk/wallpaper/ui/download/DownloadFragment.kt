package com.hnk.wallpaper.ui.download

import android.os.Bundle
import android.view.View
import com.hnk.wallpaper.R
import com.hnk.wallpaper.common.Constant
import com.hnk.wallpaper.data.model.ItemDownload
import com.hnk.wallpaper.databinding.FragmentDownloadBinding
import com.hnk.wallpaper.ui.adapter.recyclerview.DownloadAdapter
import com.hnk.wallpaper.ui.base.BaseBindingFragment
import com.hnk.wallpaper.ui.bottomshett.SelectActionItemDownload
import com.hnk.wallpaper.ui.dialog.RemoveItemDialog
import com.hnk.wallpaper.utils.gone
import com.hnk.wallpaper.utils.setOnSafeClick
import com.hnk.wallpaper.utils.shareContent
import com.hnk.wallpaper.utils.visible
import timber.log.Timber

class DownloadFragment : BaseBindingFragment<FragmentDownloadBinding, DownloadVM>() {


    private val downloadAdapter: DownloadAdapter by lazy {
        DownloadAdapter().apply {
            iClickItem = { wallpaper ->
                startToDetail(wallpaper.photoUrl, wallpaper.avgColor)
            }
            iLongClickItem = { photo ->
                mRemoveItemDialog.showBottomSheet(photo)
                mRemoveItemDialog.show(childFragmentManager, mRemoveItemDialog.tag)
            }
            threeDotsClickItem = { photo ->
                showDialogAction(photo)
            }
        }
    }

    private var mSelectActionBottomSheet: SelectActionItemDownload? = null


    private fun showDialogAction(photo: ItemDownload) {
        mSelectActionBottomSheet?.tag?.let { tag ->
            childFragmentManager.findFragmentByTag(tag)?.let { fragment ->
                if (fragment is SelectActionItemDownload) {
                    mSelectActionBottomSheet = fragment
                }
            }
        }

        if (mSelectActionBottomSheet == null) {
            mSelectActionBottomSheet = SelectActionItemDownload().apply {
                onClickSetWallpaper = { photoUrl, id, photoUri, avgColor ->
                    startToDetail(photoUrl, avgColor)
                }
                onClickDelete = { id ->
                    mainViewModel.removeItemDownloadById(id)
                }
                onClickShareWallpaper = { photoUri ->
                    context?.shareContent(photoUri)
                }
            }
        }
        Bundle().apply {
            putInt(SelectActionItemDownload.KEY_ID_DOWNLOAD, photo.id)
            putString(SelectActionItemDownload.KEY_PHOTO_URL, photo.photoUrl)
            putString(SelectActionItemDownload.KEY_PHOTO_URI, photo.photoUri)
            putString(SelectActionItemDownload.KEY_AVG_COLOR, photo.avgColor)
            mSelectActionBottomSheet!!.arguments = this
            mSelectActionBottomSheet!!.show(childFragmentManager, mSelectActionBottomSheet!!.tag)
        }
    }

    private val mRemoveItemDialog: RemoveItemDialog by lazy {
        RemoveItemDialog().apply {
            onClickSure = {
                mainViewModel.removeItemDownloadById(it.id)
            }
        }
    }

    override fun getViewModel(): Class<DownloadVM> = DownloadVM::class.java
    override fun getLayoutId(): Int = R.layout.fragment_download
    override fun onCreatedView(view: View?, savedInstanceState: Bundle?) {
        initData()
        initView()
    }

    private fun initData() {
        mainViewModel.downloadLiveData.observe(viewLifecycleOwner) { listDownloads ->
            if (listDownloads.isNullOrEmpty()) {
                binding.imNoDownload.visible()
                binding.tvNoDownload.visible()
                downloadAdapter.submitList(emptyList())
            } else {
                binding.imNoDownload.gone()
                binding.tvNoDownload.gone()
                downloadAdapter.submitList(listDownloads)
            }
        }
    }


    private fun initView() {
        binding.rclFavorite.adapter = downloadAdapter
        binding.imBack.setOnSafeClick {
            popBackStack()
        }
    }

    private fun startToDetail(urI: String, avgColor: String) {
        Bundle().apply {
            putString(Constant.KEY_URL_WALLPAPER, urI)
            putString(Constant.KEY_AVG_COLOR_WALLPAPER, avgColor)
            navigateFragment(R.id.fragment_detail, this)
        }
    }
}