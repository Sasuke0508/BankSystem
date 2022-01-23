package com.sasuke0508.banksystem.service;

import com.sasuke0508.banksystem.entity.BankAccount;
import com.sasuke0508.banksystem.repository.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankAccountServiceImpl implements BankAccountService{

    @Autowired
    private BankAccountRepository bankAccountRepository;
    /**
     * Create new bank account
     *
     * @param newBankAccount
     * @return new bank account
     */
    @Override
    public BankAccount addNewBankAccount(BankAccount newBankAccount) {
        return bankAccountRepository.save(newBankAccount);
    }

    /**
     * Lock/Unlock bank account
     *
     * @param bankAccount
     * @return bank account after edit
     */
    @Override
    public BankAccount lockAccount(BankAccount bankAccount) {
        boolean statusUpdate = !bankAccount.getStatus();
        bankAccount.setStatus(statusUpdate);
        return bankAccountRepository.save(bankAccount);
    }

    /**
     * Get information of bank account by account id
     *
     * @param bankAccountId
     * @return
     */
    @Override
    public BankAccount getInfoAccount(String bankAccountId) {
        return bankAccountRepository.getById(bankAccountId);
    }

    /**
     * Get list bank account of customer by customer id
     *
     * @param customerId
     * @return list bank account of customer
     */
    @Override
    public List<BankAccount> getListBankAccountByCustomerId(String customerId) {
        return bankAccountRepository.findAll();
    }
}
