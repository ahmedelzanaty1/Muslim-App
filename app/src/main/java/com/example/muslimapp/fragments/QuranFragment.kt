package com.example.muslimapp.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.muslimapp.Models.Constants
import com.example.muslimapp.adapters.QuranAdapter
import com.example.muslimapp.databinding.FragmentQuranBinding
import com.example.muslimapp.Data_Class.QuranData
import com.example.muslimapp.Inter_face_callback.OnCharacterClick
import com.example.muslimapp.SoraDetailsActivity


class QuranFragment : Fragment() {
    lateinit var binding: FragmentQuranBinding
    lateinit var adapter: QuranAdapter
    lateinit var data: MutableList<QuranData>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentQuranBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init(view)
    }
     fun init(view:View) {
        val content = Constants.constants
        val chapterdatalist = mutableListOf<QuranData>()
        content.forEachIndexed { index, s ->
            chapterdatalist.add(QuranData(s, index + 1))

        }


        adapter = QuranAdapter(chapterdatalist)
         onclick()
        binding.recyclerView.adapter = adapter


    }
    fun onclick(){
        adapter.Onclick = object : OnCharacterClick {
            override fun OnClickItem(itemview: QuranData, position: Int) {
                val intent = Intent(requireContext(), SoraDetailsActivity::class.java)
                intent.putExtra("title", itemview.soraName)
                intent.putExtra("position", position)
                startActivity(intent)


            }
            }
    }



}