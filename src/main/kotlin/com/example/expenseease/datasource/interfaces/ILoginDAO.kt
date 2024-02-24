package com.example.expenseease.datasource.interfaces

import com.example.expenseease.service.dto.MyUser

interface ILoginDAO {
   fun getUser(user: MyUser): MyUser?

   fun registerUser(user: MyUser): Boolean

}
