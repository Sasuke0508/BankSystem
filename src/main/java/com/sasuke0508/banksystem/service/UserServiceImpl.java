package com.sasuke0508.banksystem.service;

import com.sasuke0508.banksystem.entity.User;
import com.sasuke0508.banksystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepo;

    /**
     * Check username is existed
     *
     * @param username
     * @return true if username exits, else return false
     */
    @Override
    public boolean checkUserNameExist(String username) {
        User user = userRepo.findByName(username);
        return user!=null;
    }

    /**
     * Check email is existed
     *
     * @param email
     * @return true if email exits, else return false
     */
    @Override
    public boolean checkEmailExist(String email) {
        User user = userRepo.findByEmail(email);
        return user!=null;
    }

    /**
     * Check phone number is existed
     *
     * @param phoneNumber
     * @return true if phoneNumber exits, else return false
     */
    @Override
    public boolean checkPhoneNumberExist(String phoneNumber) {
        User user = userRepo.findByPhoneNumber(phoneNumber);
        return user!=null;
    }

    /**
     * Check id card number is existed
     *
     * @param idCardNumber
     * @return true if idCardNumber exits, else return false
     */
    @Override
    public boolean checkIdCardNumberExist(String idCardNumber) {
        User user = userRepo.findByIdCardNumber(idCardNumber);
        return user!=null;
    }

    /**
     * Handle login
     *
     * @param email
     * @param password
     * @return User != null if login success, else return null
     */
    @Override
    public User processLogin(String email, String password) {
        User user = userRepo.findByEmail(email);
        if(user != null){
            if(!user.getPassword().equals(password)){
                return null;
            }
            return user;
        }
        return null;
    }
}
