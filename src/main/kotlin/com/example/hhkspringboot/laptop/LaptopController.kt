package com.example.hhkspringboot.laptop

import com.example.hhkspringboot.core.enums.Manufacturer
import com.example.hhkspringboot.core.enums.OrderBy
import com.example.hhkspringboot.core.domain.Device
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/laptops")
class LaptopController(private val service: LaptopService) {

    @ResponseStatus(HttpStatus.OK)
    @GetMapping()
    fun getAllLaptops(
        @RequestParam(required = false) manufacturers: List<Manufacturer>?,
        @RequestParam(name = "order-by", defaultValue = "price-desc") orderBy: OrderBy,
        @RequestParam(defaultValue = "0") page: Int,
    ): List<Device> {
        return service.getAllLaptops(manufacturers, orderBy, page)
    }
}