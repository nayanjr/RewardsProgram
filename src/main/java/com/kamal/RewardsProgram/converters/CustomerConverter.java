package com.kamal.RewardsProgram.converters;

import com.kamal.RewardsProgram.dto.CustomerRewardsDto;
import com.kamal.RewardsProgram.entities.Customer;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Component;

import java.time.YearMonth;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

@Component
public class CustomerConverter {

    public CustomerRewardsDto entityToCustomerRewardsDto(Customer customer) {
        CustomerRewardsDto dto = new CustomerRewardsDto();

        dto.setCustomerDisplayName(customer.getDisplayName());
        dto.setTotalRewards(customer.getTransactions().stream()
                .collect(summingInt(e -> e.calculateRewardPoints())));
        dto.setMonthlyRewards(customer.getTransactions().stream()
                .collect(groupingBy(e -> YearMonth.from(e.getDate()), summingInt(e -> e.calculateRewardPoints()))));

        return dto;
    }

    public List<CustomerRewardsDto> entityListToCustomerRewardsDtoList(List<Customer> customers) {
        return customers.stream().map(x -> entityToCustomerRewardsDto(x)).collect(Collectors.toList());
    }
}
