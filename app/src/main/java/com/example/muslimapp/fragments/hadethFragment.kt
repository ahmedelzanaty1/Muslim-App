package com.example.muslimapp.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.muslimapp.Data_Class.HadethData
import com.example.muslimapp.HadethDetailsActivity
import com.example.muslimapp.Inter_face_callback.OnHadethClick
import com.example.muslimapp.adapters.HadethAdapter
import com.example.muslimapp.databinding.FragmentHadethBinding


class hadethFragment : Fragment() {
    lateinit var binding: FragmentHadethBinding
    lateinit var adapter : HadethAdapter
    lateinit var datalist: MutableList<HadethData>



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHadethBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init(view)

    }
    fun init(view : View){
        val allfile = requireActivity().assets.open("ahadeth.txt").bufferedReader().use {
            it.readText()
        }
        val hadeth = allfile.trim().split("#")
        datalist = mutableListOf()

        hadeth.forEach {hadeth ->
            val hadethseperated = hadeth.trim().split("\n")
            val title = hadethseperated.get(0)
            val description : String= hadethseperated.subList(1,hadethseperated.size).joinToString()
            val data = HadethData(title,description)
            datalist.add(data)
        }
        adapter = HadethAdapter(datalist)
        onclick()
        binding.recyclerView.adapter = adapter
    }
    fun onclick(){
        adapter.onitemclick= object :OnHadethClick {
            override fun OnHadeth(item: HadethData, position: Int) {
                val intent = Intent(requireContext(), HadethDetailsActivity::class.java)
                intent.putExtra("title",item.hadethname)
                intent.putExtra("description",item.Description)
                startActivity(intent)

            }

        }
    }



}