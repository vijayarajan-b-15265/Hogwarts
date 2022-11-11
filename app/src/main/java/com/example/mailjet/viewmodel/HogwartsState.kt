package com.example.mailjet.viewmodel

import com.example.mailjet.model.HogwartsDetailsHelper

data class HogwartsState(
    val studentsDetailsList: List<HogwartsDetailsHelper> = listOf()
)
