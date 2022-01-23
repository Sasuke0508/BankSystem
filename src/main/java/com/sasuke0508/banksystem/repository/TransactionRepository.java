package com.sasuke0508.banksystem.repository;

import com.sasuke0508.banksystem.entity.BankAccount;
import com.sasuke0508.banksystem.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, String> {
    /**
     * Get all transaction of account
     * @param bankAccountId
     * @return List Transaction
     */
    @Query("SELECT t FROM Transaction t WHERE t.bankAccountReceive.id = ?1 OR t.bankAccountSend.id = ?1 order by t.createDate desc")
    List<Transaction> findTransactionByBankAccount(String bankAccountId);

    @Query("SELECT t FROM Transaction t WHERE t.bankAccountSend.cardHolder.id = ?1 or t.bankAccountReceive.cardHolder.id = ?1 order by t.createDate desc")
    List<Transaction> findTransactionByCustomer(String customerId);

    @Query("SELECT t FROM Transaction t WHERE (t.bankAccountSend.cardHolder.id = ?1 or t.bankAccountReceive.cardHolder.id = ?1) and t.createDate between ?2 and ?3 order by t.createDate desc")
    List<Transaction> findTransactionByCreateDateAndCustomer(String customerId, Date startDate, Date endDate);

    @Query("SELECT t FROM Transaction t WHERE (t.bankAccountReceive.id = ?1 OR t.bankAccountSend.id = ?1) and t.createDate between ?2 and ?3  order by t.createDate desc")
    List<Transaction> findTransactionByBankAccountAndCreateDate(String bankAccountId, Date startDate, Date endDate);
}
