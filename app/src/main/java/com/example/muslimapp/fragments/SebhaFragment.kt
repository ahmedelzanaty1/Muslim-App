package com.example.muslimapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.muslimapp.R
import com.example.muslimapp.databinding.FragmentSebhaBinding


class SebhaFragment : Fragment() {
    lateinit var binding : FragmentSebhaBinding
    var counter = 0



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSebhaBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onsebhaclick()
    }

    private fun onsebhaclick() {
        binding.sebhaTasbeh.text = "سبحان الله"
        counter = 0
        binding.sebhaTasbeh.setOnClickListener {
            binding.sebhaNumber.text = counter.toString()
            if (counter < 33) {
                binding.bodySebha.rotation = (360 / 33 * counter).toFloat()
                counter++
                binding.sebhaNumber.text = counter.toString()

                if (counter == 33) {
                    counter = 0
                    binding.sebhaTasbeh.text = "الحمد لله"
                }
            } else if (counter ==33) {
                binding.bodySebha.rotation = (360 / 33 * (counter - 33)).toFloat()
                counter++
                binding.sebhaNumber.text = counter.toString()

                if (counter == 33) {
                    counter = 0
                    binding.sebhaTasbeh.text = "الله أكبر"
                }
            } else if (counter ==33) {
                binding.bodySebha.rotation = (360 / 33 * (counter - 66)).toFloat()
                counter++
                binding.sebhaNumber.text = counter.toString()

                if (counter == 33) {
                    counter = 0
                    binding.sebhaTasbeh.text = "لا إلهَ إلاَّ اللَّه وحْدهُ لاَ شَرِيكَ لهُ"
                }

            }

        }
    }
    }



