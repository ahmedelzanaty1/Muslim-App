package com.example.muslimapp.Inter_face_callback

import com.example.muslimapp.Data_Class.QuranData

interface OnCharacterClick {
    fun OnClickItem(character : QuranData, position: Int)
}