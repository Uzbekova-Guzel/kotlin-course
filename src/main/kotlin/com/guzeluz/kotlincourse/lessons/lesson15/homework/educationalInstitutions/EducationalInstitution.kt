package com.guzeluz.kotlincourse.lessons.lesson15.homework.educationalInstitutions

import com.guzeluz.kotlincourse.lessons.lesson15.homework.educationalInstitutions.schools.PrimarySchool
import com.guzeluz.kotlincourse.lessons.lesson15.homework.educationalInstitutions.schools.SecondarySchool

open class EducationalInstitution(
    val name: String,
    val city: String
) {
    fun showInfo() {
        println("Educational Institution: $name, located in $city")
    }

    fun totalStudentsInfo(students: Int) {
        println("Total number of students: $students")
    }
}

fun main() {
    val school = School("№12", "Moscow", "general")
    val primary = PrimarySchool("Sunny School", "Berlin", 4)
    val secondary = SecondarySchool("Lyceum 3", "Kazan", true)
    val university = University("Technical University", "Munich", 6)

    school.schoolInfo()
    school.totalStudentsInfo(500)

    primary.primarySchoolInfo()

    secondary.secondarySchoolInfo()

    university.universityInfo()
}
