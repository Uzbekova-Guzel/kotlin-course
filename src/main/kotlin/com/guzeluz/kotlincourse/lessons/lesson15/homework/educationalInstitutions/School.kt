package com.guzeluz.kotlincourse.lessons.lesson15.homework.educationalInstitutions

import com.guzeluz.kotlincourse.lessons.lesson15.homework.geometricFigures.Circle

open class School(
    name: String,
    city: String,
    val level: String
) : EducationalInstitution(name, city) {
    fun schoolInfo() {
        println("This is a $level school named '$name' in $city")
    }
}
