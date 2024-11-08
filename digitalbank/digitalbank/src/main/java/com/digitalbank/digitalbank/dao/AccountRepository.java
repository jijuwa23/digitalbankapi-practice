package com.digitalbank.digitalbank.dao;

import com.digitalbank.digitalbank.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<AccountEntity, Long> {

    Optional<AccountEntity> findByAccountTypeAndId(String accountType, Long id);
}
