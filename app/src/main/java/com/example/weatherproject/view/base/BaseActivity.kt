package com.example.weatherproject.view.base

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.weatherproject.R
import com.example.weatherproject.databinding.ActivityBaseBinding
import com.example.weatherproject.view.intro.SplashFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BaseActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBaseBinding

    interface OnBackPressedListener {
        fun onBackPressed()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        val fragmentList = supportFragmentManager.fragments
        for (fragment in fragmentList) {
            if (fragment is OnBackPressedListener) {
                (fragment as OnBackPressedListener).onBackPressed()
                return
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityBaseBinding.inflate(layoutInflater)
        setContentView(binding.root)
        onReplaceFragment(SplashFragment(), false) // 인트로 애니메이션
    }

    fun onReplaceFragment(fragment: Fragment, addToBackStack: Boolean = true) {
        if(!::binding.isInitialized) {
            binding = ActivityBaseBinding.inflate(layoutInflater)
        }

        supportFragmentManager.beginTransaction().let {
            it.replace(R.id.fragment_container, fragment)
            if(addToBackStack) {
                it.addToBackStack(null)
            }
            it.commitAllowingStateLoss()//sds
        }
    }
}
