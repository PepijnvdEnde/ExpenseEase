package com.example.expenseease.resources

import com.example.expenseease.service.ITestService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@Controller
@RestController
@RequestMapping("/api")
@CrossOrigin(
        origins = ["*"],
        allowedHeaders = ["*"],
        methods = [RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS]
)
class TestController {
    private lateinit var testService: ITestService
    @RequestMapping(method = [RequestMethod.GET])
    fun getTestString(): String {
        return testService.getTestString()
    }

    fun setTestService(testService: ITestService) {
        this.testService = testService
    }
}