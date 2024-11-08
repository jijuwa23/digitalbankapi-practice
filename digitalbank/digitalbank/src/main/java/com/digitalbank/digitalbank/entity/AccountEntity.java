package com.digitalbank.digitalbank.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@Table(name = "account_table")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountEntity {
    @Id
    @Column(name = "account_id")
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @Column(name = "account_balance")
    private BigDecimal balance;

    @Column(name = "account_status")
    private String status;

    @Column(name = "account_type")
    private String accountType;

    public void addToBalance(BigDecimal amount) {
        if (amount != null) {
            this.balance = this.balance.add(amount);
        }
    }

    public void deductToBalance(BigDecimal amount) {
        if (amount != null) {
            this.balance = this.balance.subtract(amount);
        }
    }
}