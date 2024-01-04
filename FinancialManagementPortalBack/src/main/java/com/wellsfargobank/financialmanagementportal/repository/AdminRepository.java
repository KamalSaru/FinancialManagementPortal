package com.wellsfargobank.financialmanagementportal.repository;

import com.wellsfargobank.financialmanagementportal.entity.AdminLogin;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;



public interface AdminRepository extends JpaRepository<AdminLogin, Long> {

    //@PostMapping----Admin login authentication verify--------------
    Optional<AdminLogin> findByEmailAndPasswordAndPinCode(String email, String password, Integer pinCode);

}
