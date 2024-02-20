package com.example.expenseease.datasource.utils

import com.example.expenseease.datasource.utils.interfaces.IDatabaseConnection
import com.example.expenseease.datasource.utils.interfaces.IDatabaseProperties
import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException

class DatabaseConnection : IDatabaseConnection {
    @Throws(SQLException::class)
    override fun getConnection(databaseProperties: IDatabaseProperties): Connection {
        return DriverManager.getConnection(databaseProperties.connectionString())
    }

    init {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver")
        } catch (e: ClassNotFoundException) {
            e.printStackTrace()
        }
    }
}
