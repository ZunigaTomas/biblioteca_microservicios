package com.zunigatomas.loans.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.time.Duration;
import java.util.Date;

@Entity @Getter @Setter @ToString @AllArgsConstructor @NoArgsConstructor
@Table(name = "loans")
public class Loan extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "book_id", nullable = false)
    private Long bookId;

    @Column(name = "loan_date", nullable = false)
    private Date loanDate;

    @Column(name = "return_date")
    private Date returnDate;

    @Transient
    private Duration loanDuration;

}
