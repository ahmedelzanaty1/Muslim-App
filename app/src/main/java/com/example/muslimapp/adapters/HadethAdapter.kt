package com.example.muslimapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.muslimapp.Data_Class.HadethData
import com.example.muslimapp.Inter_face_callback.OnHadethClick
import com.example.muslimapp.databinding.QuranDetailsBinding

class HadethAdapter(val data: List<HadethData>): RecyclerView.Adapter<HadethAdapter.HadethViewHolder>(){
    var onitemclick : OnHadethClick? = null
    class HadethViewHolder(val binding: QuranDetailsBinding): RecyclerView.ViewHolder(binding.root){
        val text = binding.details
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HadethViewHolder {
        val context = parent.context
        val binding = QuranDetailsBinding.inflate(LayoutInflater.from(context),parent,false)
        return HadethViewHolder(binding)

    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: HadethViewHolder, position: Int) {
        val list = data[position]
        holder.text.text = list.hadethname
        holder.itemView.setOnClickListener {
            onitemclick?.OnHadeth(list,position)
        }

    }
}