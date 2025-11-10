package com.guzeluz.kotlincourse.lessons.lesson17.homework

abstract class BaseClass(
    // 1. объясни, почему это поле доступно в main() для чтения из класса ChildrenClass
    // В классе ChildrenClass объявлена новая переменная с таким же именем, то есть это две разные переменные.
    private val privateVal: String,

    // 2. объясни, почему это поле недоступно в main()
    //Модификатор доступа protected дает доступ к полю из класса и из его дочерних классов.
    // В main() не доступен, но в дочернем классе можно создать метод и использовать его как интерфейс.
    protected val protectedVal: String,
    val publicVal: String
) {
    var publicField = "3. измени меня из функции main() на Антонио Бандераса и проверь через функцию getAll()" +
            "4. Доработай ChildrenClass таким образом, чтобы это получилось"
        //Переопределен метод verifyPublicField в ChildrenClass и проверен в main()
        set(value) {
            if (verifyPublicField(value)) {
                field = value
            }
        }
    protected var protectedField = "5. измени меня из функции main() через сеттер в наследнике"
    //Добавлен метод setProtectedFieldValue() в ChildrenClass и проверен в main()

    private var privateField = "6. добавь сеттер чтобы изменить меня из main()"
    // Эту задачу нельзя выполнить, так как модификатор доступа private у поля означает, что поле доступно только внутри данного класса.
    // Ни наследники, ни main() это поле не видят.

    fun getAll(): String {
        return mapOf(
            "privateVal" to privateVal,
            "protectedVal" to protectedVal,
            "publicVal" to publicVal,
            "publicField" to publicField,
            "protectedField" to protectedField,
            "privateField" to privateField,
            "generate" to generate(),
        ).map { "${it.key}: ${it.value}" }
            .joinToString("\n")
    }

    fun printText() {
        privatePrint()
    }

    // 7. объясни, почему эта функция не может быть публичной
    // Будет ошибка конфликта доступов.
    // Класс ProtectedClass() имеет модификатор доступа protected, и поэтому данная функция должна быть protected.
    protected open fun getProtectedClass() = ProtectedClass()
    protected open fun verifyPublicField(value: String): Boolean {
        return value.length < 3
    }

    // 8. Распечатай getAll() и объясни, почему в поле "generate" другой текст
    // Метод generate() переопределен в дочернем классе с другим значением.
    open fun generate(): String {
        return "Это генерация из родительского класса"
    }

    private fun privatePrint() {
        println("Печать из класса BaseClass")
    }

    // 9. объясни, почему эта функция не может быть публичной или protected
    // Приватный класс, доступен только внутри родительского класса.
    private fun getPrivateClass() = PrivateClass()

    protected class ProtectedClass() {}

    private class PrivateClass() {}
}

class ChildrenClass(
    val privateVal: String,
    protectedVal: String,
    // 10. объясни, почему этот аргумент доступен в main() несмотря на то, что это не поле
    //Аргумент конструктора, не являющийся полем
    publicVal: String
) : BaseClass(privateVal, protectedVal, publicVal) {
    // 11. объясни, почему в main() доступна функция getAll() хотя её здесь нет
    // Метод getAll() имеет публичный модификатор доступа, и это позволяет дочернему классу иметь доступ к нему.

    // 12. проверь, что выводится на печать при вызове функции printText()
    // и объясни, почему не происходит переопределение метода privatePrint()
    // Метод printText() имеет модификатор доступа private, и потому у дочернего класса нет доступа к нему.
    private fun privatePrint() {
        println("Печать из класса ChildrenClass")
    }

    override fun generate(): String {
        return "Это генерация из дочернего класса"
    }

    // К заданию 4
    override fun verifyPublicField(value: String): Boolean {
        return value.length < 50
    }

    // К заданию 5
    fun setProtectedFieldValue(value: String) {
        protectedField = value
    }
}

fun main() {
    //К заданиям 3-4
    val childrenClass = ChildrenClass("one", "two", "three")
    childrenClass.publicField = "Антонио Бандерас"
    println(childrenClass.getAll())

    //К заданию 5
    childrenClass.setProtectedFieldValue("This is new string")
    println(childrenClass.getAll())

    //К заданию 12
    childrenClass.printText()
}
