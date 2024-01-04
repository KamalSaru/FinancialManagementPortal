package com.wellsfargobank.financialmanagementportal.controller;


import com.wellsfargobank.financialmanagementportal.entity.CheckingAccount;
import com.wellsfargobank.financialmanagementportal.service.CheckingAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController//used to create REST ful web services using Spring MVC, Mapping request data
@RequestMapping("checking")//used to map web requests onto specific handler classes and/or handler methods
@CrossOrigin("htp://localhost:4200/") //Angular connections from java(backend)

public class CheckingAccountController {
    @Autowired //used for automatic dependency injection

    private CheckingAccountService checkingAccountService;

    @PostMapping
    //Posting customer details information--------------
    //In PostMan------http://localhost:8080/checking------------
    public String saveCheckingAccountData(@RequestBody CheckingAccount checkingAccount){
        checkingAccountService.saveCheckingAccountData(checkingAccount);
        return "Checking account details post successfully.";
    }

    @GetMapping
    //GetMapping-----Getting all list of checking account details------------------
    public ResponseEntity<List<CheckingAccount>>getAllCheckingAccountData(){
        return ResponseEntity.ok(checkingAccountService.getAllCheckingAccountData());
    }
}
