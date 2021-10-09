package com.example.bootcampproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AlertDialog
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_profil.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        NavigationUI.setupWithNavController(bottom_nav, navHostFragment.navController)
        showCustomAlert()

    }

    private fun showCustomAlert() {
        val dialogView = layoutInflater.inflate(R.layout.custom_dialog, null)

        val customDialog = AlertDialog.Builder(this)
            .setView(dialogView)
            .show()

        val btDismiss = dialogView.findViewById<ImageButton>(R.id.btDismissCustomDialog)
        btDismiss.setOnClickListener {
            customDialog.dismiss()
        }

    }
}