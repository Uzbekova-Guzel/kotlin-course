package com.guzeluz.kotlincourse.lessons.lesson15.homework.educationalInstitutions.schools

import com.guzeluz.kotlincourse.lessons.lesson15.homework.educationalInstitutions.School

class SecondarySchool(
    name: String,
    city: String,
    val hasProfileClasses: Boolean
) : School(name, city, "secondary") {

    fun secondarySchoolInfo() {
        val profile = if (hasProfileClasses) "has profile classes" else "no profile classes"
        println("Secondary school '$name' $profile")
    }
}
