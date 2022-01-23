package com.sasuke0508.banksystem.service;

import com.sasuke0508.banksystem.entity.Customer;
import com.sasuke0508.banksystem.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    private CustomerRepository customerRepo;
    /**
     * Create new customer
     *
     * @param customer
     * @return customer if create success, else return null
     */
    @Override
    public Customer addCustomer(Customer customer) {
        return customerRepo.save(customer);
    }

    /**
     * Edit info of customer
     *
     * @param customerEdit
     * @return customer after edit
     */
    @Override
    public Customer editCustomer(Customer customerEdit) {
        return customerRepo.save(customerEdit);
    }

    /**
     * Delete customer by id
     *
     * @param customerId
     * @return true if delete success, else return false
     */
    @Override
    public boolean deleteCustomer(String customerId) {
        Optional<Customer> optionalCustomer = customerRepo.findById(customerId);
        if (optionalCustomer.isPresent()) {
            customerRepo.delete(optionalCustomer.get());
            Optional<Customer> optionalCustomer_check = customerRepo.findById(customerId);
            if(!optionalCustomer_check.isPresent()){
                return true;
            }
        }
        return false;
    }

    /**
     * Get all customer
     *
     * @return List customer
     */
    @Override
    public List<Customer> getAllCustomer() {
        return customerRepo.findAll();
    }

    /**
     * Get information of customer by id
     *
     * @param customerId
     * @return customer
     */
    @Override
    public Customer getInfoCustomer(String customerId) {
        return customerRepo.findById(customerId).get();
    }
}
