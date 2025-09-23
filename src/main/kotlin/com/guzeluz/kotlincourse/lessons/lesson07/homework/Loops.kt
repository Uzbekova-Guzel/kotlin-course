package com.guzeluz.kotlincourse.lessons.lesson07.homework

fun main() {
//    Задания для цикла for

//    Прямой диапазон
// 1. Напишите цикл for, который выводит числа от 1 до 5.
    for (i in 1..5) {
        println(i)
    }

// 2. Напишите цикл for, который выводит четные числа от 1 до 10.
    for (i in 1..10) {
        if (i % 2 == 0) println(i)
    }

//    Обратный диапазон
// 3. Создайте цикл for, который выводит числа от 5 до 1.
    for (i in 5 downTo 1) {
        println(i)
    }

// 4. Создайте цикл for, который выводит числа от 10 до 1, уменьшая их на 2.
    for (i in 10 downTo 1) {
        println(i / 2)
    }

//    С шагом (step)
// 5. Используйте цикл for с шагом 2 для вывода чисел от 1 до 9.
    for (i in 1..9 step 2) {
        println(i)
    }

// 6. Напишите цикл for, который выводит каждое третье число в диапазоне от 1 до 20.
    for (i in 1..20 step 3) {
        println(i)
    }

//    Использование до (until)
// 7. Создайте числовую переменную 'size'. Используйте цикл for с шагом 2 для вывода чисел от 3 до size не включая size.
    val size = 20
    for (i in 3 until size step 2) {
        println(i)
    }

//    Задания для цикла while

//    Цикл while
// 8. Создайте цикл while, который выводит квадраты чисел от 1 до 5.
    var counter1 = 1
    while (counter1 in 1..5) {
        println(counter1 * counter1)
        counter1++
    }

// 9. Напишите цикл while, который уменьшает число от 10 до 5. После этого вывести результат в консоль
    var counter2 = 10
    while (counter2 in 10 downTo 5) {
        counter2--
        println(counter2)
    }

//    Цикл do while
// 10. Используйте цикл do while, чтобы вывести числа от 5 до 1.
    var counter3 = 5
    do {
        println(counter3)
        counter3--
    } while (counter3 in 5 downTo 1)

// 11. Создайте цикл do while, который повторяется, пока счетчик меньше 10, начиная с 5.
    var counter4 = 5
    do {
        println(counter4)
        counter4++
    } while (counter4 < 10)

//    Задания для прерывания и пропуска итерации
//    Использование break
// 12. Напишите цикл for от 1 до 10 и используйте break, чтобы выйти из цикла при достижении 6.
    for (i in 1..10) {
        if (i == 6) break
        println(i)
    }

// 13. Создайте цикл while, который бесконечно выводит числа, начиная с 1, но прерывается при достижении 10.
    var counter5 = 1
    while (true) {
        println(counter5)
        if (counter5++ == 10) break
    }

//    Использование continue
// 14. В цикле for от 1 до 10 используйте continue, чтобы пропустить четные числа.
    for (i in 1..10) {
        if (i % 2 == 0) continue
        println(i)
    }

// 15. Напишите цикл while, который выводит числа от 1 до 10, но пропускает числа, кратные 3.
    var counter6 = 1
    while (counter6 in 1..10) {
        if (counter6 % 3 == 0) {
            counter6++
            continue
        }
        println(counter6)
        counter6++
    }

    getMultiplicationTable()
    getSum(15)
    getFactorial(3)
    getEvenNumberSum(4)
    buildRectangle()
    getSumOfEvenOddNumbers()
}

//    Задачи повышенной сложности
// 1. Используя вложенный цикл реализовать таблицу умножения
fun getMultiplicationTable() {
    for (i in 1..10) {
        for (j in 1..10) {
            print(String.format("%4d", i * j))
        }
        println()
    }
}

// 2. Напишите функцию, которая суммирует числа от 1 до 'arg' с помощью цикла for. 'arg' - целочисленный аргумент функции.
fun getSum(arg: Int = 10) {
    var sum = 0
    for (i in 1..arg) {
        sum += i
    }
    println(sum)

}

// 3. Напишите функцию, которая вычисляет факториал числа 'arg' с использованием цикла while.
fun getFactorial(arg: Int = 10) {
    var factorial = 1
    var count = 1
    while (count in 1..arg) {
        factorial *= count
        count++
    }
    println(factorial)
}

// 4. Напишите функцию, которая находит сумму всех четных чисел от 2 до 'arg', используя цикл while.
fun getEvenNumberSum(arg: Int = 10) {
    var count2 = 2
    var sumEvenNumbers = 0
    while (count2 in 2..arg) {
        if (count2 % 2 == 0) sumEvenNumbers += count2
        count2++
    }
    println(sumEvenNumbers)
}

// 5. Напишите функцию, которая используя вложенные циклы while, выведет заполненный прямоугольник размером 5x3 из символов *.
fun buildRectangle(width: Int = 5, height: Int = 3) {
    var i = 1
    while (i in 1..height) {
        var j = 1
        while (j in 1..width) {
            print('*')
            j++
        }
        println()
        i++
    }
}

// 6. Напишите функцию, которая используя цикл for найдёт суммы чётных и нечётных значений чисел от 1 до arg.
fun getSumOfEvenOddNumbers(arg: Int = 10) {
    var evenSum = 0
    var oddSum = 0
    for (i in 1..arg) {
        if (i % 2 == 0) evenSum += i else oddSum += i
    }
    println("Sum of even numbers = $evenSum\nSum of odd numbers = $oddSum")
}