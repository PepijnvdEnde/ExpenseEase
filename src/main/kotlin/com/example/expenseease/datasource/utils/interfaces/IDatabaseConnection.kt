package com.example.expenseease.datasource.utils.interfaces

import java.sql.Connection
interface IDatabaseConnection {
    fun getConnection(databaseProperties: IDatabaseProperties): Connection
}