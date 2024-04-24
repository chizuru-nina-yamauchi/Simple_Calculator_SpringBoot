package com.example.springbootassignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
@Controller
public class SpringBootAssignmentApplication {

    public static void main(String[] args) {

        SpringApplication.run(SpringBootAssignmentApplication.class, args);
    }

    @GetMapping("/calculate")
    @ResponseBody
    public String calculate(
            @RequestParam(name = "a") double a,
            @RequestParam(name = "b") double b,
            @RequestParam(name = "op") String operator) {
        double result;
        switch (operator) {
            case "add":
                result = a + b;
                break;
            case "subtract":
                result = a - b;
                break;
            case "multiply":
                result = a * b;
                break;
            case "divide":
                result = a / b;
                break;
            default:
                return "Invalid operator";
        }
        return "Result: " + result;
    }

}
