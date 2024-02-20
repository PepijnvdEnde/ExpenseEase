package com.example.expenseease.datasource

import com.example.expenseease.datasource.utils.interfaces.IDatabaseConnection
import com.example.expenseease.datasource.utils.interfaces.IDatabaseProperties
import com.example.expenseease.service.dto.User
import org.springframework.beans.factory.annotation.Autowired
import java.sql.SQLException
import java.util.logging.Level

class TestDAO : ITestDAO {

    @Autowired
    private lateinit var databaseConnection: IDatabaseConnection

    @Autowired
    private lateinit var databaseProperties: IDatabaseProperties

    override fun getTestUser(): User {
        var user: User? = null
        val sql = "SELECT TOP(1) * FROM users"

        try {
            val connection = databaseConnection.getConnection(databaseProperties)
            val statement = connection.createStatement()
            val resultSet = statement.executeQuery(sql)

            if (resultSet.next()) {
                val username = resultSet.getString("username")
                val password = resultSet.getString("password")
                user = User(username, password)
            }

            resultSet.close()
            statement.close()
            connection.close()
        } catch (e: SQLException) {
            e.printStackTrace()
        }

        return user ?: User("test", "pass")
    }
}