package com.sasuke0508.banksystem.repository;

import com.sasuke0508.banksystem.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {
    @Modifying(clearAutomatically = true)
    @Transactional
    @Query(value = "DELETE FROM employee WHERE userId = ?1", nativeQuery = true)
    int deleteEmployeeByID(String id);
}
