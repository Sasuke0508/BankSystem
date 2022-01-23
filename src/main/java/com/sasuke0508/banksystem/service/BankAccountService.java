package com.sasuke0508.banksystem.service;

import com.sasuke0508.banksystem.entity.BankAccount;

import java.util.List;

public interface BankAccountService {
    /**
     * Create new bank account
     * @param newBankAccount
     * @return new bank account
     */
    public BankAccount addNewBankAccount(BankAccount newBankAccount);

    /**
     * Lock/Unlock bank account
     * @param bankAccount
     * @return bank account after edit
     */
    public BankAccount lockAccount(BankAccount bankAccount);

    /**
     * Get information of bank account by account id
     * @param bankAccountId
     * @return
     */
    public BankAccount getInfoAccount(String bankAccountId);

    /**
     * Get list bank account of customer by customer id
     * @param customerId
     * @return list bank account of customer
     */
    public List<BankAccount> getListBankAccountByCustomerId(String customerId);
}
