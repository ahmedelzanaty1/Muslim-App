package com.example.muslimapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.muslimapp.databinding.ActivityHomeBinding
import com.example.muslimapp.fragments.QuranFragment
import com.example.muslimapp.fragments.RadioFragment
import com.example.muslimapp.fragments.SebhaFragment
import com.example.muslimapp.fragments.hadethFragment

class HomeActivity : AppCompatActivity() {
    lateinit var Binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(Binding.root)
        Binding.btnNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.quran -> pushfragment(QuranFragment())
                R.id.hadeth -> pushfragment(hadethFragment())
                R.id.sebha -> pushfragment(SebhaFragment())
                R.id.radio -> pushfragment(RadioFragment())

            }
            return@setOnItemSelectedListener true
        }
        Binding.btnNav.selectedItemId = R.id.quran


    }
    fun pushfragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()

    }
}