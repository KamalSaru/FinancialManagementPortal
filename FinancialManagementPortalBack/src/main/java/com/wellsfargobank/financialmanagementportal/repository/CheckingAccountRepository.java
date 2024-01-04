package com.wellsfargobank.financialmanagementportal.repository;

import com.wellsfargobank.financialmanagementportal.entity.CheckingAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CheckingAccountRepository extends JpaRepository<CheckingAccount, Long> {
}
