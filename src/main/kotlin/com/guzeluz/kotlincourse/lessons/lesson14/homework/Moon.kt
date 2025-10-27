package com.guzeluz.kotlincourse.lessons.lesson14.homework

/*
3. Природное явление: луна.
Создайте объект Moon, который будет представлять Луну.
Добавьте свойства isVisible (Boolean), чтобы отображать,
видна ли Луна в данный момент,
и phase (String), чтобы отображать текущую фазу Луны
(например, "Full Moon", "New Moon").
Добавьте метод showPhase(), который выводит текущую фазу Луны.
 */

object Moon {
    val isVisible: Boolean = true
    val phase: String = "Full Moon"

    fun showPhase() {
        if (isVisible) println("The Moon is visible, phase - $phase") else println("The Moon isn't visible")
    }
}

fun main() {
    Moon.showPhase()
}