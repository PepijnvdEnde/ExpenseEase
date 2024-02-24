package com.example.expenseease.service.interfaces

import com.example.expenseease.service.dto.MyUser

interface ILoginService {
    fun validateUser(user: MyUser): Boolean
}