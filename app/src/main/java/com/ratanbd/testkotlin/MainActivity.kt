package com.ratanbd.testkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment

import com.google.android.material.bottomnavigation.BottomNavigationView
import com.ratanbd.testkotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // Set the initial fragment
        loadFragment(Fragment1())

        // Handle item selection in BottomNavigationView
        binding.bottomNavigationView.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_fragment1 -> loadFragment(Fragment1())
                R.id.nav_fragment2 -> loadFragment(Fragment2())
                R.id.nav_fragment3 -> loadFragment(Fragment3())
                R.id.nav_fragment4 -> loadFragment(Fragment4())
            }
            true
        }
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}
