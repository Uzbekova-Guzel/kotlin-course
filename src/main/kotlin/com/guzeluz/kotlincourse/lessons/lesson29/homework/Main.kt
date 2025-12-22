package com.guzeluz.kotlincourse.lessons.lesson29.homework

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import java.io.File

fun main() {
    val frontendTeamLead = Employee(
        name = "Alice",
        isEmployed = true,
        birthDate = "1990-03-12",
        jobTitle = CharacterTypes.TEAM_LEAD,
        subordinates = listOf(
            Employee(
                name = "Bob",
                isEmployed = true,
                birthDate = "1995-06-21",
                jobTitle = CharacterTypes.UX_UI
            ),
            Employee(
                name = "Charlie",
                isEmployed = true,
                birthDate = "1993-11-02",
                jobTitle = CharacterTypes.FRONTEND_DEV
            ),
            Employee(
                name = "Diana",
                isEmployed = true,
                birthDate = "1996-01-17",
                jobTitle = CharacterTypes.QA
            )
        )
    )
    val backendTeamLead = Employee(
        name = "Ethan",
        isEmployed = true,
        birthDate = "1988-09-08",
        jobTitle = CharacterTypes.TEAM_LEAD,
        subordinates = listOf(
            Employee(
                name = "Frank",
                isEmployed = true,
                birthDate = "1992-04-30",
                jobTitle = CharacterTypes.BACKEND_DEV
            ),
            Employee(
                name = "Grace",
                isEmployed = true,
                birthDate = "1994-07-14",
                jobTitle = CharacterTypes.BACKEND_DEV
            ),
            Employee(
                name = "Helen",
                isEmployed = true,
                birthDate = "1991-12-05",
                jobTitle = CharacterTypes.QA
            ),
            Employee(
                name = "Ivan",
                isEmployed = true,
                birthDate = "1989-02-19",
                jobTitle = CharacterTypes.SYSADMIN
            )
        )
    )
    val pm = Employee(
        name = "Michael",
        isEmployed = true,
        birthDate = "1987-05-10",
        jobTitle = CharacterTypes.PM,
        subordinates = listOf(frontendTeamLead, backendTeamLead)
    )
    val crm = Employee(
        name = "Sophia",
        isEmployed = true,
        birthDate = "1991-08-23",
        jobTitle = CharacterTypes.CRM
    )
    val cto = Employee(
        name = "Oliver",
        isEmployed = true,
        birthDate = "1985-01-01",
        jobTitle = CharacterTypes.CTO,
        subordinates = listOf(pm, crm)
    )

    println(cto)
    saveCtoToFile(cto)
    readCtoFromFile()
}

fun saveCtoToFile(cto: Employee) {
    val gson = GsonBuilder().setPrettyPrinting().create()
    gson.toJson(cto).also {
        File("structure.json").writeText(it)
    }
}

fun readCtoFromFile() {
    val gson = Gson()
    val file = File("structure.json")

    if (file.exists()) {
        val jsonText = file.readText()
        val employee: Employee = gson.fromJson(jsonText, Employee::class.java)
        println(employee)
    } else {
        println("Файл structure.json не найден!")
    }
}