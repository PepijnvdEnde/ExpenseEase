package com.example.expenseease.service

import com.example.expenseease.service.dto.User
import com.example.expenseease.service.interfaces.ILoginService
import com.example.expenseease.service.interfaces.IPasswordEncoderService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
@Service
class LoginService: ILoginService {

    @Autowired
    private lateinit var passwordEncoderService: IPasswordEncoderService
    override fun validateUser(user: User): Boolean {
        return passwordEncoderService.verifyPassword(user.password, passwordEncoderService.hashPassword("password"))
    }
}