package com.guzeluz.kotlincourse.lessons.lesson19

import com.guzeluz.kotlincourse.lessons.lesson11.max

//Работа с классами

//Создайте класс Container с дженериком,
// который будет хранить один элемент типа T и иметь метод для получения этого элемента.
class Container<E>(private val element: E) {
    fun getElement(): E = element
}

//Создайте класс PairBox с двумя дженериками,
// который будет хранить два элемента разных типов и иметь метод для получения словаря,
// в котором первый элемент класса будет ключом а второй значением.
class PairBox<A, B>(val a: A, val b: B) {
    fun getMap(): Map<A, B> {
        return mapOf(a to b)
    }
}

//Напишите класс Multiplier с дженериком, ограниченным типом Number и
// имеющим метод для умножения входящего числа на 2.

class Multiplier<A : Number>() {
    fun multipleByTwo(arg1: A): Double {
        return arg1.toDouble() * 2
    }
}

//Создайте класс NullableBox с дженериком, и метод,
// принимающий nullable аргумент дженерика и проверяющий, является ли аргумент null.
class NullableBox<T>() {
    fun isNull(arg: T?): Boolean {
        return arg == null
    }
}

//Работа с интерфейсами

//Создайте интерфейс Storage с дженериком,
// который будет иметь методы для сохранения и получения элемента типа T.
interface Storage<T> {
    fun save(arg: T)
    fun getArf(): T
}

//Напишите интерфейс Transformer с двумя дженериками,
//который будет определять функцию для преобразования элемента типа T в элемент типа R.
interface Transformer<A, B> {
    fun transform(arg: A): B
}

//Создайте интерфейс PairProcessor с двумя дженериками,
//который будет иметь метод для обработки двух элементов разных типов.
interface PairProcessor<A, B> {
    fun action(arg1: A, arg2: B)
}

//Создайте интерфейс ConnectionDifferent с тремя дженериками и методом,
//который принимает списки разных типов и возвращает список с третьим типом.
interface ConnectionDifferent<A, B, C> {
    fun getTypeC(arg1: List<A>, arg2: List<B>): List<C>
}

//Работа с методами

//Создайте функцию swap с дженериком, которая будет принимать изменяемый список и два индекса и
//возвращать неизменяемый список того же типа, но в котором два элемента по индексам поменяны
//между собой местами.
fun <T> swap(arg1: MutableList<T>, index1: Int, index2: Int): List<T> {
    if (index1 in arg1.indices && index2 in arg1.indices) {
        val list = arg1[index1]
        arg1.add(index1, arg1[index2])
        arg1.add(index2, list)
    }
    return arg1.toList()
}

//Напишите функцию mergeLists с дженериком ограниченным типом Number,
//которая принимает два списка типа T и возвращает список Double с суммой элементов списка.
//Если списки разных размеров то отсутствующие элементы принимать за ноль.
fun <A : Number> mergeLists(list1: List<A>, list2: List<A>): List<Double> {
    val result: MutableList<Double> = mutableListOf()
    val maxSize = max(list1.lastIndex, list2.lastIndex)
    for (i in 0..maxSize) {
        val item = list1.getOrElse(i) { 0 }.toDouble() + list2.getOrElse(i) { 0 }.toDouble()
        result.add(item)
    }
    return result
}

//Создайте функцию toMap с двумя дженериками, которая принимает список одного типа и
//nullable список второго типа и возвращает словарь, где ключи из первого списка,
//а значения из второго. Размер словаря по первому списку.
//Если второй список короче первого, то недостающие элементы заменяются на null.
fun <K, V> toMap(firstList: List<K>, secondList: List<V?>): Map<K, V?> {
    return firstList.indices.associate { firstList[it] to secondList.getOrNull(it) }
}
