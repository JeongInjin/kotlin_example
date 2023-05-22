package com.example.kotlin_init_project.examplecode.example

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import jdk.jfr.Description
import okhttp3.OkHttpClient
import okhttp3.Request
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


data class Event(
    val id: String,
    val type: String,
    val actor: Actor
)

data class Actor(
    val id: Int,
    val login: String
)

@RestController
@RequestMapping("/api/v1")
class OkhttpJsonController {

    @Description("")
    @GetMapping("/events")
    fun eventsList(): List<Event>? {
        val S3_DATA_URL = "https://s3.ap-northeast-2.amazonaws.com/bunjang-interview/events.json"
        val client = OkHttpClient()

        val request = Request.Builder().url(S3_DATA_URL).build()

        val response = client.newCall(request).execute()
        val body = response.body?.string()?: ""

        val gson = Gson()
        return gson.fromJson(body, object : TypeToken<List<Event>>() {}.type)
    }
}