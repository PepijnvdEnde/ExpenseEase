package com.example.expenseease.resources

import com.example.expenseease.service.AuthService
import io.jsonwebtoken.security.SignatureException

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
        try {
            if (authHeader.isEmpty()) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("No token")
            }
            if (!authService.authUser(authHeader)) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid token")
            }
            return ResponseEntity.status(HttpStatus.OK).body("Imagine that this is a dashboard. You are logged in!")
        } catch (ex: SignatureException) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("JWT signature does not match locally computed signature. JWT validity cannot be asserted and should not be trusted.")
        }
    }


}