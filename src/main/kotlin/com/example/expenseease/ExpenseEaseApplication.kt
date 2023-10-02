package com.example.expenseease

import com.example.expenseease.config.AppConfig
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.AnnotationConfigApplicationContext

@SpringBootApplication
class ExpenseEaseApplication

fun main(args: Array<String>) {
    val context = AnnotationConfigApplicationContext()
    context.register(AppConfig::class.java)
    context.refresh()

    runApplication<ExpenseEaseApplication>(*args)
}
