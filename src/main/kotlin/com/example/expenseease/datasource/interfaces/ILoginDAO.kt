package com.example.expenseease.datasource.interfaces

import com.example.expenseease.service.dto.User

interface ILoginDAO {
   fun getUser(user: User): User?

   fun registerUser(user: User): Boolean

}
