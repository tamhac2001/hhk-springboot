package com.example.hhkspringboot.core.repository

import com.example.hhkspringboot.core.domain.ColorOption
import com.example.hhkspringboot.core.enums.DeviceType
import com.example.hhkspringboot.core.enums.Manufacturer
import com.example.hhkspringboot.core.domain.Device
import com.example.hhkspringboot.core.domain.Stock
import org.bson.types.ObjectId
import org.springframework.data.domain.Pageable
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository


@Repository
interface DeviceRepository : MongoRepository<Device, String> {
    fun findAllByDeviceType(deviceType: DeviceType): List<Device>
}

