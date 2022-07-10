package com.ekenkel.springdemo.dao;

import com.ekenkel.springdemo.entity.Customer;

import java.util.List;

public interface CustomerDAO {
    public List<Customer> getCustomers();

    void saveOrUpdateCustomer(Customer customer);

    Customer getCustomer(int id);

    void deleteCustomer(int id);

    List<Customer> searchCustomers(String searchName);
}
