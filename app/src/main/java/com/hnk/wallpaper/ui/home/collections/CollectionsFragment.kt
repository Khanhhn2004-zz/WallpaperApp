package com.hnk.wallpaper.ui.home.collections

import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import com.hnk.wallpaper.R
import com.hnk.wallpaper.common.Constant
import com.hnk.wallpaper.common.MessageEvent
import com.hnk.wallpaper.databinding.FragmentCollectionsBinding
import com.hnk.wallpaper.ui.adapter.recyclerview.CollectionAdapter
import com.hnk.wallpaper.ui.base.BaseBindingFragment
import com.hnk.wallpaper.ui.base.observeWithCatch
import com.hnk.wallpaper.ui.dialog.NetWorkDialog
import com.hnk.wallpaper.utils.NetworkUtils.isNetworkAvailable
import com.hnk.wallpaper.utils.ResultState
import com.hnk.wallpaper.utils.gone
import com.hnk.wallpaper.utils.visible
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import timber.log.Timber

/**
 * This fragment to show all collections.
 *
 */
class CollectionsFragment : BaseBindingFragment<FragmentCollectionsBinding, CollectionsVM>() {
    private var mNetWorkDialog: NetWorkDialog? = null

    private val collectionAdapter: CollectionAdapter by lazy {
        CollectionAdapter().apply {
            onClickItem = { item ->
                Bundle().apply {
                    putString(Constant.KEY_ID_COLLECTION, item.id)
                    putString(Constant.KEY_TITLE_COLLECTION, item.title)
                    putInt(Constant.KEY_COUNT_WALLPAPER, item.photosCount)
                    navigateFragment(R.id.fragment_show_more_collection, this)
                }
            }
        }
    }

    override fun getViewModel(): Class<CollectionsVM> = CollectionsVM::class.java

    override fun getLayoutId(): Int = R.layout.fragment_collections

    override fun onCreatedView(view: View?, savedInstanceState: Bundle?) {
        binding.rclCollections.adapter = collectionAdapter
        val isConnected = context?.isNetworkAvailable()
        if (isConnected != null) {
            setNetWorkStatus(isConnected)
        }
        observerData()
    }

    private fun showDialogNetWork(isConnect: Boolean) {
        childFragmentManager.findFragmentByTag(NetWorkDialog::class.java.simpleName)
            ?.let { fragment ->
                (fragment as? NetWorkDialog)?.dismiss()
                childFragmentManager.beginTransaction().remove(fragment).commitAllowingStateLoss()
            }
        if (mNetWorkDialog == null) {
            mNetWorkDialog = NetWorkDialog()
        }
        if (isConnect) {
            if (mNetWorkDialog?.isAdded == true) {
                mNetWorkDialog?.dismiss()
            }
        } else {
            if (!mNetWorkDialog!!.isAdded) {
                mNetWorkDialog?.show(
                    childFragmentManager,
                    NetWorkDialog::class.java.simpleName
                )
            }
        }
    }

    private fun observerData() {
        viewModel.getFeaturedCollections()
        viewModel.collectionLiveData.observeWithCatch(viewLifecycleOwner) { resultState ->
            lifecycleScope.launch(Dispatchers.IO) {
                when (resultState) {
                    is ResultState.Loading -> {
                        withContext(Dispatchers.Main) {
//                            binding.shimmerViewWallpaper.startShimmer()
                        }

                    }

                    is ResultState.Error -> {
                        withContext(Dispatchers.Main) {
                        }
                    }

                    is ResultState.Success -> {
                        withContext(Dispatchers.Main) {
                            collectionAdapter.submitData(resultState.data)
                        }
                    }
                }

            }
        }
    }

    private fun setNetWorkStatus(isConnect: Boolean) {
        if (isConnect) {
            binding.shimmerViewWallpaper.stopShimmer()
            binding.shimmerViewWallpaper.gone()
            binding.rclCollections.visible()
        } else {
            binding.shimmerViewWallpaper.startShimmer()
            binding.shimmerViewWallpaper.visible()
            binding.rclCollections.gone()

        }
    }
    override fun onStart() {
        super.onStart()
        EventBus.getDefault().register(this)
    }

    override fun onStop() {
        EventBus.getDefault().unregister(this)
        super.onStop()
    }

    override fun onDestroy() {
        EventBus.getDefault().unregister(this)
        super.onDestroy()
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onMessageEvent(event: MessageEvent) {
        when (event.typeEvent) {
            Constant.EVENT_NETWORK_STATUS -> {
                setNetWorkStatus(event.booleanValue)
            }
        }
    }
}