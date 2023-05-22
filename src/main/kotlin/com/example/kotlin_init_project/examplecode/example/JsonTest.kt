package com.example.kotlin_init_project.examplecode.example

import com.google.gson.Gson
import com.google.gson.JsonObject

class JsonTest {
    fun jsonParser() {
        val jsonString = """
        {
            "person": [
                {
                    "id": 0,
                    "name": "Mathews Parker",
                    "email": "goodsleep@aseep.com"
                },
                {
                    "id": 1,
                    "name": "json as",
                    "email": "123dslfffp@aseep.com"
                },
                {
                    "id": 2,
                    "name": "json a123",
                    "email": "12a23sleep@aseep.com"
                }
            ]
        }
    """.trimIndent()

        val gson = Gson()
        val gsonObj = gson.fromJson(jsonString, JsonObject::class.java)
        val jsonArray = gsonObj.getAsJsonArray("person")

        val persons = jsonArray.map {
            gson.fromJson(it, Person::class.java)
        }
        println("persons = ${persons}")
        println("-----------------------")
        for (person in persons) {
            println("ID: ${person.id}, Name: ${person.name}, Email: ${person.email}")
        }
    }
}

data class Person(
    val id: Int,
    val name: String,
    val email: String
)
