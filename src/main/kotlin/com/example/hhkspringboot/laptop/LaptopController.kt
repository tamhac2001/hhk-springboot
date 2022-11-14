package com.example.hhkspringboot.laptop

import com.example.hhkspringboot.core.domain.Device
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class LaptopController(private val service: LaptopService) {

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/laptops")
    fun getAllLaptops(
    ): List<Device> {
        return service.getAllLaptop()
    }
}