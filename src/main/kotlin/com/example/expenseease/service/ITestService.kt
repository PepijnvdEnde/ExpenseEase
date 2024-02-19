package com.example.expenseease.service

import org.apache.catalina.User

interface ITestService {
    fun getTestUser(): com.example.expenseease.service.dto.User
}