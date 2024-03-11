package com.zunigatomas.loans.repository;

import com.zunigatomas.loans.entity.Loans;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LoansRepository extends JpaRepository<Loans, Long> {
    Optional<Loans> findByUserId(Long userId);
}
