package com.example.hhkspringboot.core.domain

import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.FieldType
import org.springframework.data.mongodb.core.mapping.MongoId
import javax.validation.constraints.NotEmpty

@Document(collection = "colorOptions")
data class ColorOption(
    @MongoId(targetType = FieldType.OBJECT_ID)
    val id: String? = null,
    @field:NotEmpty
    val color: String,
    @Indexed(unique = true)
    val imageUrls: List<String>,
)
