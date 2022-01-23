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
public class BankAccount {
    @Id
    private String id;

    @ManyToOne(targetEntity = Customer.class)
    @JoinColumn(name = "CustomerId")
    private Customer cardHolder;

    @ManyToOne(targetEntity = Employee.class)
    @JoinColumn(name = "EmployeeId")
    private Employee employeeCreateAccount;

    @ManyToOne(targetEntity = Branch.class)
    @JoinColumn(name = "BranchId")
    private Branch branch;

    private String holderName;
    private String accountNumber;
    private String cardNumber;
    private boolean status;
    private Date createDate;
    private Date expireDate;
    private double balance;
    private String typeOfAccount;
    private String cvv;

    public boolean getStatus() {
        return status;
    }
}
