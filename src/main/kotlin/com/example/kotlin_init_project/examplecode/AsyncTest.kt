package com.example.kotlin_init_project.examplecode

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

class AsyncTest {
    fun asyncFun() {
        runBlocking {
            val deferred1 = async { fetchData("Data 1") }
            val deferred2 = async { fetchData("Data 2") }

            // Do other work here...

            val result1 = deferred1.await()
            val result2 = deferred2.await()

            println("Result 1: $result1")
            println("Result 2: $result2")
        }
    }

    suspend fun fetchData(data: String): String {
        delay(2000) // 시간이 많이 걸리는 작업 시뮬레이션
        return "Fetched $data"
    }
}