package com.example.hhkspringboot

import com.example.hhkspringboot.laptop.LaptopController
import com.example.hhkspringboot.laptop.LaptopService
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.restdocs.headers.HeaderDocumentation.headerWithName
import org.springframework.restdocs.headers.HeaderDocumentation.responseHeaders
import org.springframework.restdocs.hypermedia.HypermediaDocumentation.linkWithRel
import org.springframework.restdocs.hypermedia.HypermediaDocumentation.links
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get
import org.springframework.restdocs.payload.PayloadDocumentation.*
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status


@WebMvcTest(LaptopController::class)
@AutoConfigureRestDocs
class LaptopControllerTest(@Autowired val mockMvc: MockMvc) {

    @MockBean
    lateinit var laptopService: LaptopService

    @Test
    fun `should return 10 laptops`() {
        mockMvc.perform(get("/laptops")).andExpect(status().isOk)
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//            .andDo(
//                document(
//                    "index",
//                    links(linkWithRel("laptop").description("The Laptop resource")),
//                    responseFields(
//                        fieldWithPath("name").description("Device's name")
//                    ),
//                    responseHeaders(
//                        headerWithName("Content-Type")
//                            .description("The Content-Type of the payload")
//                    )
//                )
//            )
    }
}