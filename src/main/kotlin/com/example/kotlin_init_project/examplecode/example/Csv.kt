package com.example.kotlin_init_project.examplecode.example

import com.opencsv.CSVReaderBuilder
import java.io.FileReader


class Csv {

    fun csvReader(): MutableList<UserCsv> {
        val filePath = "src/main/resources/test1.csv"

        val users = mutableListOf<UserCsv>()
        CSVReaderBuilder(FileReader(filePath)).build().use { reader ->
            reader.readNext()
            reader.readAll().forEach {
                val name = it[0].trim()
                val hobbies = it[1].trim().split(":")
                val comment = it[2].trim()

                users.add(UserCsv(name, hobbies, comment))
            }
        }

        return users
    }

    fun csvReaderStream(): MutableList<UserCsv> {
        val filePath = "src/main/resources/test1.csv"

        val users = mutableListOf<UserCsv>()
        CSVReaderBuilder(FileReader(filePath)).build().use { reader ->
            reader.readAll().stream()
                .skip(1)
                .forEach{
                    val name = it[0].trim()
                    val hobbies = it[1].trim().split(":")
                    val comment = it[2].trim()

                    users.add(UserCsv(name, hobbies, comment))
                }
        }

        return users
    }

    fun findTheNumberOfPeopleByHobby(): Map<String, Int> {
        val list = csvReader()

        val resultMap = mutableMapOf<String, Int>()
        list.forEach {
            for (hobby in it.hobbies) {
                resultMap[hobby] = resultMap.getOrDefault(hobby, 0) + 1
            }
        }

        return resultMap
    }

    //취미별 인원 수 찾기stream
    fun findTheNumberOfPeopleByHobbyStream(): Map<String, Int> {
        val list = csvReader()
        return list.flatMap { it.hobbies }.groupingBy { it }.eachCount()
    }

    //취미별 정씨 성을 가진 인원 수 구하기
    fun findHobbyNameByJeong(): Map<String, Int> {
        val list = csvReader()
        val tarGetFirstName = "정"
        val resultMap = mutableMapOf<String, Int>()

        list.forEach {
            if (it.name.contains(tarGetFirstName)) {
                for (hobby in it.hobbies) {
                    resultMap[hobby] = resultMap.getOrDefault(hobby, 0) + 1
                }
            }
        }
        return resultMap
    }

    //취미별 정씨 성을 가진 인원 수 구하기 stream
    fun findHobbyNameByJeongStream(): Map<String, Int> {
        val list = csvReader()
        val tarGetFirstName = "정"

        return list.filter { it.name.contains(tarGetFirstName) }
            .flatMap { it.hobbies }
            .groupingBy { it }
            .eachCount()
    }

    //소개 내용에 '좋아'가 몇 번 등장하는지 구하라
    fun findCommentLikeCount(): Int {
        val list = csvReader()
        val targetString = "좋아"
        var result = 0

        list.forEach {
            val arr = it.comment.split("좋아")
            result += arr.size - 1
        }
        return result
    }

    //소개 내용에 '좋아'가 몇 번 등장하는지 구하라 stream
    fun findCommentLikeCountStream(): Int {
        val list = csvReader()
        val targetString = "좋아"
        var result = 0

        return list.sumOf { it.comment.split(targetString).size - 1 }
    }


}