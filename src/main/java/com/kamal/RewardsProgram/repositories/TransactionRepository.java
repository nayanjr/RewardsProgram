package com.kamal.RewardsProgram.repositories;

import com.kamal.RewardsProgram.entities.Transaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TransactionRepository extends CrudRepository<Transaction, Long> {
}
