package com.example.hhkspringboot.core.domain

import com.fasterxml.jackson.annotation.JsonProperty
import org.springframework.data.annotation.ReadOnlyProperty
import org.springframework.data.mongodb.core.index.CompoundIndex
import org.springframework.data.mongodb.core.index.CompoundIndexes
import org.springframework.data.mongodb.core.mapping.*
import java.math.BigDecimal
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.PositiveOrZero

@Document(collection = "stocks")
@CompoundIndexes(
    CompoundIndex(
        def = "{'deviceID': 1, 'colorOptionID': 1}",
        unique = true,
    )
)
data class Stock(
    @MongoId(targetType = FieldType.OBJECT_ID)
    val id: String? = null,

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Field(targetType = FieldType.OBJECT_ID)
    val deviceID: String?,

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Field(targetType = FieldType.OBJECT_ID)
    val colorOptionID: String?,

    @field:PositiveOrZero
    val quantity: Int,

    @Field(targetType = FieldType.DECIMAL128)
    @field:PositiveOrZero
    val price: BigDecimal,
) {
    @ReadOnlyProperty
    @DocumentReference(lookup = "{'_id':?#{#self.colorOptionID}}")
    lateinit var colorOption: ColorOption
}