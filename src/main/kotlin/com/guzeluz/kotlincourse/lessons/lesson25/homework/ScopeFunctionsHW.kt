package com.guzeluz.kotlincourse.lessons.lesson25.homework

/*Задание 1. Функция высшего порядка.
Создайте функцию timeTracker, которая принимает другую функцию в качестве
аргумента и измеряет время её выполнения.
Функция timeTracker должна возвращать затраченное время в миллисекундах.
Для измерения времени используйте System.currentTimeMillis() до и
после выполнения переданной функции.*/
fun timeTracker(fn: () -> Any): Long {
    val start = System.currentTimeMillis()
    fn()
    return System.currentTimeMillis() - start
}

/*Задания для работы со scope функциями
Давайте создадим два класса, которые будут использоваться в заданиях для
демонстрации работы scope функций с преобразованием объектов и инициализацией
или обновлением полей. Классы будут представлять собой Person и Employee,
где Employee может быть создан на основе данных класса Person.

Классы для выполнения заданий:*/

class Person(val name: String, val age: Int) {
    var email: String = ""
}

class Employee(val name: String, val age: Int, val position: String) {
    var email: String = ""
    var department: String = "General"
}

/*Задание 3: Использование also для логирования.
Создайте функцию, принимающую объект Person и выводящую информацию об объекте
в консоль в красивом, отформатированном виде.
Используй with для создания контекста Person и
возможности использовать поля объекта напрямую без обращения к переменной.
Создайте объект Person и используйте also для добавления почты и
печати данных в консоль с помощью метода который только что создали.*/
fun personInfo(person: Person) {
    with(person) {
        println(
            """
            Name: $name
            Age: $age
            Email: $email
            """.trimIndent()
        )
    }
}

/*Задание 6: Использование let для безопасного преобразования Person в Employee.
Создайте функцию toEmployee, которая расширяет класс Person,
который может быть null.
В функции используйте функцию let для создания Employee,
только если объект Person не null. В противном случае возвращается null*/
fun Person?.toEmployee(position: String, depart: String): Employee? {
    return this?.let {
        Employee(it.name, it.age, position).apply {
            email = it.email
            department = depart
        }
    }
}

fun main() {
    //1
    val myFunction = {
        val list = List(10000000) { (0..10000).random() }
        list.sorted()
    }
    println(timeTracker(myFunction))

    /*Задание 2: Использование apply для инициализации объекта Employee.
    Создайте объект Employee и используйте apply для инициализации его
    полей email и department.*/
    val employee = Employee("Mike", 30, "Senior QA Engineer").apply {
        email = "mike.QA@gmail.com"
        department = "Marketplace Development"
    }

    //3
    val person = Person("Mark", 28).also {
        it.email = "mark.QA@gmail.com"
        personInfo(it)
    }

    /*Задание 4: Использование with для преобразования Person в Employee.
    Создайте объект класса Person.
    Используйте функцию with, чтобы создать из этого объекта Employee,
    указав дополнительно должность.
    Возвращаемым значением должен быть новый объект Employee.*/
    val person1 = Person("Eva", 35).apply {
        email = "eva.QA@gmail.com"
    }
    val employee1 = with(person1) {
        Employee(name, age, "QA Engineer").also {
            it.email = email
            it.department = "Payment Department"
        }
    }

    /*Задание 5: Использование run для преобразования и инициализации Employee.
    Перепиши предыдущую задачу на использование run вместо with.*/
    val employee11 = person1.run {
        Employee(name, age, "QA Engineer").also {
            it.email = email
            it.department = "Payment Department"
        }
    }
}
