package com.example.kotlin_init_project

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KotlinInitProjectApplication

fun main(args: Array<String>) {
    runApplication<KotlinInitProjectApplication>(*args)
}