/*
* @author: Monika Kocot <mh.kocot@gmail.com>
* @date: 07.07.2019
* @description: Service with functionalities for Customer model.
* @Task:
 */

package com.inteca.creditApp.services;

import com.inteca.creditApp.models.entities.Customer;
import com.inteca.creditApp.models.repositories.CreditRepository;
import com.inteca.creditApp.models.repositories.CustomerRepository;
import com.inteca.creditApp.models.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    CreditRepository creditRepository;
    CustomerRepository customerRepository;
    ProductRepository productRepository;

    @Autowired
    public CustomerService(CreditRepository creditRepository, CustomerRepository customerRepository, ProductRepository productRepository) {
        this.creditRepository = creditRepository;
        this.customerRepository = customerRepository;
        this.productRepository = productRepository;
    }

    /*******************************************************************************
     Purpose:  Method create new Customer
     Parameters: String name, String surname, String personalId
     Returns: Customer

     History
     --------
     VERSION     AUTHOR                  DATE            DETAIL          Description
     1.0         Monika Kocot            07/07/2019      Created
     ********************************************************************************/
    public Customer createCustomer(String name, String surname, String personalId) {
        Customer customer = new Customer(name, surname, personalId);
        customerRepository.save(customer);
        return customer;
    }

    /*******************************************************************************
     Purpose:  Method returns all custumers for specified credit ID number
     Parameters: int creditId
     Returns: List<Customer>

     History
     --------
     VERSION     AUTHOR                  DATE            DETAIL          Description
     1.0         Monika Kocot            07/07/2019      Created
     ********************************************************************************/
    public List<Customer> getCustomers(int creditId) {

        List<Customer> customers = customerRepository.findAllByCreditId(creditId);
        return customers;
    }

}
