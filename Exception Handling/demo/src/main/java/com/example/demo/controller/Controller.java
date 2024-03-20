package com.example.demo.controller;


import com.example.demo.exception.InvalidInputException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class Controller {

    @GetMapping
    public ResponseEntity<String> getMessage(@RequestParam Double amount, @RequestParam Double rate, @RequestParam Double time) {

            if(amount==0||rate==0||time==0)
            {
                throw new InvalidInputException("Value of amount,rate and time should not be less than or equal to zero");

            }
            double simpleInterest = (amount * rate * time) / 100;
            double compoundInterest = amount * (Math.pow((1 + rate / 100), time)) - amount;
            return ResponseEntity.ok("Simple Interest = " + simpleInterest + "<br> Compound Interest is: " + compoundInterest);


        }

}
