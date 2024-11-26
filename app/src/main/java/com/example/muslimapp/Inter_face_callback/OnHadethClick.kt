package com.example.muslimapp.Inter_face_callback

import com.example.muslimapp.Data_Class.HadethData

interface OnHadethClick {
    fun OnHadeth(item : HadethData, position : Int)
}