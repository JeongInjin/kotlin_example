package com.example.kotlin_init_project.examplecode.example

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test


class CsvTest() {
    val csv = Csv()


    @Test
    fun CsvReaderTest() {
        val users = csv.csvReader()

        assertThat(users.size).isEqualTo(4)

        assertThat(users[0].name).isEqualTo("김프로")
        assertThat(users[0].hobbies?.size).isEqualTo(3)
        assertThat(users[0].comment).isEqualTo("구기종목 좋아요")

        assertThat(users[3].name).isEqualTo("죠르디")
        assertThat(users[3].hobbies?.size).isEqualTo(2)
        assertThat(users[3].comment).isEqualTo("개발하는 죠르디")
    }

    @Test
    fun CsvReaderStreamTest() {
        val users = csv.csvReaderStream()

        assertThat(users.size).isEqualTo(4)

        assertThat(users[0].name).isEqualTo("김프로")
        assertThat(users[0].hobbies?.size).isEqualTo(3)
        assertThat(users[0].comment).isEqualTo("구기종목 좋아요")

        assertThat(users[3].name).isEqualTo("죠르디")
        assertThat(users[3].hobbies?.size).isEqualTo(2)
        assertThat(users[3].comment).isEqualTo("개발하는 죠르디")
    }


    @Test
    fun findTheNumberOfPeopleByHobbyTest() {
        val result = csv.findTheNumberOfPeopleByHobby()
        assertThat(result["축구"]).isEqualTo(2)
        assertThat(result["농구"]).isEqualTo(1)
        assertThat(result["야구"]).isEqualTo(1)
        assertThat(result["개발"]).isEqualTo(2)
        assertThat(result["당구"]).isEqualTo(1)
        assertThat(result["족구"]).isEqualTo(1)
        assertThat(result["피아노"]).isEqualTo(1)
        assertThat(result["스포츠댄스"]).isEqualTo(1)
    }

    @Test
    fun findTheNumberOfPeopleByHobbyStream() {
        val result = csv.findTheNumberOfPeopleByHobbyStream()
        assertThat(result["축구"]).isEqualTo(2)
        assertThat(result["농구"]).isEqualTo(1)
        assertThat(result["야구"]).isEqualTo(1)
        assertThat(result["개발"]).isEqualTo(2)
        assertThat(result["당구"]).isEqualTo(1)
        assertThat(result["족구"]).isEqualTo(1)
        assertThat(result["피아노"]).isEqualTo(1)
        assertThat(result["스포츠댄스"]).isEqualTo(1)
    }

    @Test
    fun findHobbyNameByJeongTest() {
        val result = csv.findHobbyNameByJeong()
        assertThat(result["개발"]).isEqualTo(1)
        assertThat(result["당구"]).isEqualTo(1)
        assertThat(result["족구"]).isEqualTo(1)
    }

    @Test
    fun findHobbyNameByJeongTestStream() {
        val result = csv.findHobbyNameByJeongStream()
        assertThat(result["개발"]).isEqualTo(1)
        assertThat(result["당구"]).isEqualTo(1)
        assertThat(result["족구"]).isEqualTo(1)
    }

    @Test
    fun findCommentLikeCountTest() {
        val result = csv.findCommentLikeCount()
        assertThat(result).isEqualTo(5)
    }

    @Test
    fun findCommentLikeCountTestStream() {
        val result = csv.findCommentLikeCountStream()
        assertThat(result).isEqualTo(5)
    }


}