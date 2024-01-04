package com.wellsfargobank.financialmanagementportal.controller;

import com.wellsfargobank.financialmanagementportal.entity.CustomerDetails;
import com.wellsfargobank.financialmanagementportal.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController//used to create REST ful web services using Spring MVC, Mapping request data
@RequestMapping("customer")//used to map web requests onto specific handler classes and/or handler methods
//http://localhost:8080/customer ----exactly same lower or upper case on postman
//"customer" from entity class field
@CrossOrigin("http://localhost:4200/") //Angular connections from java(backend)
//http://localhost:8080/customerDetails  for the data on MySQL

public class CustomerController {
    @Autowired //used for automatic dependency injection
    private CustomerService customerService;

    @PostMapping
    //Posting customer details information--------------
    //In PostMan------http://localhost:8080/customer------------
    public String saveCustomer(@RequestBody CustomerDetails customerDetails){
        customerService.saveCustomer(customerDetails);
        return "Customer details save successfully.";
    }


    @GetMapping
    //Getting all list of customer details------------------
    public ResponseEntity<List<CustomerDetails>>getAllCustomerDetails(){
        return ResponseEntity.ok(customerService.getAllCustomerDetails());
    }


    //@GetMapping----getting method using ID-------------------
    //In PostMan------http://localhost:8080/customer/ID------------
    @GetMapping("/{ID}")
    public ResponseEntity<CustomerDetails>getCustomerDetailsByID(@PathVariable("ID") Long ID){
        return ResponseEntity.ok(customerService.getCustomerDetailsByID(ID));
    }


    //@PutMapping-----Edit/Update details using ID--------
    //First @GetMapping for edit and @PostMapping to update details-------
    @PutMapping("/{ID}")
    public ResponseEntity<String>updateCustomerDetails(@RequestBody CustomerDetails customerDetails, @PathVariable("ID") Long ID){
        return  ResponseEntity.ok(customerService.updateCustomerDetails(customerDetails, ID));
    }


    //@DeleteMapping-----Delete customer using ID------------------------
    @DeleteMapping("/{ID}")
    public ResponseEntity<String>deleteCustomerByID(@PathVariable("ID") Long ID){
        customerService.deleteCustomerByID(ID);
        return ResponseEntity.ok("Customer details successfully deleted.");
    }


    //@PatchMapping----------Patch method use to update partial field in the column(Replace update data)-------
    //First get Details using ID, CopyPaste, update necessary field and Patch the data--------
    @PatchMapping("/{ID}")
    public ResponseEntity<String> updateCustomerDetailsPartially(@RequestBody CustomerDetails updateCustomerDetails, @PathVariable("ID") Long ID){
        customerService.updateCustomerDetailsPartially(updateCustomerDetails, ID);
        return  ResponseEntity.ok("Customer partial field updated successfully.");
    }
    

    //@GetMapping-----Search/find customer details using first name-------------
    //In Postman---http://localhost:8080/customer/search/firstName------------
    @GetMapping("/search/{firstName}")
    public ResponseEntity<List<CustomerDetails>> searchCustomerDetails(@PathVariable("firstName")String firstName){
        return ResponseEntity.ok(customerService.findByFirstNameContaining(firstName));
    }
}



