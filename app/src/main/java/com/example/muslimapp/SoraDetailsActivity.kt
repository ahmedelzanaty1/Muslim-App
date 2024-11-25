package com.example.muslimapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.muslimapp.adapters.DetailsAdapter
import com.example.muslimapp.databinding.ActivitySoraDetailsBinding

class SoraDetailsActivity : AppCompatActivity() {
    lateinit var binding: ActivitySoraDetailsBinding
    lateinit var adapter: DetailsAdapter
    var position = -1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySoraDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val title = intent.getStringExtra("title")
        position = intent.getIntExtra("position", 0)
        binding.soraName.text = title
        init()
        binding.backIc.setOnClickListener {
            finish()
        }
    }
    fun init() {
        val content = assets.open("${position+1}.txt").bufferedReader().use { it.readText() }
        val list = content.split("\n")

        adapter = DetailsAdapter(list)
        binding.recyclerView.adapter = adapter



    }
}