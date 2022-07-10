package com.ekenkel.springdemo.service;

import com.ekenkel.springdemo.entity.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> getCustomers();

    void saveOrUpdateCustomer(Customer customer);

    Customer getCustomer(int id);

    void deleteCustomer(int id);

    List<Customer> searchCustomers(String searchName);
}
