package com.example.hhkspringboot.core.domain

import com.example.hhkspringboot.core.enums.DeviceType
import com.example.hhkspringboot.core.enums.Manufacturer
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.annotation.ReadOnlyProperty
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.*
import java.time.LocalDateTime
import javax.validation.constraints.NotNull

@Document(collection = "devices")
data class Device(
    @MongoId(targetType = FieldType.OBJECT_ID)
    val id: String? = null,

    @Indexed(unique = true)
    val modelNumber: String?,

    val deviceType: DeviceType?,

    @Indexed(unique = true)
    val name: String?,

    val manufacturer: Manufacturer?,

    val specifications: Specifications?,

    val customizableSpecifications: CustomizableSpecifications?,

    @ReadOnlyProperty
    @DocumentReference(lookup = "{'deviceID':?#{#self._id} }")
    val stocks: List<Stock>,

    val isDefaultOption: Boolean = false,

    @Field(targetType = FieldType.OBJECT_ID)
    val defaultOptionID: String?,

    @CreatedDate
    val createdAt: LocalDateTime? = null,
    @LastModifiedDate
    val updatedAt: LocalDateTime? = null
) {
//    @ReadOnlyProperty
//    @DocumentReference(lookup = "{'deviceID':?#{#self._id} }")
//    lateinit var stocks: List<Stock>
}