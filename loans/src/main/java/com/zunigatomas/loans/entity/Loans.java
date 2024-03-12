package com.zunigatomas.loans.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.time.Duration;
import java.time.LocalDateTime;

@Entity @Getter @Setter @ToString @AllArgsConstructor @NoArgsConstructor
public class Loans extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "book_id", nullable = false)
    private Long bookId;

    @Column(name = "loan_number", nullable = false)
    private Long loanNumber;

    @Column(name = "loan_date", nullable = false)
    private LocalDateTime loanDate;

    @Column(name = "return_date")
    private LocalDateTime returnDate;

    @Transient
    private Duration loanDuration;

    @PostLoad
    private void calculateLoanDuration() {
        if (returnDate != null) {
            loanDuration = Duration.between(loanDate, returnDate);
        }
    }
}
