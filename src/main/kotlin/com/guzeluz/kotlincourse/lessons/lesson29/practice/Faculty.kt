package com.guzeluz.kotlincourse.lessons.lesson29.practice

import com.google.gson.annotations.SerializedName

data class Faculty(
    val name: String,
    val dean: String,
    @SerializedName("launch_year") val launchYear: Int,
    val students: List<Student>
)
