package com.example.hhkspringboot.core.converter

import com.example.hhkspringboot.core.enums.OrderBy
import org.springframework.core.convert.converter.Converter
import org.springframework.stereotype.Component

@Component
class OrderByEnumConverter : Converter<String, OrderBy> {
    override fun convert(source: String): OrderBy? {
        return if (source == "price-asc") {
            OrderBy.PRICE_ASC
        } else {
            OrderBy.PRICE_DESC
        }
    }
}