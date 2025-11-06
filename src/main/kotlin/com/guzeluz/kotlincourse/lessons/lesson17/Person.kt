package com.guzeluz.kotlincourse.lessons.lesson17

open class Person(private val name: String, protected val age: Int) {
    // Публичный метод
    fun greet() {
        secret()
        println("Привет, меня зовут $name.")
    }

    // Защищённый метод
    protected fun getName(): String {
        return name
    }

    // Приватный метод
    private fun secret() {
        println("Это секретный метод.")
    }
}

class Student(
    name: String,
    age: Int,
    val studentId: Int
) : Person(name, age) {
    // Публичный метод
    fun study() {
        // Используем защищённый метод getName() из родительского класса
        println("${getName()} (id: $studentId) учится.")
    }

    fun showAge() {
        // Обращаемся к защищённому полю age из родительского класса
        println("Мне $age лет.")
    }

    fun tryAccessSecret() {
//         Попытка вызвать приватный метод secret() из родительского класса
//         secret() // Ошибка компиляции: метод secret() недоступен
    }
}

fun main() {
    val student = Student("Алексей", 20, 12345)
    student.greet()        // Вывод: Это секретный метод. \n Привет, меня зовут Алексей.
    student.study()        // Вывод: Алексей учится.
    student.showAge()      // Вывод: Мне 20 лет.
    println(student.studentId)
//    println(student.name)
//    println(student.age)
//    student.secret()    // Ошибка: метод secret() недоступен
    student.tryAccessSecret()
}