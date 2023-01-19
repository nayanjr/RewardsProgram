package com.kamal.RewardsProgram.repositories;

import com.kamal.RewardsProgram.entities.Customer;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long> {
}
