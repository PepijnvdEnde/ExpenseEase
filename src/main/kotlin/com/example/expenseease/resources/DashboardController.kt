package com.example.expenseease.resources

import com.example.expenseease.service.AuthService

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

@Controller
@RestController
@RequestMapping("/Dashboard")
@CrossOrigin(
    origins = ["*"],
    allowedHeaders = ["*"],
    methods = [RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS]
)
class DashboardController  {

    @Autowired
    private lateinit var authService: AuthService

    @RequestMapping(method = [RequestMethod.GET])
    fun validateUser(@RequestHeader("Authorization") authHeader: String): ResponseEntity<*> {
        if (!authService.authUser(authHeader)) {
            return ResponseEntity.status(HttpStatus.OK).body("Invalid token")
        }
        return ResponseEntity.status(HttpStatus.OK).body("Imagine that this is a dashboard. You are logged in!")
    }


}