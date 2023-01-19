package com.kamal.RewardsProgram.controllers;

import com.kamal.RewardsProgram.dto.CustomerRewardsDto;
import com.kamal.RewardsProgram.entities.Customer;
import com.kamal.RewardsProgram.services.CustomerService;
import com.kamal.RewardsProgram.comparators.CustomerComparator;
import com.kamal.RewardsProgram.converters.CustomerConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    CustomerConverter customerConverter;

    @Autowired
    CustomerService customerService;

    @GetMapping("/rewards")
    public String displayCustomerRewards(Model model) {

        Comparator comparator = new CustomerComparator();

        List<Customer> customers = customerService.getAll();
        Collections.sort(customers, comparator);
        List<CustomerRewardsDto> customerRewardsDto = customerConverter.entityListToCustomerRewardsDtoList(customers);
        model.addAttribute("customerRewardsList", customerRewardsDto);

        return "customers/rewards";
    }

}
