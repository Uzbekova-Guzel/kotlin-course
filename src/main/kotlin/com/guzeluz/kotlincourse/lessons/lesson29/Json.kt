package com.guzeluz.kotlincourse.lessons.lesson29

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.annotations.SerializedName

//Дата-класс с несколькими полями
data class Address(
    val street: String?,
    val city: String,
    val postalCode: Int
)

data class User(
    val id: Int,
    val name: String,
    val isActive: Boolean,
    val address: Address
)

//Использование аннотаций для изменения имени поля
data class UserWithAlias(
    @SerializedName("user_id") val id: Int,
    @SerializedName("full_name") val name: String,
    val isActive: Boolean
)

fun main() {
//    Сериализация: объект → JSON
    val address = Address("Baker Street", "London", 221)
    val user = User(1, "Sherlock Holmes", true, address)
    val gson = Gson() // Создаём экземпляр Gson
    val json = gson.toJson(user) // Сериализация объекта
    println("JSON: $json")

//    Десериализация: JSON → объект
    val user1 = gson.fromJson(json, User::class.java) // Десериализация JSON в объект
    println("User: $user1")

//    Аннотация @SerializedName
    val json1 = """{"user_id":2,"full_name":"John Watson","isActive":false}"""
    val user2 = gson.fromJson(json1, UserWithAlias::class.java)
    println("User with alias: $user2")

//    Настройка GSON с помощью GsonBuilder
    val gson3 = GsonBuilder()
        .setPrettyPrinting() // Для красивого форматирования JSON
        .serializeNulls() // Включить null-поля в JSON
        .create()
    val user3 = User(3, "Mary Morstan", false, Address(null, "London", 123))
    val json3 = gson3.toJson(user3)
    println("Pretty JSON:\n$json3")
}
