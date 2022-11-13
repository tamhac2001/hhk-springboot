package com.example.hhkspringboot.laptop

import com.example.hhkspringboot.core.enums.DeviceType
import com.example.hhkspringboot.core.enums.Manufacturer
import com.example.hhkspringboot.core.domain.Device
import org.springframework.data.domain.Pageable
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository


@Repository
interface LaptopRepository : MongoRepository<Device, String> {
    @Suppress("SpringDataMethodInconsistencyInspection")
    fun findAllByDeviceTypeAndManufacturerInAndIsDefaultOptionTrue(
        deviceType: DeviceType = DeviceType.laptop,
        manufacturers: Collection<Manufacturer> = Manufacturer.values().toList(),
        pageable: Pageable,
    ): List<Device>
}