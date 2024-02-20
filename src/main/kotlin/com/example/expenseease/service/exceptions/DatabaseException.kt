package com.example.expenseease.service.exceptions

class DatabaseException(message: String, cause: Throwable) : RuntimeException(message, cause) {
    constructor(message: String) : this(message, Throwable(message))
}