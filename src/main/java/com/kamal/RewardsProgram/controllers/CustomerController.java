package com.kamal.RewardsProgram.controllers;

import com.kamal.RewardsProgram.dto.CustomerRewardsDto;
import com.kamal.RewardsProgram.entities.Customer;
import com.kamal.RewardsProgram.services.CustomerService;
import com.kamal.RewardsProgram.converters.CustomerConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//@CrossOrigin(origins = "http://localhost:3000/")
@Controller
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    CustomerConverter customerConverter;

    @Autowired
    CustomerService customerService;


    @GetMapping("/rewards")
    public String displayCustomerRewards(Model model) {

        List<Customer> customers = customerService.getAll();
        List<CustomerRewardsDto> customerRewardsDto = customerConverter.entityListToCustomerRewardsDtoList(customers);
        model.addAttribute("customerRewardsList", customerRewardsDto);

        return "customers/rewards";
    }

//    @GetMapping("/rewards")
//    public ResponseEntity<List> displayCustomerRewards() {
//
//        List<Customer> customers = customerService.getAll();
//        List<CustomerRewardsDto> customerRewardsDto = customerConverter.entityListToCustomerRewardsDtoList(customers);
//
//        return new ResponseEntity<List>(customerRewardsDto, HttpStatus.OK);
//
//
//    }


}
