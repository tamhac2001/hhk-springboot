package com.example.hhkspringboot.core.domain

import com.example.hhkspringboot.core.enums.DeviceType
import com.example.hhkspringboot.core.enums.Manufacturer
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.annotation.ReadOnlyProperty
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.DocumentReference
import org.springframework.data.mongodb.core.mapping.MongoId
import java.time.LocalDateTime

@Document(collection = "devices")
data class Device(
    @MongoId
    val id: String,
    val modelNumber: String,
    val deviceType: DeviceType,
    val name: String,
    val manufacturer: Manufacturer,
    val specifications: Specifications,
    val customizableSpecifications: CustomizableSpecifications?,
    val isDefaultOption: Boolean = false,
    val defaultOptionID: String?,
    @CreatedDate
    val createdAt: LocalDateTime,
    @LastModifiedDate
    val updatedAt: LocalDateTime,
) {
    @ReadOnlyProperty
    @DocumentReference(lookup = "{'deviceID':?#{#self._id} }")
    lateinit var stocks: List<Stock>

    @ReadOnlyProperty
    @DocumentReference(lookup = "{'defaultOptionID':?#{#self._id} }")
    lateinit var otherOptions: List<Device>

}
