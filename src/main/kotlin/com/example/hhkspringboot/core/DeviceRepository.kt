package com.example.hhkspringboot.core

import com.example.hhkspringboot.core.enums.DeviceType
import com.example.hhkspringboot.core.domain.Device
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.repository.NoRepositoryBean

@NoRepositoryBean
interface DeviceRepository : MongoRepository<Device, String> {
    fun findAllByDeviceType(deviceType: DeviceType): List<Device>

}