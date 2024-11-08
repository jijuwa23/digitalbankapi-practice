package com.digitalbank.digitalbank.dao;

import com.digitalbank.digitalbank.entity.AccountEntity;
import com.digitalbank.digitalbank.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {
}
