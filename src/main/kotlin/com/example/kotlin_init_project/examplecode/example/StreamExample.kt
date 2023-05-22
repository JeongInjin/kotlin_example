package com.example.kotlin_init_project.examplecode.example

class StreamExample {
    fun example() {
        //filter
        val numbers = listOf(1, 2, 3, 4, 5)
        val evenNumbers = numbers.filter { it % 2 == 0 }
        println(evenNumbers) // Output: [2, 4]

        //map
        val squaredNumbers = numbers.map { it * it }
        println(squaredNumbers) // Output: [1, 4, 9, 16, 25]

        //flatMap
        val nestedList = listOf(listOf(1, 2, 3), listOf(4, 5, 6), listOf(7, 8, 9))
        val flattenedList = nestedList.flatMap { it }
        val flattenedList2 = nestedList.flatten()
        println(flattenedList) // Output: [1, 2, 3, 4, 5, 6, 7, 8, 9]
        println(flattenedList2) // Output: [1, 2, 3, 4, 5, 6, 7, 8, 9]

        //reduce
        val sum4 = numbers.reduce { acc, value -> acc + value }
        println(sum4) // Output: 15

        //any
        val hasEvenNumber = numbers.any { it % 2 == 0 }
        println(hasEvenNumber) // Output: true

        //all
        val allEvenNumbers = numbers.all { it % 2 == 0 }
        println(allEvenNumbers) // Output: false

        //count
        val evenCount = numbers.count { it % 2 == 0 }
        println(evenCount) // Output: 2

        //sumOf
        val sum = numbers.sumOf { it }
        println(sum) // Output: 15

        //groupBy
        val names = listOf("John", "Jane", "Mary", "Mike")
        val nameLengths = names.groupBy { it.length }
        println(nameLengths) // Output: {4=[John, Jane, Mike], 5=[Mary]}

        //sorted
        val sortedNumbers = numbers.sorted()
        println(sortedNumbers) // Output: [1, 2, 3, 4, 5]

        //maxByOrNull, minByOrNull
        val maxNumber = numbers.maxByOrNull { it }
        val minNumber = numbers.minByOrNull { it }
        println(maxNumber) // Output: 5
        println(minNumber) // Output: 1

        //distinct
        val distinctNumbers = numbers.distinct()
        println(distinctNumbers) // Output: [1, 2,

    }
}