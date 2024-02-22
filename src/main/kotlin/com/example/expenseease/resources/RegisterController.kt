package com.example.expenseease.resources

import com.example.expenseease.service.dto.User
import com.example.expenseease.service.interfaces.IRegisterService
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

    @RequestMapping(method = [RequestMethod.POST])
    fun registerUser(@RequestBody user: User): ResponseEntity<*> {
        if (registerService.checkUserExists(user)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User already exists")
        }

        registerService.registerUser(user)
        return ResponseEntity.status(HttpStatus.OK).body("User registered")
    }

}