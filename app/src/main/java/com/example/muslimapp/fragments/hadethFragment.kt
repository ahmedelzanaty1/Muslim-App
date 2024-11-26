package com.example.muslimapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.muslimapp.R
import com.example.muslimapp.adapters.DetailsAdapter
import com.example.muslimapp.databinding.FragmentHadethBinding


class hadethFragment : Fragment() {
    lateinit var binding: FragmentHadethBinding
    lateinit var adapter : DetailsAdapter
    lateinit var title : MutableList<String>
    lateinit var desc : MutableList<String>


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
        title = mutableListOf()
        desc = mutableListOf()
        hadeth.forEach {hadeth ->
            val hadethseperated = hadeth.trim().split("\n")
            title.add(hadethseperated[0])
            desc.add(hadeth)
        }
        adapter = DetailsAdapter(title)
        binding.recyclerView.adapter = adapter


    }



}