package com.wellsfargobank.financialmanagementportal.service;

import com.wellsfargobank.financialmanagementportal.entity.CustomerDetails;
import com.wellsfargobank.financialmanagementportal.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;


@Service
public class CustomerService {
    @Autowired //used for automatic dependency injection
    private CustomerRepository customerRepository;

    //@PostMapping----Post/save all the customers details PostMapping----------
    public void saveCustomer(CustomerDetails customerDetails) {
        customerRepository.save(customerDetails);
    }

    //@GetMapping---Getting all list of customer details------------------
    public List<CustomerDetails>getAllCustomerDetails(){
        return customerRepository.findAll();
    }

    //@GetMapping----getting method using ID-------------------
    public CustomerDetails getCustomerDetailsByID(Long ID){
        Optional<CustomerDetails>customerDetails=customerRepository.findById(ID);
        if (customerDetails.isPresent()){
            return customerDetails.get();
        } else {
            return null;
        }
    }

    //@PutMapping-----Edit/Update details using ID--------
    //"CustomerDetails1" and "customerInfo" name are  changeable and put any meaningfully name.
    public String updateCustomerDetails(CustomerDetails customerInfo, Long ID){
        Optional<CustomerDetails>customerDetails1=customerRepository.findById(ID);
        if (customerDetails1.isPresent()){
            CustomerDetails customerDetails=customerDetails1.get();
            customerDetails.setFirstName(customerInfo.getFirstName());
            customerDetails.setLastName(customerInfo.getLastName());
            customerDetails.setPhoneNumber(customerInfo.getPhoneNumber());
            customerDetails.setEmail(customerInfo.getEmail());
            customerDetails.setAddress(customerInfo.getAddress());
            customerDetails.setDob(customerInfo.getDob());
            customerDetails.setGender(customerInfo.getGender());
            customerDetails.setAccountStatus(customerInfo.getAccountStatus());
            customerRepository.save(customerDetails);
            return "Customer details update successfully.";
        } else {
            return "Customer ID number " + ID + "doesn't exit.";
        }
    }

    //@DeleteMapping-----Delete customer using ID------------------------
    public void deleteCustomerByID(Long ID){
        customerRepository.deleteById(ID);
    }

    //@PatchMapping------Patch method use to update partial field in the column(Replace update data)-------
    //First get Details using ID, CopyPaste, update necessary field and Patch the data--------
    public String updateCustomerDetailsPartially(@RequestBody CustomerDetails updateCustomerDetails,@PathVariable Long ID) {
        Optional<CustomerDetails>customerOptional=customerRepository.findById(ID);
        if (customerOptional.isPresent()){
            //Existed customer details-----
            CustomerDetails existingCustomerData = customerOptional.get();
            if (updateCustomerDetails.getFirstName() !=null){
                existingCustomerData.setFirstName(updateCustomerDetails.getFirstName());
            }
            if (updateCustomerDetails.getLastName() !=null){
                existingCustomerData.setLastName(updateCustomerDetails.getLastName());
            }
            if(updateCustomerDetails.getPhoneNumber() !=null){
                existingCustomerData.setPhoneNumber(updateCustomerDetails.getPhoneNumber());
            }
            if(updateCustomerDetails.getEmail() !=null){
                existingCustomerData.setEmail(updateCustomerDetails.getEmail());
            }
            if (updateCustomerDetails.getAddress() !=null){
                existingCustomerData.setAddress(updateCustomerDetails.getAddress());
            }
            if (updateCustomerDetails.getDob() !=null){
                existingCustomerData.setDob(updateCustomerDetails.getDob());
            }
            if (updateCustomerDetails.getGender() !=null){
                existingCustomerData.setGender(updateCustomerDetails.getGender());
            }
            if (updateCustomerDetails.getAccountStatus() !=null){
                existingCustomerData.setAccountStatus(updateCustomerDetails.getAccountStatus());
            }
            customerRepository.save(existingCustomerData);
            return "Customer partial field updated successfully.";
        } else {
            //Not working---
            return "Customer ID number " + updateCustomerDetails.getCustomerID() +" not found.";
        }
    }

    //@GetMapping-----Search/find customer details using first name-------------
    //In Postman---http://localhost:8080/customer/search/firstName------------
    public List<CustomerDetails> findByFirstNameContaining(String firstName){
        customerRepository.findByFirstNameContaining(firstName);
        return customerRepository.findByFirstNameContaining(firstName);
    }
}
