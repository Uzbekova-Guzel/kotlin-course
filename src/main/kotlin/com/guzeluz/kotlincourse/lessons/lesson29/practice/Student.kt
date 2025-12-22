package com.guzeluz.kotlincourse.lessons.lesson29.practice

import com.google.gson.annotations.SerializedName

data class Student(
    @SerializedName("first_name") val firstName: String,
    @SerializedName("last_name") val lastName: String,
    val age: Int,
    val gender: Gender
)
