package com.example.springbootassignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@SpringBootApplication
@Controller
public class SpringBootAssignmentApplication {

    public static void main(String[] args) {

        SpringApplication.run(SpringBootAssignmentApplication.class, args);
    }

    @GetMapping("/calculate")
    public String calculate(
            @RequestParam(name = "a") double a,
            @RequestParam(name = "b") double b,
            @RequestParam(name = "op") String operator,
            Model model) {
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
                model.addAttribute("error", "Invalid operator");
                return "error";
        }
        model.addAttribute("result", result);
        return "result";
    }




}
