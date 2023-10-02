package com.example.expenseease.service

import org.springframework.stereotype.Service

@Service
class TestService : ITestService {

    override fun getTestString(): String {
        return "Hello World in Kotlin"
    }


}