package com.sasuke0508.banksystem.service;

import com.sasuke0508.banksystem.entity.Employee;

import java.util.List;

public interface EmployeeService {
    /**
     * Add new employee
     * @param newEmployee
     * @return new employee
     */
    public Employee addEmployee(Employee newEmployee);

    /**
     * Edit information of employee
     * @param employeeEdit
     * @return employee after edit
     */
    public Employee editEmployee(Employee employeeEdit);

    /**
     * Delete employee by id
     * @param employeeId
     * @return true if delete success, else return false
     */
    public boolean deleteEmployee(String employeeId);

    /**
     * Get information of employee by id
     * @param employeeId
     * @return info of employee
     */
    public Employee getInfoEmployee(String employeeId);

    /**
     * Get all employee
     * @return all employee
     */
    public List<Employee> getAllEmployee();
}
