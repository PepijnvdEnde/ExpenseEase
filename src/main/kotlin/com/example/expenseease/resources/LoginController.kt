package com.example.expenseease.resources

import com.example.expenseease.service.dto.MyUser
import com.example.expenseease.service.interfaces.ILoginService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*
import com.example.expenseease.service.AuthService

@Controller
@RestController
@RequestMapping("/Login")
@CrossOrigin(
    origins = ["*"],
    allowedHeaders = ["*"],
    methods = [RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS]
)
class LoginController  {

    @Autowired
    private lateinit var loginService: ILoginService

    @Autowired
    private lateinit var authService: AuthService

    @RequestMapping(method = [RequestMethod.POST])
    fun validateUser(@RequestBody user: MyUser): ResponseEntity<*> {
        return if (loginService.validateUser(user)) {
            val token = authService.generateTokenForUser(user)
            ResponseEntity.status(HttpStatus.OK).body(mapOf("token" to token))
        } else {
            ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password")
        }
    }
}