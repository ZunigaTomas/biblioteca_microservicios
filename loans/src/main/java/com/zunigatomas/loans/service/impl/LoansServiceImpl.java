package com.zunigatomas.loans.service.impl;

import com.zunigatomas.loans.dto.LoansDto;
import com.zunigatomas.loans.entity.Loans;
import com.zunigatomas.loans.exception.LoanAlreadyExistsException;
import com.zunigatomas.loans.exception.ResourceNotFoundException;
import com.zunigatomas.loans.mapper.LoansMapper;
import com.zunigatomas.loans.repository.LoansRepository;
import com.zunigatomas.loans.service.ILoansService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class LoansServiceImpl implements ILoansService {
    private final Random random = new Random();
    private LoansRepository loansRepository;
    /**
     * @param userId - Loaning user ID
     * @param bookId - Loaned book ID
     */
    @Override
    public void createLoan(Long userId, Long bookId) {
        //acá van a ir las llamadas con feign clients para verificar la existencia de los libros y usuarios
        Optional<Loans> optionalLoans = loansRepository.findByUserIdAndBookId(userId, bookId);
        if(optionalLoans.isPresent()) {
            throw new LoanAlreadyExistsException("User with id " + userId + " has already a loan registered for book with id " + bookId + ".");
        }
        loansRepository.save(createNewLoan(userId, bookId));
    }

    private Loans createNewLoan(Long userId, Long bookId) {
        LocalDateTime loanDate = LocalDateTime.now();
        LocalDateTime returnDate = loanDate.plusDays(10);
        Loans newLoan = new Loans();
        int randomVal = random.nextInt(9000000);
        long randomLoanNumber = 10000000L + randomVal;
        newLoan.setLoanNumber(randomLoanNumber);
        newLoan.setUserId(userId);
        newLoan.setBookId(bookId);
        newLoan.setLoanDate(loanDate);
        newLoan.setReturnDate(returnDate);

        return newLoan;
    }

    /**
     * @param loanNumber - Loan registration number
     * @return loans details given a certain loan number
     */
    @Override
    public LoansDto fetchLoan(Long bookId) {
        Loans loans = loansRepository.findByBookId(bookId).orElseThrow(
                () -> new ResourceNotFoundException("Loan", "bookId", String.valueOf(bookId))
        );
        return LoansMapper.mapToLoansDto(loans, new LoansDto());
    }

    /**
     * @param userId - User id given by input
     * @return list of loans details given a certain user id
     */
    @Override
    public List<LoansDto> fetchAllUserLoans(Long userId) {
        List<Loans> loansList = loansRepository.findByUserId(userId).orElseThrow(
                () -> new ResourceNotFoundException("User loans", "userId", String.valueOf(userId))
        );
        return loansList.stream().map(loan -> LoansMapper.mapToLoansDto(loan, new LoansDto())).toList();
    }

    /**
     * @param loansDto - LoansDto Object
     * @return boolean indicating if update was successful or not
     */
    @Override
    public boolean updateLoan(LoansDto loansDto) {
        Loans loans = loansRepository.findByLoanNumber(loansDto.getLoanNumber()).orElseThrow(
                () -> new ResourceNotFoundException("Loan", "loanNumber", String.valueOf(loansDto.getLoanNumber()))
        );
        LoansMapper.mapToLoans(loansDto, loans);
        loansRepository.save(loans);
        return true;
    }

    /**
     * @param id - Loan id
     * @return boolean indicating if deletion was successful or not
     */
    @Override
    public boolean deleteLoan(Long bookId) {
        Loans loans = loansRepository.findById(bookId).orElseThrow(
                () -> new ResourceNotFoundException("Loan", "bookId", String.valueOf(bookId))
        );
        loansRepository.deleteByLoanNumber(loans.getLoanNumber());
        return false;
    }
}
