package com.ekenkel.springdemo.dao;

import com.ekenkel.springdemo.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Customer> getCustomers() {
        // get session
        Session session = sessionFactory.getCurrentSession();
        // create query
        Query<Customer> query = session.createQuery("from Customer order by lastName",
                Customer.class);
        // execute query and get result list
        return query.getResultList();
    }

    @Override
    public void saveOrUpdateCustomer(Customer customer) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(customer);
    }

    @Override
    public Customer getCustomer(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Customer.class, id);
    }

    @Override
    public void deleteCustomer(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("delete from Customer where id=:customerId");
        query.setParameter("customerId", id);
        query.executeUpdate();
    }

    @Override
    public List<Customer> searchCustomers(String searchName) {
        Session currentSession = sessionFactory.getCurrentSession();

        Query theQuery = null;

        // only search by name if theSearchName is not empty
        if (searchName != null && searchName.trim().length() > 0) {
            // search for firstName or lastName ... case insensitive
            theQuery =currentSession.createQuery("from Customer where lower(firstName) like :theName or lower(lastName) like :theName", Customer.class);
            theQuery.setParameter("theName", "%" + searchName.toLowerCase() + "%");
        }
        else {
            // theSearchName is empty ... so just get all customers
            theQuery =currentSession.createQuery("from Customer", Customer.class);
        }

        // execute query and get result list
        return theQuery.getResultList();
    }
}
