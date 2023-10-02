package com.example.expenseease.datasource

object TestDAO : ITestDAO{

    override fun getTestString(): String {
        return "Hello World"
    }
}