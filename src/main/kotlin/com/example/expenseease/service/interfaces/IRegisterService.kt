package com.example.expenseease.service.interfaces

import com.example.expenseease.service.dto.User

interface IRegisterService {
    fun checkUserExists(user: User): Boolean

    fun registerUser(user: User): Boolean
}
