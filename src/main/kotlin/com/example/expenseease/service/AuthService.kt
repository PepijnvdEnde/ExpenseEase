package com.example.expenseease.service

import com.example.expenseease.components.JwtTokenUtil
import com.example.expenseease.datasource.interfaces.ILoginDAO
import com.example.expenseease.service.dto.MyUser
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class AuthService(private val jwtTokenUtil: JwtTokenUtil) {

    @Autowired
    private lateinit var loginDAO: ILoginDAO

    fun generateTokenForUser(user: MyUser): String {
        return jwtTokenUtil.generateToken(user)
    }

    fun validateToken(token: String, user: MyUser): Boolean {
        return jwtTokenUtil.validateToken(token, user)
    }

    fun getUserDetailsFromToken(token: String): MyUser? {
        val username = jwtTokenUtil.extractUsername(token)
        return loginDAO.getUser(MyUser(username, ""))
    }
}