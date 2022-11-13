package com.example.hhkspringboot.core.domain

import com.fasterxml.jackson.annotation.JsonIgnore
import org.springframework.data.annotation.ReadOnlyProperty
import org.springframework.data.mongodb.core.index.CompoundIndex
import org.springframework.data.mongodb.core.index.CompoundIndexes
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.DocumentReference
import org.springframework.data.mongodb.core.mapping.Field
import org.springframework.data.mongodb.core.mapping.FieldType
import org.springframework.data.mongodb.core.mapping.MongoId
import java.math.BigDecimal

@Document(collection = "stocks")
@CompoundIndexes(
    CompoundIndex(
        def = "{'deviceID': 1, 'colorOptionID': 1}",
        unique = true,
    )
)
data class Stock(
    @MongoId
    val id: String,
    @JsonIgnore
    val deviceID: String,
    @JsonIgnore
    val colorOptionID: String,
    val quantity: Int,
    @Field(targetType = FieldType.DECIMAL128)
    val price: BigDecimal,
) {
    @ReadOnlyProperty
    @DocumentReference(lookup = "{'_id':?#{#self.colorOptionID}}")
    var colorOption: ColorOption? = null
}
