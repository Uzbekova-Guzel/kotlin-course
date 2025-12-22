package com.guzeluz.kotlincourse.lessons.lesson29.homework

data class Employee(
    val name: String,
    val isEmployed: Boolean,
    val birthDate: String,
    val jobTitle: CharacterTypes,
    val subordinates: List<Employee> = emptyList()
)
