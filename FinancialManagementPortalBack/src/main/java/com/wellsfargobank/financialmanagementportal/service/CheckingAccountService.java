package com.wellsfargobank.financialmanagementportal.service;


import com.wellsfargobank.financialmanagementportal.entity.CheckingAccount;
import com.wellsfargobank.financialmanagementportal.repository.CheckingAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CheckingAccountService {
    @Autowired  //used for automatic dependency injection
    private CheckingAccountRepository checkingAccountRepository;


    //@PostMapping-----post/save all checking account data-----------
    public void saveCheckingAccountData(CheckingAccount checkingAccount){
        checkingAccountRepository.save(checkingAccount);
    }

    //@GeMapping------Getting the data from checking account---------------
    public List<CheckingAccount>getAllCheckingAccountData(){
        return checkingAccountRepository.findAll();
    }
}
