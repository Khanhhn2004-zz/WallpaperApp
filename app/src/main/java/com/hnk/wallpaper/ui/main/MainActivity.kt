package com.hnk.wallpaper.ui.main

import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowInsets
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.hnk.wallpaper.R
import com.hnk.wallpaper.databinding.ActivityMainBinding
import com.hnk.wallpaper.ui.base.BaseBindingActivity
import com.hnk.wallpaper.ui.base.observeWithCatch
import com.hnk.wallpaper.utils.setLightStatusBarsBasedOnSystem
import com.hnk.wallpaper.utils.setStatusBarColor

class MainActivity : BaseBindingActivity<ActivityMainBinding, MainVM>() {

    private val navHostFragment: NavHostFragment by lazy {
        supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
    }
    val navController: NavController by lazy { navHostFragment.navController }

    override val layoutId: Int
        get() = R.layout.activity_main

    override fun getViewModel(): Class<MainVM> = MainVM::class.java

    override fun setupView(savedInstanceState: Bundle?) {
        setStatusBarColor(R.color.transparent)
        window.setLightStatusBarsBasedOnSystem()
    }

    override fun setupData() {
        viewModel.getIdScreenFirstShow()
        viewModel.idScreenFirstShow.observeWithCatch(this){id ->
            val navGraph = navController.navInflater.inflate(R.navigation.nav_fragment)
            navGraph.setStartDestination(id)
            navController.graph = navGraph
        }
        viewModel.getAllDownload()
    }

}
