package com.example.expenseease.service

import com.example.expenseease.datasource.interfaces.ILoginDAO
import com.example.expenseease.service.dto.MyUser
import com.example.expenseease.service.interfaces.IPasswordEncoderService
import com.example.expenseease.service.interfaces.IRegisterService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class RegisterService: IRegisterService {

    @Autowired
    lateinit var loginDAO: ILoginDAO

    @Autowired
    private lateinit var passwordEncoderService: IPasswordEncoderService

    override fun checkUserExists(user: MyUser): Boolean {
        return loginDAO.getUser(user)?.username  != null
    }

    override fun registerUser(user: MyUser): Boolean {
            val modifiedUser = user.copy(password = passwordEncoderService.hashPassword(user.password))
            return loginDAO.registerUser(modifiedUser)
        }
}