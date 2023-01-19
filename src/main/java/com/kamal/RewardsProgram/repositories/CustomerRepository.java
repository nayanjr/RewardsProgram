package com.kamal.RewardsProgram.repositories;

import com.kamal.RewardsProgram.entities.Customer;
import org.springframework.data.repository.CrudRepository;


public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
