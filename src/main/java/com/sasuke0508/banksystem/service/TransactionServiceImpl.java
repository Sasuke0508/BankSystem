package com.sasuke0508.banksystem.service;

import com.sasuke0508.banksystem.entity.Transaction;
import com.sasuke0508.banksystem.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService{
    @Autowired
    private TransactionRepository transactionRepo;

    /**
     * Create new transaction
     *
     * @param newTransaction
     * @return new transaction if create success
     */
    @Override
    public Transaction createTransaction(Transaction newTransaction) {
        return transactionRepo.save(newTransaction);
    }

    /**
     * Get information of transaction by transaction id
     *
     * @param transactionId
     * @return transaction
     */
    @Override
    public Transaction getInfoTransaction(String transactionId) {
        return transactionRepo.getById(transactionId);
    }

    /**
     * Get all transaction of customer by customer id
     *
     * @param customerId
     * @return List transaction of customer
     */
    @Override
    public List<Transaction> getAllTransactionByCustomerId(String customerId) {
        return transactionRepo.findTransactionByCustomer(customerId);
    }

    /**
     * Get all transaction of customer between start date and end date
     *
     * @param customerId
     * @param startDate
     * @param endDate
     * @return List transaction of customer
     */
    @Override
    public List<Transaction> getTransactionsByCustomerIdAndCreateDate(String customerId, Date startDate, Date endDate) {
        return transactionRepo.findTransactionByCreateDateAndCustomer(customerId, startDate, endDate);
    }

    /**
     * Update status of transaction: canceled, in progress, completed
     *
     * @param transactionUpdate
     * @return transaction after update
     */
    @Override
    public Transaction updateStatusOfTransaction(Transaction transactionUpdate) {
        return transactionRepo.save(transactionUpdate);
    }

    /**
     * Get all transaction of bank account by bank account id
     *
     * @param bankAccountId
     * @return list transaction
     */
    @Override
    public List<Transaction> getTransactionsByBankAccountId(String bankAccountId) {
        return transactionRepo.findTransactionByBankAccount(bankAccountId);
    }

    /**
     * Get list transaction of bank account between start date and end date
     *
     * @param bankAccountId
     * @param startDate
     * @param endDate
     * @return list transaction of bank account
     */
    @Override
    public List<Transaction> getTransactionsByBankAccountIdAndCreateDate(String bankAccountId, Date startDate, Date endDate) {
        return transactionRepo.findTransactionByBankAccountAndCreateDate(bankAccountId, startDate, endDate);
    }
}
