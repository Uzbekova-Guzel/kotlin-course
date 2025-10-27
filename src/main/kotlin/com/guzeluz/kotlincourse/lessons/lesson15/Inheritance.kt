package com.guzeluz.kotlincourse.lessons.lesson15

// Основной класс Транспортное средство
open class Vehicle(
    val maxWeight: Int,
    val passengerCapacity: Int,
    val serialNumber: String
) {
    open fun startMovement() {
        println("Транспортное средство начало движение.")
    }

    open fun stopMovement() {
        println("Транспортное средство остановлено.")
    }
}

// Класс Колёсное транспортное средство, наследующийся от Транспортного средства
open class WheeledVehicle(
    maxWeight: Int,
    passengerCapacity: Int,
    serialNumber: String,
    val wheelCount: Int
) : Vehicle(maxWeight, passengerCapacity, serialNumber)

// Класс Автомобиль, наследующийся от Колёсного транспортного средства
class Car(
    maxWeight: Int,
    passengerCapacity: Int,
    serialNumber: String,
    val engineType: String,
    val bodyType: String
) : WheeledVehicle(maxWeight, passengerCapacity, serialNumber, 4) {
    fun turnOnLights() {
        println("Габариты включены.")
    }
    fun turnOffLights() {
        println("Габариты выключены.")
    }
    fun activateTurnSignal(direction: String) {
        println("Поворотник включен: $direction")
    }
    fun activateWipers() {
        println("Стеклоочистители включены.")
    }
}

// Класс Велосипед, наследующийся от Колёсного транспортного средства
class Bicycle(
    maxWeight: Int,
    passengerCapacity: Int,
    serialNumber: String
) : WheeledVehicle(maxWeight, passengerCapacity, serialNumber, 2) {
    fun pedal() {
        println("Педали крутятся.")
    }
}

// Класс Летательные аппараты
open class Aircraft(
    maxWeight: Int,
    passengerCapacity: Int,
    serialNumber: String,
    val flightAltitude: Int
) : Vehicle(maxWeight, passengerCapacity, serialNumber) {
    fun increaseAltitude(amount: Int) {
        println("Высота увеличена на $amount метров.")
    }
    fun decreaseAltitude(amount: Int) {
        println("Высота уменьшена на $amount метров.")
    }
}

// Класс Самолёт, наследующийся от Летательного аппарата
class Airplane(
    maxWeight: Int,
    passengerCapacity: Int,
    serialNumber: String,
    flightAltitude: Int
) : Aircraft(maxWeight, passengerCapacity, serialNumber, flightAltitude)
// Класс Вертолёт, наследующийся от Летательного аппарата
class Helicopter(
    maxWeight: Int,
    passengerCapacity: Int,
    serialNumber: String,
    flightAltitude: Int
) : Aircraft(maxWeight, passengerCapacity, serialNumber, flightAltitude)

fun main() {
    val car = Car(
        400,
        5,
        "sf",
        "DVS",
        "cabriolet")
    car.startMovement()
}

/*
Объяснение abstract и open классов
abstract класс — это базовый класс, из которого нельзя создавать объекты
напрямую. Он содержит абстрактные методы (без реализации),
которые должны быть реализованы в наследниках.
Используется, когда нужно задать общую структуру или обязательные
для реализации методы в производных классах.

open класс — это обычный класс, от которого можно наследоваться.
В отличие от abstract, из open класса можно создавать объекты напрямую.
Он полезен, когда нужно создать базовый класс с реализацией методов,
который можно расширить, но не обязательно реализовать в дочерних классах.

Отличие:

abstract требует реализаций в наследниках
open предоставляет возможность наследования, но не обязует к этому.
Когда применять:

abstract — когда нужен шаблон для будущих классов и строгое
наследование с обязательной реализацией методов.
open — для создания класса, от которого можно наследовать,
добавляя новые функции, но который сам по себе является
завершённой реализацией.
 */



