package com.example.hhkspringboot.laptop

import com.example.hhkspringboot.core.enums.Manufacturer
import com.example.hhkspringboot.core.enums.OrderBy
import com.example.hhkspringboot.core.domain.Device
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service

@Service
class LaptopService(private val repository: LaptopRepository) {
    fun getAllLaptops(manufacturers: List<Manufacturer>?, orderBy: OrderBy, page: Int): List<Device> {
        val pageRequest = PageRequest.of(page * 10, 10)
        val devices =
            repository.findAllByDeviceTypeAndManufacturerInAndIsDefaultOptionTrue(
                manufacturers = manufacturers ?: Manufacturer.values().toList(),
                pageable = pageRequest
            )
        return devices.sortedBy { device ->
            device.stocks.minByOrNull { stock ->
                stock.price
            }!!.price
        }
    }
}