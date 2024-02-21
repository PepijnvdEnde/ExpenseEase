package com.example.expenseease.service

import com.example.expenseease.datasource.interfaces.ITestDAO
import com.example.expenseease.service.dto.User
import com.example.expenseease.service.interfaces.ITestService

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class TestService : ITestService {
    @Autowired
    private lateinit var testDAO : ITestDAO

    override fun getTestUser(): User? {
        return testDAO.getTestUser()
    }


}