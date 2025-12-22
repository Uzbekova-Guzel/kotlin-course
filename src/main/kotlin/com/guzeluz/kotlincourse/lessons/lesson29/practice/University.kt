package com.guzeluz.kotlincourse.lessons.lesson29.practice

import com.google.gson.annotations.SerializedName

data class University(
    val name: String,
    @SerializedName("established_year") val establishedYear: Int,
    val faculties: List<Faculty>
)
