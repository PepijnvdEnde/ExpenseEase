package com.example.expenseease.service.interfaces

interface IPasswordEncoderService {
    fun hashPassword(password: String): String
    fun verifyPassword(rawPassword: String, encodedPassword: String): Boolean
}