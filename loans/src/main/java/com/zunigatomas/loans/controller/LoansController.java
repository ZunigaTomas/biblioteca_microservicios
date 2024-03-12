package com.zunigatomas.loans.controller;

import com.zunigatomas.loans.constants.LoansConstants;
import com.zunigatomas.loans.dto.LoansDto;
import com.zunigatomas.loans.dto.ResponseDto;
import com.zunigatomas.loans.service.ILoansService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
public class LoansController {
    private final ILoansService loansService;
    public LoansController(ILoansService loansService) {
        this.loansService = loansService;
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createLoan(@RequestParam Long userId, @RequestParam Long bookId) {
        loansService.createLoan(userId, bookId);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(LoansConstants.STATUS_201, LoansConstants.MESSAGE_201));
    }
    @GetMapping("/fetch")
    public ResponseEntity<LoansDto> fetchLoanDetails(@RequestParam Long bookId) {
        LoansDto loansDto = loansService.fetchLoan(bookId);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(loansDto);
    }
    @GetMapping("/fetchAll")
    public ResponseEntity<List<LoansDto>> fetchUserLoans(@RequestParam Long userId) {
        List<LoansDto> userLoans = loansService.fetchAllUserLoans(userId);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userLoans);
    }
    @PutMapping("/update")
    public ResponseEntity<ResponseDto> updateLoanDetails(@RequestBody LoansDto loansDto) {
        boolean isUpdated = loansService.updateLoan(loansDto);

        if(isUpdated) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDto(LoansConstants.STATUS_200, LoansConstants.MESSAGE_200));
        } else {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDto(LoansConstants.STATUS_417, LoansConstants.MESSAGE_417_UPDATE));
        }
    }
    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDto> deleteLoanDetails(@RequestParam Long bookId) {
        boolean isDeleted = loansService.deleteLoan(bookId);

        if(isDeleted) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDto(LoansConstants.STATUS_200, LoansConstants.MESSAGE_200));
        } else {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDto(LoansConstants.STATUS_417, LoansConstants.MESSAGE_417_DELETE));
        }
    }
}
