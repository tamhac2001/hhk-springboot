package com.example.hhkspringboot.laptop

import com.example.hhkspringboot.core.domain.Device
import com.example.hhkspringboot.core.enums.DeviceType
import com.example.hhkspringboot.core.repository.DeviceRepository
import org.springframework.stereotype.Service

@Service
class LaptopService(
    private val repository: DeviceRepository,

    ) {
    fun getAllLaptop(): List<Device> {
        return repository.findAllByDeviceType(deviceType = DeviceType.laptop)
    }
}