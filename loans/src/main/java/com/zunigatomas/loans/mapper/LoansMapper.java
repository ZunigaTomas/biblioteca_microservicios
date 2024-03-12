package com.zunigatomas.loans.mapper;

import com.zunigatomas.loans.dto.LoansDto;
import com.zunigatomas.loans.entity.Loans;

public class LoansMapper {

    public static LoansDto mapToLoansDto(Loans loans, LoansDto loansDto) {
        loansDto.setUserId(loans.getUserId());
        loansDto.setBookId(loans.getBookId());
        loansDto.setLoanNumber(loans.getLoanNumber());
        loansDto.setLoanDate(loans.getLoanDate());
        loansDto.setReturnDate(loans.getReturnDate());
        loansDto.setLoanDuration(loans.getLoanDuration());

        return loansDto;
    }

    public static Loans mapToLoans(LoansDto loansDto, Loans loans) {
        loans.setUserId(loansDto.getUserId());
        loans.setBookId(loansDto.getBookId());
        loans.setLoanNumber(loansDto.getLoanNumber());
        loans.setLoanDate(loansDto.getLoanDate());
        loans.setReturnDate(loansDto.getReturnDate());
        loans.setLoanDuration(loans.getLoanDuration());

        return loans;
    }
}
