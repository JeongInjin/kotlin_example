package com.example.kotlin_init_project

import com.example.kotlin_init_project.examplecode.AsyncTest
import com.example.kotlin_init_project.examplecode.JsonTest
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class KotlinInitProjectApplication

fun main(args: Array<String>) {
//    JsonTest().jsonParser()
    AsyncTest().asyncFun()

}