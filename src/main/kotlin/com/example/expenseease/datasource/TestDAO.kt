package com.example.expenseease.datasource

import com.example.expenseease.service.dto.User

object TestDAO : ITestDAO{
    private val user: User = User("test", "test")
    override fun getTestUser(): User {
        return user
    }
}