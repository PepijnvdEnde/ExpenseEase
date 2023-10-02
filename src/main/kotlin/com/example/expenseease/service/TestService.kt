package com.example.expenseease.service

import com.example.expenseease.datasource.ITestDAO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class TestService : ITestService {
    @Autowired
    private lateinit var testDAO : ITestDAO

    fun setTestDAO(testDAO: ITestDAO) {
        this.testDAO = testDAO
    }

    override fun getTestString(): String {
        return testDAO.getTestString().replace("World", "World in kotlin service")
    }


}