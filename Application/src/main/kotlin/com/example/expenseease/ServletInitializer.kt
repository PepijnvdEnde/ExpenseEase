package com.example.expenseease

import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer

class ServletInitializer : SpringBootServletInitializer() {

    public override fun configure(application: SpringApplicationBuilder): SpringApplicationBuilder {
        return application.sources(ExpenseEaseApplication::class.java)
    }

}
