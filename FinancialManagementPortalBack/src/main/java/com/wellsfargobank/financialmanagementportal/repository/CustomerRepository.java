package com.wellsfargobank.financialmanagementportal.repository;

import com.wellsfargobank.financialmanagementportal.entity.CustomerDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository //JPA specific extension for Repository
public interface  CustomerRepository extends JpaRepository<CustomerDetails, Long> {

    //@GetMapping-----Search/find customer details using first name-------------
    //In Postman---http://localhost:8080/customer/search/firstName------------
    List<CustomerDetails> findByFirstNameContaining(String firstName);
}
