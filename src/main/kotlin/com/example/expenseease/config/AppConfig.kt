package com.example.expenseease.config

import com.example.expenseease.datasource.LoginDAO
import com.example.expenseease.datasource.interfaces.ILoginDAO
import com.example.expenseease.datasource.utils.DatabaseConnection
import com.example.expenseease.datasource.utils.DatabaseProperties
import com.example.expenseease.datasource.utils.interfaces.IDatabaseConnection
import com.example.expenseease.datasource.utils.interfaces.IDatabaseProperties
import com.example.expenseease.service.LoginService
import com.example.expenseease.service.PasswordEncoderService
import com.example.expenseease.service.RegisterService
import com.example.expenseease.service.interfaces.ILoginService
import com.example.expenseease.service.interfaces.IPasswordEncoderService
import com.example.expenseease.service.interfaces.IRegisterService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary

@Configuration
class AppConfig {
    @Primary
    @Bean
    fun iDatabaseConnection(): IDatabaseConnection = DatabaseConnection()

    @Primary
    @Bean
    fun iDatabaseProperties(): IDatabaseProperties = DatabaseProperties()

    @Primary
    @Bean
    fun iLoginService(): ILoginService = LoginService()

    @Primary
    @Bean
    fun iLoginDAO(): ILoginDAO = LoginDAO()

    @Primary
    @Bean
    fun iRegisterService(): IRegisterService = RegisterService()

    @Primary
    @Bean
    fun iPasswordEncoderService(): IPasswordEncoderService = PasswordEncoderService()
}