package com.sasuke0508.banksystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {
    @Id
    private String id;

    @ManyToOne(targetEntity = Employee.class)
    @JoinColumn(name = "EmployeeCreateId")
    private Employee employeeCreate;

    @ManyToOne(targetEntity = BankAccount.class)
    @JoinColumn(name = "BankAccountSendId")
    private BankAccount bankAccountSend;

    @ManyToOne(targetEntity = BankAccount.class)
    @JoinColumn(name = "BankAccountReceiveId")
    private BankAccount bankAccountReceive;

    private String description;
    private double amount;
    private String status;
    private Date createDate;
    private String type;
    private double fee;
}
