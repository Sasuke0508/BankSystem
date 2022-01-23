package com.sasuke0508.banksystem.repository;

import com.sasuke0508.banksystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    User findByName(String username);
    User findByEmail(String email);
    User findByIdCardNumber(String idCardNumber);
    User findByPhoneNumber(String phoneNumber);

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query(value = "DELETE FROM user WHERE Id = ?1", nativeQuery = true)
    int deleteUserByID(String id);
}
