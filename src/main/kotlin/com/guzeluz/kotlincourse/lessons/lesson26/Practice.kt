package com.guzeluz.kotlincourse.lessons.lesson26

import java.io.File

/*Задание 1: Создание файла или директории
Напишите функцию createFileOrDirectory, которая принимает путь в виде строки и
создает файл или директорию в зависимости от того,
заканчивается ли путь на "/".*/
fun createFileOrDirectory(path: String) {
    val file = File(path)
    file.parentFile?.mkdir()
    if (path.endsWith("/")) {
        file.mkdir()
    } else {
        file.createNewFile()
    }
}

/*Задание 3: Запись данных в файл
Напишите функцию writeDataToFile, которая принимает путь к файлу и
объект Map<String, Double>. Функция должна записать данные из словаря
в файл, форматируя их в виде текста разделяя ключи и значения символом =.*/
fun writeDataToFile(path: String, obj: Map<String, Double>) {
    with(File(path)) {
        parentFile?.mkdir()
        createNewFile()
        obj.map { "${it.key} = ${it.value}" }
            .joinToString("\n")
            .also { writeText(it) }
    }
}

/*Задание 5: Удаление файла
Напишите функцию deleteFile, которая принимает путь к файлу и ключевую фразу и
удаляет файл только в том случае, если в файле не содержится ключевая фраза*/
fun deleteFile(path: String, text: String) {
    File(path).apply {
        if (exists() && readText().contains(text)) {
            delete()
        }
    }
}

/*Задание 7: Поиск списка файлов по части имени с преобразованием файлов в их содержимое
Напишите функцию findFilesByPartOfName, которая принимает начальную директорию и
часть имени файла. Функция должна искать все подходящие файлы и
возвращать список, содержащий содержимое каждого найденного файла.*/
fun findFilesByPartOfName(path: String, keyWord: String): List<String> {
    return File(path).walk()
        .filter { it.isFile && it.name.contains(keyWord) }
        .map { it.readText() }
        .toList()
}

/*Задание 8: Копирование файла
Напиши функцию расширения строки copyTo, которая принимает путь -
назначение для копирования файла. Функция должна взять из текущей строки путь,
проверить что он существует и выполнить копирование в новое расположение,
полученное из аргумента функции.
Если пути нет - выбросить исключение FileNotFoundException.*/
fun String.copyTo(targetPath: String) {
    File(this).run {
        check(exists()) {
            "File doesn't exist"
        }
        val newFile = File(targetPath)
        newFile.parentFile?.mkdirs()
        copyTo(newFile)
    }
}
