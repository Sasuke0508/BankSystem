package com.sasuke0508.banksystem.service;

import com.sasuke0508.banksystem.entity.User;

public interface UserService {
    /**
     * Check username is existed
     * @param username
     * @return true if username exits, else return false
     */
    public boolean checkUserNameExist(String username);

    /**
     * Check email is existed
     * @param email
     * @return true if email exits, else return false
     */
    public boolean checkEmailExist(String email);

    /**
     * Check phone number is existed
     * @param phoneNumber
     * @return true if phoneNumber exits, else return false
     */
    public boolean checkPhoneNumberExist(String phoneNumber);

    /**
     * Check id card number is existed
     * @param idCardNumber
     * @return true if idCardNumber exits, else return false
     */
    public boolean checkIdCardNumberExist(String idCardNumber);

    /**
     * Handle login
     * @param email
     * @param password
     * @return User != null if login success, else return null
     */
    public User processLogin(String email, String password);
}
