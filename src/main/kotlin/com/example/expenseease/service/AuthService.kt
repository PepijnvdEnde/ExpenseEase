package com.example.expenseease.service

import com.example.expenseease.components.JwtTokenUtil
import com.example.expenseease.service.dto.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Service

@Service
class AuthService(private val jwtTokenUtil: JwtTokenUtil) {

    fun generateTokenForUser(user: User): String {
        val userDetails: UserDetails = user // Convert User to UserDetails
        return jwtTokenUtil.generateToken(userDetails)
    }
}