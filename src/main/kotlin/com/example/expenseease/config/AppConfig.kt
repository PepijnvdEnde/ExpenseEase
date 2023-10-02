package com.example.expenseease.config

import com.example.expenseease.service.ITestService
import com.example.expenseease.service.TestService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary

@Configuration
class AppConfig {

    @Primary
    @Bean
    fun iTestService(): ITestService = TestService()

}