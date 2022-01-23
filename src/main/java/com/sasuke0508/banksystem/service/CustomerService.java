package com.sasuke0508.banksystem.service;

import com.sasuke0508.banksystem.entity.Branch;
import com.sasuke0508.banksystem.entity.Customer;

import java.util.List;

public interface CustomerService {
    /**
     * Create new customer
     * @param customer
     * @return customer if create success, else return null
     */
    public Customer addCustomer(Customer customer);

    /**
     * Edit info of customer
     * @param customerEdit
     * @return customer after edit
     */
    public Customer editCustomer(Customer customerEdit);

    /**
     * Delete customer by id
     * @param customerId
     * @return true if delete success, else return false
     */
    public boolean deleteCustomer(String customerId);

    /**
     * Get all customer
     * @return List customer
     */
    public List<Customer> getAllCustomer();

    /**
     * Get information of customer by id
     * @param customerId
     * @return customer
     */
    public Customer getInfoCustomer(String customerId);
}
