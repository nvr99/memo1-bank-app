package com.aninfo.service;

import com.aninfo.exceptions.InvalidTransactionTypeException;
import com.aninfo.exceptions.NotFoundCBUException;
import com.aninfo.model.Transaction;
import com.aninfo.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public Transaction createTransaction(Transaction transaction, AccountService accountService) {
        if(transaction.getTransactionType().equals("Deposit")) {
            accountService.deposit(transaction.getCbu(), transaction.getAmount());
        }
        else if (transaction.getTransactionType().equals("Withdraw")){
            accountService.withdraw(transaction.getCbu(), transaction.getAmount());
        }
        else {
            throw new InvalidTransactionTypeException("Error: Invalid operation type. Use: Deposit or Withdraw");
        }
        return transactionRepository.save(transaction);
    }

    public List<Transaction> findByCbu(Long cbu) {
        List<Transaction> transactionList = transactionRepository.findByCbu(cbu);
        if (transactionList.size()==0) {
            throw new NotFoundCBUException("Error: There is not account associated with the indicate CBU number ");
        }
        return transactionList;

    }

    public Optional<Transaction> findByTransactionId(Long transactionId) {
        return transactionRepository.findById(transactionId);
    }

    public void deleteByTransactionId(Long transactionId) {
        transactionRepository.deleteById(transactionId);
    }

}
