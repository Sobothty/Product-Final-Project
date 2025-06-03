package com.bothty.product_finalproject

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bothty.product_finalproject.databinding.ActivityMainBinding
import com.bothty.product_finalproject.fragment.AccountFragment
import com.bothty.product_finalproject.fragment.CardFragment
import com.bothty.product_finalproject.fragment.HomeFragment


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val homeFragment = HomeFragment()
    private val cardFragment = CardFragment()
    private val profileFragment = AccountFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        handleBottomNavigationView()

        showHomeFragment()
    }

    //Show HomePage Fragments
    private fun showHomeFragment() {
        supportFragmentManager.beginTransaction().replace(binding.layoutFragments.id, homeFragment)
    }

    //Show Card Page Fragments
    private fun showCardFragment() {
        supportFragmentManager.beginTransaction().replace(binding.layoutFragments.id, cardFragment)
    }

    //Show Profile Page Fragments
    private fun showProfileFragment() {
        supportFragmentManager.beginTransaction()
            .replace(binding.layoutFragments.id, profileFragment)
    }

    // Navigation Function
    private fun handleBottomNavigationView() {
        binding.bottomNav.setOnItemSelectedListener { menuItem ->

            when (menuItem.itemId) {
                R.id.home -> showHomeFragment()
                R.id.addToCard -> showCardFragment()
                R.id.account -> showProfileFragment()
            }

            true
        }
    }

}