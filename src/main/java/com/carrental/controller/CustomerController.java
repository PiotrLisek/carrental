package com.carrental.controller;

import com.carrental.domain.model.Customer;
import com.carrental.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/customer")
@Slf4j
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("/create")
    public String createCustomerForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "customer/form";
    }

    @PostMapping("/create")
    public String createCustomer(@ModelAttribute("customer") Customer customer) {
        customerService.createCustomer(customer);
        log.info("Created new customer {}", customer);

        return "redirect:/customer/list";
    }

    @GetMapping("/list")
    public String customerList(Model model) {
        List<Customer> customers = customerService.getAllCustomers();

        model.addAttribute("customers", customers);
        return "customer/list";
    }
}
