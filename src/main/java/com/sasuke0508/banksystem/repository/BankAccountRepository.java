package com.sasuke0508.banksystem.repository;

import com.sasuke0508.banksystem.entity.BankAccount;
import com.sasuke0508.banksystem.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BankAccountRepository extends JpaRepository<BankAccount, String> {
    List<BankAccount> findBankAccountByCardHolder(Customer customer);
}
