package com.wellsfargobank.financialmanagementportal.service;


import com.wellsfargobank.financialmanagementportal.entity.AdminLogin;
import com.wellsfargobank.financialmanagementportal.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class AdminService {
    @Autowired

    private AdminRepository adminRepository;

    //@PostMapping-----Register admin login details----------
    public void saveRegisterAdminLogin(AdminLogin adminLogin){adminRepository.save(adminLogin);}


    //@PostMapping----Admin login authentication verify--------------
    public String findByEmailAndPasswordAndPinCode(String email, String password, Integer pinCode){
        Optional<AdminLogin>administration=this.adminRepository.findByEmailAndPasswordAndPinCode(email,password,pinCode);
        if (administration.isPresent()){
            return "Administration login successfully.";
        } else {
            return "Invalid admin email or password or pinCode.";
        }
    }
}
