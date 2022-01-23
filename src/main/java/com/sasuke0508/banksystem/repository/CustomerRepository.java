package com.sasuke0508.banksystem.repository;

import com.sasuke0508.banksystem.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {
    @Modifying(clearAutomatically = true)
    @Transactional
    @Query(value = "DELETE FROM customer WHERE userId = ?1", nativeQuery = true)
    int deleteUserByID(String id);
}
