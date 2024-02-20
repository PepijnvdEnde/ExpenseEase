package com.example.expenseease.datasource.utils

import com.example.expenseease.datasource.utils.interfaces.IDatabaseProperties
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component
import java.io.IOException
import java.util.*
import java.util.logging.Level
import java.util.logging.Logger


class DatabaseProperties : IDatabaseProperties {
    private val properties = Properties()
    
    init {
        try {
            properties.load(javaClass.classLoader.getResourceAsStream("database.properties"))
        } catch (e: IOException) {
            val logger = Logger.getLogger(javaClass.name)
            logger.log(Level.SEVERE, "Can't access property file database.properties", e)
        }
    }

    override fun connectionString(): String {
        return properties.getProperty("connectionString")
    }
}