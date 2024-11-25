package com.example.muslimapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.muslimapp.databinding.ActivitySoraDetailsBinding
import com.example.muslimapp.databinding.QuranDetailsBinding

class DetailsAdapter(val data: List<String>) : RecyclerView.Adapter<DetailsAdapter.DetailsViewHolder>() {
    class DetailsViewHolder(Binding: QuranDetailsBinding) : RecyclerView.ViewHolder(Binding.root) {
        val text = Binding.details
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailsViewHolder {
        val binding = QuranDetailsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DetailsViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: DetailsViewHolder, position: Int) {
        val list = data[position]
        holder.text.text = list


    }
}