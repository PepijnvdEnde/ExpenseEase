package com.example.expenseease.resources

import com.example.expenseease.service.dto.MyUser
import com.example.expenseease.service.interfaces.IRegisterService
import com.example.expenseease.service.AuthService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

@Controller
@RestController
@RequestMapping("/Register")
@CrossOrigin(
    origins = ["*"],
    allowedHeaders = ["*"],
    methods = [RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS]
)
class RegisterController {

    @Autowired
    lateinit var registerService: IRegisterService

    @Autowired
    lateinit var authService: AuthService

    @RequestMapping(method = [RequestMethod.POST])
    fun registerUser(@RequestBody user: MyUser): ResponseEntity<*> {
        if (registerService.checkUserExists(user)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User already exists")
        }

        registerService.registerUser(user)

        val token = authService.generateTokenForUser(user)
        return ResponseEntity.status(HttpStatus.OK).body(mapOf("token" to token))
    }

}