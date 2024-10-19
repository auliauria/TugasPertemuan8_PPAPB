package com.example.tugaspertemuan8

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.textfield.TextInputEditText

class RegisterFragment : Fragment() {
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_register, container, false)

        val etUsername = view.findViewById<TextInputEditText>(R.id.username)
        val etEmail = view.findViewById<TextInputEditText>(R.id.email)
        val etPhone = view.findViewById<TextInputEditText>(R.id.phone)
        val etPassword = view.findViewById<TextInputEditText>(R.id.password)
        val btnRegister = view.findViewById<Button>(R.id.registerButton)

        sharedPreferences = requireActivity().getSharedPreferences("user_data", AppCompatActivity.MODE_PRIVATE)

        btnRegister.setOnClickListener {
            val username = etUsername.text.toString()
            val email = etEmail.text.toString()
            val phone = etPhone.text.toString()
            val password = etPassword.text.toString()

            // Simpan data ke SharedPreferences
            val editor = sharedPreferences.edit()
            editor.putString("username", username)
            editor.putString("email", email)
            editor.putString("phone", phone)
            editor.putString("password", password)
            editor.apply()

            // Pindah ke HomeActivity
            val intent = Intent(requireActivity(), HomeActivity::class.java)
            startActivity(intent)
        }

        return view
    }
}