package com.guzeluz.kotlincourse.lessons.lesson13.homework

fun main() {
//    1. Дан словарь с именем и временем выполнения
//    каждого автоматизированного теста в секундах.
//    Определите среднее время выполнения теста.
    val autotestTime = mapOf("Test1" to 1.3, "Test2" to 0.15, "Test2" to 2.33)
    println(autotestTime.values.average())

//    2. Имеется словарь с метаданными автоматизированных тестов,
//    где ключи — это имена тестовых методов,
//    а значения - строка с метаданными.
//    Выведите список всех тестовых методов.
    val autotestMeta = mapOf("Test1" to "Smth1", "Test2" to "Smth2")
    println(autotestMeta.keys)

//    3. В изменяемый словарь с данными о прохождении тестов
//    добавьте новый тест и его результат.
    val autotestReport = mutableMapOf("Test1" to "passed", "Test2" to "failed")
    autotestReport["Test3"] = "passed"
    println(autotestReport)

//    4. Посчитайте количество успешных тестов в словаре с результатами
//    (ключ - название, значение - результат из passed, failed, skipped).
    println(autotestReport.count { it.value == "passed" })

//    5. Удалите из изменяемого словаря с баг-трекингом запись о баге,
//    который был исправлен (ключ - название, значение - статус исправления).
    val bugTrekking = mutableMapOf("bug1" to "created", "bug2" to "fixed", "bug3" to "duplicated")
    bugTrekking.remove("bug2")
    println(bugTrekking)

//    6. Для словаря с результатами тестирования веб-страниц
//    (ключ — URL страницы, значение — статус ответа),
//    выведите сообщение о странице и статусе её проверки.
    val webAutotestReport = mapOf(
        "https://stimmax.ru/course/kotlin-dlya-nachinayuschikh/2025-09-02" to "200 OK",
        "https://stimmax.ru/history/1223/read" to "200 OK"
    )
    webAutotestReport.forEach {
        println("${it.key}, ${it.value}")
    }
//    7. Найдите в словаре с названием и
//    временем ответа сервисов только те,
//    время ответа которых превышает заданный порог.
    val serviceResponceTime = mapOf("service1" to 1.22, "service2" to 0.85, "service3" to 5.44)
    println(serviceResponceTime.filter { it.value > 5 })

//    8. В словаре хранятся результаты тестирования API
//    (ключ — endpoint, значение — статус ответа в виде строки).
//    Для указанного endpoint найдите статус ответа,
//    если endpoint отсутствует, предположите, что он не был протестирован.
    val webAutotestReport1 = mapOf(
        "https://stimmax.ru/course/kotlin-dlya-nachinayuschikh/2025-09-02" to "200 OK",
        "https://stimmax.ru/history/1223/read" to "200 OK"
    )
    println(webAutotestReport1.getOrElse("google.com") { "Maybe it didn't check" })

//    9. Из словаря, содержащего конфигурации тестового окружения
//    (ключ — название параметра конфигурации, значение - сама конфигурация),
//    получите значение для "browserType". Ответ не может быть null.
    val testConfiguration =
        mapOf("OS" to "Linux", "OS version" to "3.10", "browserType" to "Firefox", "testLabel" to "Night")
    println(testConfiguration.getOrDefault("browserType", "Google Chrome"))

//    10. Создайте копию неизменяемого словаря с данными
//    о версиях тестируемого ПО, добавив новую версию.
    val versions = mapOf("Android" to 3.4, "IOS" to 2.10)
    val mutableVersions = versions.toMutableMap()

//    11. Используя словарь с настройками тестирования
//    для различных мобильных устройств
//    (ключ — модель устройства, значение - строка с настройками),
//    получите настройки для конкретной модели или
//    верните настройки по умолчанию.
    val mobileTestSetup = mapOf("Xiaomi" to "smth1", "Pixel 9" to "smth2", "Samsung A24" to "smth3")
    println(mobileTestSetup.getOrDefault("Pixel 9", "smth"))

//    12. Проверьте, содержит ли словарь с ошибками тестирования
//    (ключ - код ошибки, значение - описание ошибки) определенный код ошибки.
    val testFails = mapOf(400 to "Client fail", 500 to "Server fail")
    println(testFails.containsKey(443))

//    13. Дан неизменяемый словарь, где
//    ключи — это идентификаторы тестовых сценариев в формате "TestID_Version",
//    а значения — статусы выполнения этих тестов ("Passed", "Failed", "Skipped").
//    Отфильтруйте словарь, оставив только те сценарии,
//    идентификаторы которых соответствуют определённой версии тестов,
//    то-есть в ключе содержится требуемая версия.
    val testResult = mapOf("Test001_1.1" to "Passed", "" to "Failed", "" to "Skipped")//ToDo

//    14. У вас есть словарь, где
//    ключи — это названия функциональных модулей приложения,
//    а значения — результаты их тестирования.
//    Проверьте, есть ли модули с неудачным тестированием.
    val testReport = mapOf("Payments" to "Passed", "Statistic" to "Failed", "Profile" to "Skipped")//ToDo
    println(testReport.containsValue("Failed"))

//    15. Добавьте в изменяемый словарь с настройками тестовой среды
//    настройки из другого словаря.
    val testEnvSet = mutableMapOf("set1" to "smth1", "set2" to "smth2")
    val testEnvSetNew = mapOf("set3" to "smth3")
    testEnvSet.putAll(testEnvSetNew)
    println(testEnvSet)

//    16. Объедините два неизменяемых словаря с данными о багах.
    val bugReport = mapOf("bug1" to "smth1", "bug2" to "smth2")
    val bugReport2 = mapOf("bug3" to "smth3", "bug4" to "smth4")
    val bugReportGeneral = mutableMapOf<String, String>()
    bugReportGeneral.putAll(bugReport)
    bugReportGeneral.putAll(bugReport2)
    println(bugReportGeneral)

//    17. Очистите изменяемый словарь с временными данными
//    о последнем прогоне автоматизированных тестов.
    val autoTestReport = mutableMapOf("Test1" to "Smth1", "Test2" to "Smth2")
    autoTestReport.clear()
    println(autoTestReport)

//    18. Исключите из отчета по автоматизированному тестированию те случаи,
//    где тесты были пропущены (имеют статус “skipped”).
//    Ключи - название теста, значения - статус.
    val testReport1 = mapOf("Payments" to "Passed", "Statistic" to "Failed", "Profile" to "Skipped")
    println(testReport1.filterNot { it.value == "Skipped" })

//    19. Создайте копию словаря с конфигурациями тестирования
//    удалив из него несколько конфигураций.

    val testConfiguration1 =
        mapOf("OS" to "Linux", "OS version" to "3.10", "browserType" to "Firefox", "testLabel" to "Night")
    val testConfiguration2 = testConfiguration1.toMutableMap()
    testConfiguration2.remove("browserType")
    testConfiguration2.remove("testLabel")

//    20. Создайте отчет о тестировании,
//    преобразовав словарь с результатами тестирования
//    (ключ — идентификатор теста, значение — результат)
//    в список строк формата "Test ID: результат".
    val testResult1 = mapOf("Test001" to "Passed", "Test002" to "Failed", "Test003" to "Skipped")
    val testReport2 = testResult1.map { "${it.key}: ${it.value}" }
    println(testReport2)

//    21. Преобразуйте изменяемый словарь
//    с результатами последнего тестирования в неизменяемый для архивации.
    val testReport3 = mutableMapOf("Payments" to "Passed", "Statistic" to "Failed", "Profile" to "Skipped")
    val testReport3_1 = testReport3.toMap()

//    22. Преобразуйте словарь, содержащий числовой ID теста и
//    данные о времени выполнения тестов,
//    заменив идентификаторы тестов на их строковый аналог
//    (например через toString()).
    val testTime = mapOf(1 to 1.22, 2 to 0.56, 3 to 0.11)
    val testTimeToString = testTime.mapKeys { it.key.toString() }
    println(testTimeToString)

//    23. Для словаря с оценками производительности различных версий приложения
//    (ключи - строковая версия, значения - дробное число времени ответа сервера)
//    увеличьте каждую оценку на 10%, чтобы учесть новые условия тестирования.
    val perfomanceScore = mapOf("1.101" to 1.22, "2.0" to 0.45, "2.201" to 0.23)
    println(perfomanceScore.mapValues { it.value * 1.1 })

//    24. Проверьте, пуст ли словарь с ошибками компиляции тестов.
    val compilationError = mapOf<String, String>()
    println(compilationError.isEmpty())

//    25. Убедитесь, что словарь с результатами нагрузочного тестирования не пуст.
    val perfomanceTestReport = mapOf("Test1" to "smth1")
    println(perfomanceTestReport.isNotEmpty())

//    26. Проверьте, прошли ли успешно
//    все автоматизированные тесты в словаре с результатами.
    val testReport4 = mutableMapOf("Payments" to "Passed", "Statistic" to "Failed", "Profile" to "Skipped")
    println(!(testReport4.containsValue("Failed")))


//    27. Определите, содержит ли словарь
//    с результатами тестирования хотя бы один тест с ошибкой.
    println((testReport4.containsValue("Failed")))

//    28. Отфильтруйте словарь с результатами тестирования сервисов,
//    оставив только те тесты, которые не прошли успешно и
//    содержат в названии “optional”.
    val serviceTestReport =
        mapOf("Test 1" to "Passed", "Test 2 optional" to "Passed", "Test 3" to "Failed", "Test 4 optional" to "Failed")
    println(serviceTestReport.filter { it.key.contains("optional") && it.value == "Passed" })
}