package com.guzeluz.kotlincourse.lessons.lesson18

import java.io.InputStream

interface Powerable1 {
    // Абстрактные методы без реализации
    fun turnOn()
    fun turnOff()
}

interface Openable {
    fun open()
    fun close()
}

interface WaterContainer {
    val capacity: Int
    fun fillWater(amount: Int)
    fun getWater(amount: Int)
}

interface TemperatureRegulatable {
    val maxTemperature: Int
    fun setTemperature(temp: Int)
}

interface WaterConnection {
    fun connectToWaterSupply()
    fun getWater(amount: Int)
}

interface AutomaticShutdown {
    val sensorType: String
    val maxSensoredValue: Int
    fun startMonitoring()
}

interface Drainable {
    fun connectToDrain()
    fun drain()
}

interface Timable {
    fun setTimer(time: Int)
}

interface BatteryOperated {
    fun getCapacity(): Double
    fun replaceBattery()
}

interface Mechanical {
    fun performMechanicalAction()
}

interface LightEmitting {
    fun emitLight()
    fun completeLiteEmission()
}

interface SoundEmitting {
    fun setVolume(volume: Int)
    fun mute()
    fun playSound(stream: InputStream)
}

interface Programmable1 {
    fun programAction(action: String)
    fun execute()
}

interface Movable {
    fun move(direction: String, distance: Int)
}

interface Cleanable {
    fun clean()
}

interface Rechargeable {
    fun getCapacity(): Double
    fun recharge()
}

//Используя эти интерфейсы, реализуй абстрактные классы для бытовой техники:

//Электрический чайник - Powerable, WaterContainer, Timable
abstract class Teapot: Powerable1, Openable, WaterContainer, AutomaticShutdown

//Пылесос - Powerable, Movable, Cleanable
abstract class VacuumCleaner: Powerable1, Openable, Cleanable, SoundEmitting

//Портативная колонка - BatteryOperated, SoundEmitting, Rechargeable
abstract class PortableSpeaker: Powerable1, Timable, SoundEmitting, Rechargeable

//Духовка - Powerable, TemperatureRegulatable, Timable, Openable
abstract class Oven: Powerable1, TemperatureRegulatable, Openable, Timable


fun closeObjects(openable: List<Openable>) {
    openable.forEach {
        it.close()
    }
}
