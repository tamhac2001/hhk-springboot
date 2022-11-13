package com.example.hhkspringboot.core.domain

import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.MongoId

@Document(collection = "colorOptions")
data class ColorOption(
    @MongoId
    val id: String,
    val color: String,
    @Indexed(unique = true)
    val imageUrls: List<String>,
)
