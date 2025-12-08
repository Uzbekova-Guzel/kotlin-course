package com.guzeluz.kotlincourse.lessons.lesson24


//Функции высшего порядка — это функции, которые могут принимать
// другие функции в качестве аргументов или возвращать их в качестве результата.

// Источник ресурса E (топливо, электроэнергия, сжатый воздух,
// корм для тягового животного)
fun interface EnergySource<E> {
    fun provide(): E
}

// Узел, который берёт ресурс E и превращает его в "двигательную мощность" P
// (например: топливо -> крутящий момент вала,
// электроэнергия -> крутящий момент, пар -> поступательное усилие,
// корм -> движение мускулатуры)
fun interface PowerUnit<E, P> {
    fun generate(input: E, quantity: Double): P
}

// Узел, который берёт мощность P и превращает её в "движение" M
// (крутящий момент -> скорость вращения колеса, тяга -> скорость,
// тяга -> подъёмная сила и т.п.)
fun interface MotionSystem<P, M> {
    fun move(input: P): M
}

// Абстрактное транспортное средство:
// E — тип исходного ресурса (топливо, энергия и т.п.)
// P — тип мощности или усилия, которое создаёт силовая установка
// M — тип "движения" на выходе (скорость, тяга, подъёмная сила, что угодно)
abstract class Vehicle<E, P, M>(
    private val energySource: EnergySource<E>,
    private val powerUnit: PowerUnit<E, P>,
    private val motionSystem: MotionSystem<P, M>
) {
    fun performMove(powerQuantity: Double): M {
        val energy: E = energySource.provide()
        val power: P = powerUnit.generate(energy, powerQuantity)
        return motionSystem.move(power)
    }
}

//примитивный пример реализации интерфейсов:
class StringEnergy : EnergySource<String> {
    override fun provide() = "Топливо"
}

class DoublePower : PowerUnit<String, Double> {
    override fun generate(input: String, sourceQuantity: Double): Double {
        return input.map { it.code / 2.0 }.sum() * sourceQuantity
    }
}

class IntMotion : MotionSystem<Double, Int> {
    override fun move(input: Double): Int {
        return input.toInt() / 2
    }
}

class StringIntMobil : Vehicle<String, Double, Int>(
    StringEnergy(),
    DoublePower(),
    IntMotion()
)

//вариант с тем же автомобилем, но теперь вместо контрактов (интерфейсов)
// сразу укажем сигнатуру необходимых функций через лямбда тип:
abstract class LambdaVehicle<E, P, M> (
    private val energySource: () -> E,
    private val powerUnit: (E, Double) -> P,
    private val motionSystem: (P) -> M
) {
    fun performMove(sourceQuantity: Double): M {
        val energy: E = energySource()
        val power: P = powerUnit(energy, sourceQuantity)
        return motionSystem(power)
    }
}

class LambdaInterfaceStringIntMobil : LambdaVehicle<String, Double, Int>(
    StringEnergy()::provide,
    DoublePower()::generate,
    IntMotion()::move
)



fun main() {
    val a = StringIntMobil()
    println(a)
}

