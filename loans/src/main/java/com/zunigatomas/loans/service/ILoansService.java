package com.zunigatomas.loans.service;

import com.zunigatomas.loans.dto.LoansDto;

import java.util.List;

public interface ILoansService {

    /**
     *
     * @param bookId - Loaned book ID
     * @param userId - Loaning user ID
     */
    void createLoan(Long userId, Long bookId);

    /**
     *
     * @param bookId - Book id
     * @return loans details given a certain loan number
     */
    LoansDto fetchLoan(Long bookId);

    /**
     *
     * @param userId - User id given by input
     * @return list of loans details given a certain user id
     */
    List<LoansDto> fetchAllUserLoans(Long userId);

    /**
     *
     * @param loansDto - LoansDto Object
     * @return boolean indicating if update was successful or not
     */
    boolean updateLoan(LoansDto loansDto);

    /**
     *
     * @param id - Loan id
     * @return boolean indicating if deletion was successful or not
     */
    boolean deleteLoan(Long id);
}
