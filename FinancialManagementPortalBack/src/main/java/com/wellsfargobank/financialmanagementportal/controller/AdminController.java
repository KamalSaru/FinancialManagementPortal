package com.wellsfargobank.financialmanagementportal.controller;


import com.wellsfargobank.financialmanagementportal.entity.AdminLogin;
import com.wellsfargobank.financialmanagementportal.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@CrossOrigin("http://localhost:4200/")
@RequestMapping("/admin")
public class AdminController {
    @Autowired

    private AdminService adminService;

    //@PostMapping-----Register admin login details---------
    //In Postman---http://localhost:8080/admin/register------------
    @PostMapping("/register")
    public ResponseEntity<String>saveRegisterAdminLogin(@RequestBody AdminLogin adminLogin){
        this.adminService.saveRegisterAdminLogin(adminLogin);
        return ResponseEntity.ok("Admin login details successfully registered.");
    }

    //@PostMapping----Admin login authentication verify--------------
    //In Postman---http://localhost:8080/admin/login-----------------
    @PostMapping("/login")
    public ResponseEntity<String>validateAdmin(@RequestBody AdminLogin adminLogin){
        this.adminService.findByEmailAndPasswordAndPinCode(adminLogin.getEmail(),adminLogin.getPassword(),adminLogin.getPinCode());
        return ResponseEntity.ok(adminService.findByEmailAndPasswordAndPinCode(adminLogin.getEmail(), adminLogin.getPassword(), adminLogin.getPinCode()));
    }
}
