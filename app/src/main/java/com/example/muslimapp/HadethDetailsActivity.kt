package com.example.muslimapp

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.muslimapp.adapters.DetailsAdapter
import com.example.muslimapp.databinding.ActivityHadethDetailsBinding

class HadethDetailsActivity : AppCompatActivity() {
    lateinit var binding: ActivityHadethDetailsBinding
    lateinit var adapter: DetailsAdapter
    var hadethname = ""
    var hadethdescription = ""
    var hadethposition = -1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHadethDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
         title = intent.getStringExtra("title")
         hadethdescription = intent.getStringExtra("description").toString()
        binding.hadethName.text = title
        init()

    }

    fun init() {
        adapter = DetailsAdapter(hadethdescription.split("\n"))
        binding.recyclerViewHadeth.adapter = adapter
        binding.backIc.setOnClickListener {
            finish()
        }
    }
}




