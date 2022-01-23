package com.sasuke0508.banksystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor

public class User {
    @Id
    private String id;
    private String name;
    private String phoneNumber;
    private Date dateOfBirth;
    private String idCardNumber;
    private String email;
    private String password;
    private String address;
    private String gender;
    private String role;
    private Date createDate;
}
