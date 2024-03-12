package com.zunigatomas.loans.repository;

import com.zunigatomas.loans.entity.Loans;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LoansRepository extends JpaRepository<Loans, Long> {
    Optional<Loans> findByUserIdAndBookId(Long userId, Long bookId);
    Optional<List<Loans>> findByUserId(Long userId);
    Optional<Loans> findByLoanNumber(Long loanNumber);
    Optional<Loans> findByBookId(Long bookId);
    void deleteByLoanNumber(Long loanNumber);
}
