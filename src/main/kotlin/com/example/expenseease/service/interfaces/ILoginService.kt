package com.example.expenseease.service.interfaces

import com.example.expenseease.service.dto.User

interface ILoginService {
    fun validateUser(user: User): Boolean
}