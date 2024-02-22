package com.example.expenseease.datasource.interfaces

import com.example.expenseease.service.dto.User

interface ILoginDAO {
   fun getTestUser(user: User): User?

   fun registerUser(user: User): Boolean

}
