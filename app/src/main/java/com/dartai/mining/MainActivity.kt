package com.dartai.mining

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        navView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> switchFragment(HomeFragment())
                R.id.navigation_games -> switchFragment(GameCenterFragment())
                R.id.navigation_dashboard -> switchFragment(DashboardFragment())
                R.id.navigation_settings -> switchFragment(SettingsFragment())
            }
            true
        }
        // Set default fragment
        if (savedInstanceState == null) {
            navView.selectedItemId = R.id.navigation_home
        }
    }

    private fun switchFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.nav_host_fragment_activity_main, fragment)
            .commit()
    }
}