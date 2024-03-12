package com.zunigatomas.loans.dto;

import lombok.Data;

import java.time.Duration;
import java.time.LocalDateTime;

@Data
public class LoansDto {

    private Long userId;

    private Long bookId;

    private Long loanNumber;

    private LocalDateTime loanDate;

    private LocalDateTime returnDate;

    private Duration loanDuration;
}
