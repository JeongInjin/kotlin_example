package com.example.kotlin_init_project.examplecode.example

import jdk.jfr.Description

@Description("고객")
data class UserCsv(
    val name: String,
    val hobbies: List<String>,
    val comment: String,
)