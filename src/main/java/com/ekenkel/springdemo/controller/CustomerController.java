package com.ekenkel.springdemo.controller;

import com.ekenkel.springdemo.entity.Customer;
import com.ekenkel.springdemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/list")
    public String listCustomers(Model model) {
        List<Customer> customerList = customerService.getCustomers();
        model.addAttribute("customerList", customerList);
        return "list-customers";
    }

    @GetMapping("/showFormForAdd")
    public String showCustForm(Model model) {
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        return "customer-form";
    }

    @GetMapping("/showFormForUpdate")
    public String showCustUpdateForm(@RequestParam("customerId") int id,
                                     Model model) {
        Customer customer = customerService.getCustomer(id);
        model.addAttribute("customer", customer);
        return "customer-form";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer customer) {
        customerService.saveOrUpdateCustomer(customer);
        return "redirect:/customer/list";
    }

    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam("customerId") int id) {
        customerService.deleteCustomer(id);
        return "redirect:/customer/list";
    }

    @GetMapping("/search")
    public String searchCustomers(@RequestParam("searchName") String searchName, Model model) {
        List<Customer> customerList = customerService.searchCustomers(searchName);
        model.addAttribute("customerList", customerList);
        return "list-customers";
    }
}
