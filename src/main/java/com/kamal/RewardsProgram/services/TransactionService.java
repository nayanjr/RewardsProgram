package com.kamal.RewardsProgram.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kamal.RewardsProgram.entities.Transaction;
import com.kamal.RewardsProgram.repositories.TransactionRepository;

import java.util.List;

@Service
public class TransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    public Transaction save(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    public List<Transaction> getAll() {
        return (List<Transaction>)transactionRepository.findAll();
    }
}
