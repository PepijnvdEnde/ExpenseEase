package com.example.expenseease.resources

import com.example.expenseease.service.dto.User
import com.example.expenseease.service.interfaces.ILoginService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

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

    @RequestMapping(method = [RequestMethod.POST])
    fun validateUser(@RequestBody user: User): ResponseEntity<*> {
        //temporarily hardcoded because I didn't impliment the layers
        return if (loginService.validateUser(user)) {
            ResponseEntity.status(HttpStatus.OK).body("Valid username and password")
        } else {
            ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password")
        }
    }
}