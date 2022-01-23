package com.sasuke0508.banksystem.service;

import com.sasuke0508.banksystem.entity.BankAccount;
import com.sasuke0508.banksystem.entity.Transaction;

import java.util.Date;
import java.util.List;

public interface TransactionService {
    /**
     * Create new transaction
     * @param newTransaction
     * @return new transaction if create success
     */
    public Transaction createTransaction(Transaction newTransaction);

    /**
     * Get information of transaction by transaction id
     * @param transactionId
     * @return transaction
     */
    public Transaction getInfoTransaction(String transactionId);

    /**
     * Get all transaction of customer by customer id
     * @param customerId
     * @return List transaction of customer
     */
    public List<Transaction> getAllTransactionByCustomerId(String customerId);

    /**
     * Get all transaction of customer between start date and end date
     * @param customerId
     * @param startDate
     * @param endDate
     * @return List transaction of customer
     */
    public List<Transaction> getTransactionsByCustomerIdAndCreateDate(String customerId, Date startDate, Date endDate);

    /**
     * Update status of transaction: canceled, in progress, completed
     * @param transactionUpdate
     * @return transaction after update
     */
    public Transaction updateStatusOfTransaction(Transaction transactionUpdate);

    /**
     * Get all transaction of bank account by bank account id
     * @param bankAccountId
     * @return list transaction
     */
    public List<Transaction> getTransactionsByBankAccountId(String bankAccountId);

    /**
     * Get list transaction of bank account between start date and end date
     * @param bankAccountId
     * @param startDate
     * @param endDate
     * @return list transaction of bank account
     */
    public List<Transaction> getTransactionsByBankAccountIdAndCreateDate(String bankAccountId, Date startDate, Date endDate);
}
