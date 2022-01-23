package com.sasuke0508.banksystem.service;

import com.sasuke0508.banksystem.entity.Customer;
import com.sasuke0508.banksystem.entity.Employee;
import com.sasuke0508.banksystem.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;

    /**
     * Add new employee
     *
     * @param newEmployee
     * @return new employee
     */
    @Override
    public Employee addEmployee(Employee newEmployee) {
        return employeeRepository.save(newEmployee);
    }

    /**
     * Edit information of employee
     *
     * @param employeeEdit
     * @return employee after edit
     */
    @Override
    public Employee editEmployee(Employee employeeEdit) {
        return employeeRepository.save(employeeEdit);
    }

    /**
     * Delete employee by id
     *
     * @param employeeId
     * @return true if delete success, else return false
     */
    @Override
    public boolean deleteEmployee(String employeeId) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(employeeId);
        if(optionalEmployee.isPresent()){
            employeeRepository.delete(optionalEmployee.get());
            Optional<Employee> optionalEmployee_check = employeeRepository.findById(employeeId);
            if(!optionalEmployee_check.isPresent()){
                return true;
            }
        }
        return false;
    }

    /**
     * Get information of employee by id
     *
     * @param employeeId
     * @return info of employee
     */
    @Override
    public Employee getInfoEmployee(String employeeId) {
        return employeeRepository.getById(employeeId);
    }

    /**
     * Get all employee
     *
     * @return all employee
     */
    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }
}
