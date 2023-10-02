package com.example.expenseease


import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.springframework.boot.builder.SpringApplicationBuilder


class ServletInitializerTest {
    @Test
    fun configureShouldReturnSources() {
        val application = mockk<SpringApplicationBuilder>(relaxed = true)
        every { application.sources(any()) } returns application

        val result = ServletInitializer().configure(application)

        assertSame(application, result)
        verify { application.sources(any()) }
    }
}