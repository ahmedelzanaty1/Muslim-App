package com.example.muslimapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.muslimapp.databinding.SoraResBinding
import com.example.muslimapp.Data_Class.QuranData
import com.example.muslimapp.Inter_face_callback.OnCharacterClick

class QuranAdapter(val data: List<QuranData>) :Adapter<QuranAdapter.QuranViewHolder>(){
    var Onclick : OnCharacterClick? = null
    class QuranViewHolder(Binding:SoraResBinding ) : RecyclerView.ViewHolder(Binding.root) {
        val soraName = Binding.soraName
        val soranumber = Binding.soraNumber

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuranViewHolder {
        val binding = SoraResBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return QuranViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: QuranViewHolder, position: Int) {
        val list = data[position]
        holder.soraName.text = list.soraName
        holder.soranumber.text = list.soranumber.toString()
        holder.itemView.setOnClickListener {
            Onclick?.OnClickItem(list,position)
        }







    }
}