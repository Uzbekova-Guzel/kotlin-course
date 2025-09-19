package com.guzeluz.kotlincourse.lessons.lesson06.homework

//Задание 1: "Определение сезона"
//Напишите функцию, которая на основе номера месяца распечатывает сезон года. Номера месяцев начинаются с единицы.

fun defineSeason(numberOfMonth: Int) {
    val monthSeason = when (numberOfMonth) {
        12, 1, 2 -> "Winter"
        in 3..5 -> "Spring"
        in 6..8 -> "Summer"
        in 9..11 -> "Autumn"
        else -> "There is only 12 months in the Earth!"
    }
    println(monthSeason)
}


//Задание 2: "Расчет возраста питомца"
//Создайте функцию, которая преобразует возраст собаки в "человеческие" годы.
// До 2 лет каждый год собаки равен 10.5 человеческим годам, после - каждый год равен 4 человеческим годам.
// Результат распечатай в консоль.

fun convertDogAgeToHuman(dogAge: Int) {
    if (dogAge in 0..2) {
        println(dogAge * 10.5)
    } else if (dogAge > 2) {
        println(dogAge * 4)
    } else {
        println("It's not dog age!")
    }
}

//Задание 3: "Определение способа перемещения"
//Напишите функцию, которая печатает в консоль,
// какой способ перемещения лучше использовать, исходя из длины маршрута.
// Если маршрут до 1 км - "пешком", до 5 км - "велосипед", иначе - "автотранспорт".

fun routeTransport(roadLength: Int) {
    val result = when (roadLength) {
        in 0..1 -> "пешком"
        in 2..5 -> "велосипед"
        else -> "автотранспорт"
    }
    println(result)
}

//Задание 4: "Расчет бонусных баллов"
//Клиенты интернет-магазина получают бонусные баллы за покупки.
// Напишите функцию, которая принимает сумму покупки и
// печатает в консоль количество бонусных баллов:
// 2 балла за каждые 100 рублей при сумме покупки до 1000 рублей и
// 3 балла за каждые 100 рублей при сумме свыше этого.

fun bonusCalculation(purchaseCost: Int) {
    val result = when (purchaseCost) {
        in 0..1000 -> purchaseCost / 100 * 2
        in 1000..Int.MAX_VALUE -> purchaseCost / 100 * 2
        else -> "Wrong mount"
    }
    println(result)
}

//Задание 5: "Определение типа документа"
//В системе хранения документов каждый файл имеет расширение.
// Напишите функцию, которая на основе расширения файла печатает в консоль его тип:
// "Текстовый документ", "Изображение", "Таблица" или "Неизвестный тип".

fun documentType(fileExtension: String) {
    val textDocument: Array<String> = arrayOf(".txt", ".doc", ".docx", ".odt", ".rtf", ".pdf")
    val image: Array<String> = arrayOf(".jpg", ".jpeg", ".png", ".gif", ".bmp", ".tiff", ".svg")
    val table: Array<String> = arrayOf(".xls", ".xlsx", ".ods", ".csv", ".tsv")

    val result = when (fileExtension) {
        in textDocument -> "Текстовый документ"
        in image -> "Изображение"
        in table -> "Таблица"
        else -> "Неизвестный тип"
    }
    println(result)
}

//Задание 6: "Конвертация температуры"
//Создайте функцию, которая конвертирует температуру из градусов Цельсия в Фаренгейты и
// наоборот в зависимости от указанной единицы измерения (C/F).
// Единицу измерения нужно передать вторым аргументом функции.
// Несколько аргументов передаются через запятую.
// Распечатай в консоль результат конвертации с добавлением единицы измерения.
// Чтобы добавить единицу измерения после результата, используй
// функцию печати без переноса строки print("C") или print("F").

fun temperatureConversion(temperature: Int, unitOfMeasure: Char) {
    when (unitOfMeasure) {
        'C' -> {
            print((temperature * 1.8) + 32)
            println('F')
        }

        'F' -> {
            print((temperature - 32) * 0.55)
            println('C')
        }

        else -> {
            println("Wrong character")
        }
    }
}


//Задание 7: "Подбор одежды по погоде"
//Напишите функцию, которая на основе температуры воздуха рекомендует тип одежды:
// "куртка и шапка" при температуре ниже +10,
// "ветровка" от +10 до +18 градусов включительно и
// "футболка и шорты" при температуре выше +18 градусов.
// При температурах ниже -30 и выше +35 рекомендуйте не выходить из дома.

fun choosingClothes(temperature: Float) {
    if (temperature < -30.0 || temperature > 35.0) {
        println("оставайся дома!")
    } else if (temperature < 10.0) {
        println("куртка и шапка")
    } else if (temperature in 10.0..18.0) {
        println("ветровка")
    } else {
        println("футболка и шорты")
    }
}


//Задание 8: "Выбор фильма по возрасту"
//Кинотеатр предлагает фильмы разных возрастных категорий.
// Напишите функцию, которая принимает возраст зрителя и
// возвращает доступные для него категории фильмов:
// "детские" (от 0 до 9), "подростковые" (от 10 до 18), "18+" для остальных.

fun movieByAge(age: Int) {
    val result = when (age) {
        in 0..9 -> "детские"
        in 10 until 17 -> "подростковые"
        in 18..Int.MAX_VALUE -> "полный доступ"
        else -> "возраст не может быть отрицательным!"
    }
    println(result)
}

fun main() {
    defineSeason(5)
    convertDogAgeToHuman(2)
    routeTransport(4)
    bonusCalculation(999)
    documentType(".gif")
    temperatureConversion(16, 'C')
    choosingClothes(41.3f)
    movieByAge(45)
}
