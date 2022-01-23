package com.sasuke0508.banksystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee extends  User{
    private String position;
    private String department;

    @ManyToOne(targetEntity = Branch.class)
    @JoinColumn(name = "BranchId")
    private Branch branch;
}
