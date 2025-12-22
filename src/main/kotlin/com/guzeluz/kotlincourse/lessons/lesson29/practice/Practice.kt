package com.guzeluz.kotlincourse.lessons.lesson29.practice

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import java.io.File

fun main() {
    val student1 = Student("John", "Doe", 20, Gender.MALE)
    val student2 = Student("Jane", "Doe", 19, Gender.FEMALE)
    val faculty = Faculty("Engineering", "Dr. Smith", 1965, listOf(student1, student2))
    val university = University("Tech University", 1905, listOf(faculty))

    val gson = GsonBuilder().setPrettyPrinting().create()
    gson.toJson(university).also { File("src/main/resources/university.json").writeText(it) }

    jsonToUniversuty()
}

fun jsonToUniversuty() {
    val json = File("src/main/resources/university.json").readText()
    val gson = Gson()
    val universityDeserialized = gson.fromJson(json, University::class.java)
    universityDeserialized.faculties.forEach {
        it.students.forEach {
            println("${it.firstName} ${it.lastName}")
        }
    }
}
