package com.guzeluz.kotlincourse.lessons.lesson18.homework

import java.io.InputStream

interface Powerable {
    fun powerOn()
    fun powerOff()
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

interface Programmable {
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
    fun getChargeLevel(): Double
    fun recharge()
}

//Задача 1. Создай абстрактные классы устройств,
// используя эти интерфейсы. Реализовывать методы не нужно.

//Холодильник
abstract class Fridge : Powerable, Openable, TemperatureRegulatable

//Стиральная машина
abstract class WashingMachine : Powerable, Openable, Programmable, Cleanable

//Умная лампа
abstract class SmartLamp : Timable, BatteryOperated, LightEmitting, Rechargeable

//Электронные часы
abstract class ElectronicClock : Timable, BatteryOperated, SoundEmitting, Programmable, Rechargeable

//Робот-пылесос
abstract class RobotVacuumCleaner : Powerable, Openable, WaterContainer, WaterConnection, AutomaticShutdown, Drainable,
    Timable, BatteryOperated, Programmable, Movable, Cleanable, Rechargeable

//Механические часы
abstract class MechanicalClock : Timable, Mechanical, SoundEmitting

//Фонарик
abstract class Flashlight : LightEmitting, BatteryOperated, Rechargeable

//Кофемашина
abstract class CoffeeMachine : Powerable, Openable, WaterContainer, AutomaticShutdown, Programmable, Cleanable

//Умная колонка
abstract class SmartSpeaker : Powerable, Timable, BatteryOperated, SoundEmitting, Programmable, Rechargeable
