package com.guzeluz.kotlincourse.lessons.lesson14.homework

/*
2. Аспект реальности: эмоция.
Создайте класс Emotion, который представляет эмоцию.
У него должно быть свойство type (String) и intensity (Int).
Добавьте метод express(), который выводит описание эмоции в зависимости
от её типа и интенсивности.
 */

class Emotion(val type: String, val intensity: Int) {
    fun express() {
        println("Emotion: $type\nIntensity: $intensity")
    }
}

fun main() {
    val emotion = Emotion("Happiness", 100)
    emotion.express()
}