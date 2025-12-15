package com.guzeluz.kotlincourse.lessons.lesson26

import java.io.File

//Работа с файлами

fun main() {
    //Создание объекта File
    val file = File("path/to/your/file.txt")
    val directory = File("path/to/your/directory")

    //Проверка существования файла или директории
    if (file.exists()) {
        println("Файл существует")
    } else {
        println("Файл не найден")
    }

    //Создание нового файла
//    val isNewFileCreated: Boolean = file.createNewFile()
//    if (isNewFileCreated) {
//        println("Файл был создан")
//    } else {
//        println("Файл уже существует")


    //если путь к файлу включает несуществующие директории,
    // createNewFile() выбросит исключение.
    //Для решения этой проблемы можно перманентно использовать следующий сниппет:
    file.parentFile?.mkdirs()
    file.createNewFile()

    //Чтение и запись файла
    file.writeText("Hello, world!")

    //Чтение всего текста из файла:
    val text = file.readText()
    println(text)

    //Работа с директориями
    //Создание директории:
    val isDirectoryCreated: Boolean = directory.mkdir()
    if (isDirectoryCreated) {
        println("Директория была создана")
    } else {
        println("Не удалось создать директорию")
    }

    //Получение списка файлов в директории:
    val files = directory.listFiles()
    files?.forEach { file ->
        println(file.name)
        println(file)
        println(file.absolutePath)
    }

    //Удаление файла или директории
    if (file.delete()) {
        println("Файл удален")
    } else {
        println("Не удалось удалить файл")
    }

    //Удаление директории возможно только, если она пуста.
    // Для удаления непустой директории со всеми файлами и
    // поддиректориями можно использовать следующий метод:
    if (file.deleteRecursively()) {
        println("Директория и всё её содержимое удалено")
    } else {
        println("Не удалось удалить директорию")
    }

    //Дополнительные методы для работы с файлами в Kotlin

    //absoluteFile
    //Возвращает абсолютный путь к файлу в виде объекта File.
    val file1 = File("path/to/file.txt")
    println(file1.absoluteFile) // Вывод: /absolute/path/to/file.txt

    //isFile
    //Проверяет, является ли объект файлом.
    println(file1.isFile) // Вывод: true, если объект - файл

    //name
    //Возвращает имя файла или директории.
    println(file1.name) // Вывод: file.txt

    //parent
    //Возвращает строку с путем к родительской директории.
    println(file1.parent) // Вывод: /path/to

    //parentFile
    //Возвращает объект File, указывающий на родительскую директорию.
    println(file1.parentFile) // Вывод: объект File для /path/to

    //copyTo
    //Копирует файл в указанное местоположение.
    val sourceFile = File("/path/to/source.txt")
    val destinationFile = File("/path/to/destination.txt")
//    sourceFile.copyTo(destinationFile, overwrite = true) // Копирует файл, перезаписывая его при необходимости

    //toRelativeString
    //Возвращает относительный путь от одного File к другому.
    val baseDir = File("/path/to")
    val file2 = File("/path/to/nested/file.txt")
    println(file2.toRelativeString(baseDir)) // Вывод: nested/file.txt

    val relative = file2.relativeTo(baseDir)
    println(relative) // Вывод: nested/file.txt
    val target = File("path/to1")
    target.resolve(relative) // path/to1/nested/file.txt

    //walk
    //Выполняет рекурсивный перебор всех файлов директории, предоставляя их как поток, с которым можно работать как с обычными списками
    val file3 = File("path/to/file")
    file3.walk().filter { it.isFile }
        .associate { it.name to it.readLines() }
        .filterValues { data ->
            data.any { it.contains("text") }
        }
}

//Поиск файлов и директорий
fun searchFilesUsingWalk(startDir: String, query: String): List<String> {
    return File(startDir)
        .walk() // Рекурсивный обход файлов и директорий начиная с startDir
        .filter { it.isFile && it.name.contains(query, ignoreCase = true) } // Фильтрация по имени файла
        .map { it.absolutePath } // Преобразование результатов в абсолютные пути
        .toList() // Сбор результатов в список
}
