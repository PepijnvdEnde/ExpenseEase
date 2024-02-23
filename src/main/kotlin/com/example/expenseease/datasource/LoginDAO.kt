package com.example.expenseease.datasource

import com.example.expenseease.datasource.interfaces.ILoginDAO
import com.example.expenseease.datasource.utils.interfaces.IDatabaseConnection
import com.example.expenseease.datasource.utils.interfaces.IDatabaseProperties
import com.example.expenseease.service.dto.User
import com.example.expenseease.service.exceptions.DatabaseException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import java.sql.SQLException

@Repository
class LoginDAO : ILoginDAO {

    @Autowired
    private lateinit var databaseConnection: IDatabaseConnection

    @Autowired
    private lateinit var databaseProperties: IDatabaseProperties

    override fun getUser(user: User): User? {
        try {
            val connection = databaseConnection.getConnection(databaseProperties)
            val ps = connection.prepareStatement("Select username, password from USERS where username = ?")
            ps.setString(1, user.username)
            val resultSet = ps.executeQuery()
            if (resultSet.next()) {
                val username = resultSet.getString("username")
                val password = resultSet.getString("password")
                return User(username, password)
            }

            resultSet.close()
            ps.close()
            connection.close()

        } catch (e: SQLException) {
            throw DatabaseException("Error while fetching user", e)
        }
        return null
    }

    override fun registerUser(user: User): Boolean {
        try {
            val connection = databaseConnection.getConnection(databaseProperties)
            val ps = connection.prepareStatement("Insert into USERS (username, password) values (?, ?)")
            ps.setString(1, user.username)
            ps.setString(2, user.password)
            val result = ps.executeUpdate()
            ps.close()
            connection.close()
            return result > 0
        } catch (e: SQLException) {
            throw DatabaseException("Error while registering user", e)
        }
    }
}