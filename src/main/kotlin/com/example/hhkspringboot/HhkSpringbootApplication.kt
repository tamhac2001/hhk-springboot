package com.example.hhkspringboot

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories
import java.util.TimeZone

@SpringBootApplication
//@EnableMongoRepositories
class HhkSpringbootApplication

fun main(args: Array<String>) {
    TimeZone.setDefault(TimeZone.getTimeZone("UTC"))
    runApplication<HhkSpringbootApplication>(*args)
}
