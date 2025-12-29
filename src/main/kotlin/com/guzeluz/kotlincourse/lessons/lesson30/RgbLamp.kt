package com.guzeluz.kotlincourse.lessons.lesson30

class RgbLamp() {

    private var red = "00"
    private var green = "00"
    private var blue = "00"
    private var isOn = false

    /**
     * Включает лампу.
     * Возвращает true если была выключена
     */
    fun powerOn() = !isOn.also { isOn = true }

    /**
     * Выключает лампу.
     * Возвращает true если была включена
     */
    fun powerOff() = isOn.also { isOn = false }

    /**
     * Устанавливает уровень красного
     * Принимает двузначное шестнадцатиричное значение от "00" до "FF".
     * Если передаётся однозначное, то оно дублируется в двузначное.
     * Например "3" дублируется в "33"
     * Метод выбрасывает исключение IllegalArgumentException если передано не
     * шестнадцатиричное значение.
     * Метод преобразует все символьные значения к верхнему регистру.
     */
    fun setRed(hexValue: String) = hexValue.setColor { red = it }

    fun setGreen(hexValue: String) = hexValue.setColor { green = it }

    fun setBlue(hexValue: String) = hexValue.setColor { blue = it }

    fun getColor() = if (isOn) "#$red$green$blue" else "#000000"

    private fun String.setColor(fnc: (String) -> Unit) {
        if (!isOn) return
        checkHex()
        fnc(normalize())
    }

    private fun String.normalize(): String {
        return when (length) {
            1 -> repeat(2)
            else -> this
        }.uppercase()
    }

    private fun String.checkHex() {
        val valid = "[0-9a-fA-F]{1,2}".toRegex()
        if (!valid.matches(this)) {
            throw IllegalArgumentException("$this is not a hexadecimal value")
        }
    }
}
