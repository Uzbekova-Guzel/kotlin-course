package com.guzeluz.kotlincourse.lessons.lesson15.homework.educationalInstitutions.schools

import com.guzeluz.kotlincourse.lessons.lesson15.homework.educationalInstitutions.School

class PrimarySchool(
    name: String,
    city: String,
    val grades: Int
) : School(name, city, "primary") {

    fun primarySchoolInfo() {
        println("Primary school '$name' has $grades grades")
    }
}
