package com.example.hhkspringboot

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.data.mongodb.config.EnableMongoAuditing
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories
import org.springframework.stereotype.Component
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

import java.util.TimeZone

@SpringBootApplication
@EnableMongoAuditing
class HhkSpringbootApplication

fun main(args: Array<String>) {
    runApplication<HhkSpringbootApplication>(*args)
}

@Bean
fun addCorsConfig(): WebMvcConfigurer {
    return object : WebMvcConfigurer {
        override fun addCorsMappings(registry: CorsRegistry) {
            registry.addMapping("/**")
                .allowedMethods("*")
                .allowedOriginPatterns("http://localhost:8080")
                .allowCredentials(true)
        }
    }
}