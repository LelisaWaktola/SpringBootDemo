package com.practice.demo1.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name="expenses", indexes = {
        @Index(name = "idx_expense_user_id", columnList = "user_id", unique = true)
})
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal amount;
    private String description;

    @ManyToOne
    private User user;

}
