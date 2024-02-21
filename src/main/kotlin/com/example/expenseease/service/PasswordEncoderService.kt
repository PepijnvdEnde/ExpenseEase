package com.example.expenseease.service

import com.example.expenseease.service.interfaces.IPasswordEncoderService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
class PasswordEncoderService: IPasswordEncoderService {

    private val encoder = BCryptPasswordEncoder()

    override fun hashPassword(password: String): String {
        return encoder.encode(password)
    }

    override fun verifyPassword(rawPassword: String, encodedPassword: String): Boolean {
        return encoder.matches(rawPassword, encodedPassword)
    }

}