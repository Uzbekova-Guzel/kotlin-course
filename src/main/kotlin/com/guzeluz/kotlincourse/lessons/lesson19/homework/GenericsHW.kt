package com.guzeluz.kotlincourse.lessons.lesson19.homework

import javax.swing.text.Element

//1 Напиши функцию getMiddleElement с дженериком,
// которая будет принимать список и
// возвращать средний элемент, если он существует, иначе возвращать null.
// Например, у списка из четырёх элементов - среднего элемента нет.

fun <A> getMiddleElement(list: List<A>): A? {
    if (list.size % 2 != 0) {
        return list[list.size / 2]
    }
    return null
}

//2 Напиши класс ListHolder, который будет хранить список элементов типа T и
// иметь метод для добавления нового элемента и
// получения всех элементов в виде неизменяемого списка.

class ListHolder<T>() {
    private val list = mutableListOf<T>()

    fun add(element: T): List<T> {
        list.add(element)
        return list.toList()
    }

    fun get(): List<T> {
        return list.toList()
    }
}

//3 Создай интерфейс Mapper с двумя дженериками,
// который будет определять методы для преобразования:
//1) элементов одного типа в элементы другого типа
//2) списка элементов одного типа в список элементов другого типа.

interface Mapper<A, B> {
    fun replaceElement(element: A): B
    fun replaceList(list: List<A>): List<B>
}

//4 Создай класс PhrasesToListOfStrings и
// имплементируй интефрейс Mapper с типами String и List<String>.
// 1) Метод преобразования должен разбивать входящую строку по символу пробела и
// возвращать список из полученных слов.
// 2) Метод преобразования списков с аналогичной механикой.

class PhrasesToListOfStrings : Mapper<String, List<String>> {
    override fun replaceElement(element: String): List<String> {
        return element.split(" ")
    }

    override fun replaceList(list: List<String>): List<List<String>> {
        return list.map { it.split(" ") }
    }
}


//5 Создай функцию transposition с двумя дженериками,
// которая принимает словарь с дженериками и возвращает словарь,
// в котором ключ и значения поменялись местами.
fun <A, B> transposition(map: Map<A, B>): Map<B, A> {
    val newMap = mutableMapOf<B, A>()
    map.forEach { newMap[it.value] = it.key }
    return newMap
}

//6 Напиши интерфейс Validator с дженериком с функцией валидации,
// которая будет принимать элемент с типом дженерика и возвращать булево значение.
interface Validator<A> {
    fun validate(element: A): Boolean
}

//7 Создай класс StringValidator и
// имплементируй интерфейс Validator с типом String?.
// Реализуй проверку, что строка не является null,
// не пустая и не состоит из одних пробелов.
class StringValidator : Validator<String?> {
    override fun validate(element: String?): Boolean {
        return element?.isNotBlank() ?: false
    }
}

//8 Создай класс OddValidator и имплементируй интерфейс Validator
// типизированный по Int. Реализуй проверку, что число чётное.
class OddValidator : Validator<Int> {
    override fun validate(element: Int): Boolean {
        return element % 2 == 0
    }
}

//9 Создай класс ListValidator с дженериком, ограниченным типом Number,
// имплементируй интерфейс Validator типизированный по типу List с
// nullable типом дженерика класса.
//Реализуй проверку:
//- Ни один элемент списка не является null
//- Ни один элемент приведённый к типу Double не равен 0.0
class ListValidator<A : Number> : Validator<List<A?>> {
    override fun validate(element: List<A?>): Boolean {
        return element.all { it != null && it.toDouble() != 0.0 }
    }
}
