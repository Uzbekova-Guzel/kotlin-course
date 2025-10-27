package com.guzeluz.kotlincourse.lessons.lesson15.homework.educationalInstitutions

class University(
    name: String,
    city: String,
    val faculties: Int
) : EducationalInstitution(name, city) {

    fun universityInfo() {
        println("University '$name' in $city has $faculties faculties")
    }
}
