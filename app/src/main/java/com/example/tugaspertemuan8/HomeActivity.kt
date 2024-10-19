package com.example.tugaspertemuan8

import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)

        // Find the logout button from the included layout
        val logoutButton = findViewById<ImageButton>(R.id.logout)

        // Set an OnClickListener to the button
        logoutButton.setOnClickListener {
            finish() // This will return to the previous activity
        }
        val tvWelcome = findViewById<TextView>(R.id.welcomeUser)

        // Ambil data dari SharedPreferences
        val sharedPreferences = getSharedPreferences("user_data", MODE_PRIVATE)
        val username = sharedPreferences.getString("username", "")

        // Tampilkan data
        tvWelcome.text = "$username!"

    }
}