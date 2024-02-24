package com.example.expenseease.service.interfaces

import com.example.expenseease.service.dto.MyUser

interface IRegisterService {
    fun checkUserExists(user: MyUser): Boolean

    fun registerUser(user: MyUser): Boolean
}
