/*
* @author: Monika Kocot <mh.kocot@gmail.com>
* @date: 07.07.2019
* @description: Test class for CustomerService.class
* @Task:
 */


package com.inteca.creditApp.services;

import com.inteca.creditApp.models.entities.Credit;
import com.inteca.creditApp.models.entities.Customer;
import com.inteca.creditApp.models.repositories.CreditRepository;
import com.inteca.creditApp.models.repositories.CustomerRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerService_Test {

    @Autowired
    CustomerService customerService;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    CreditRepository creditRepository;

    /*******************************************************************************
     Purpose:  Test for method createCustomer compering value of the name field of the
     Customer that this method returns after creating new Customer.

     History
     --------
     VERSION     AUTHOR                  DATE            DETAIL          Description
     1.0         Monika Kocot            07/07/2019      Created
     ********************************************************************************/
    @Test
    public void createCustomerTest() throws Exception {

        String name = "Romek";
        String surname ="Pajac";
        String personalId = "4650";
        Assert.assertEquals("Romek",customerService.createCustomer(name,surname,personalId).getName());
    }

    /*******************************************************************************
     Purpose:  Test for method getCustomers compering size of the List that this method returns
     after insert new Customer to Customer Repository.

     History
     --------
     VERSION     AUTHOR                  DATE            DETAIL          Description
     1.0         Monika Kocot            07/07/2019      Created
     ********************************************************************************/
    @Test
    public void getCustomersTest() throws Exception {

        Credit credit = new Credit("name444");

        Customer customer = new Customer("Tomek","Koreky","556152");
        Integer actualSize = customerRepository.findAllByCreditId(credit.getId()).size();

        customerRepository.save(customer);
        credit.addCustomer(customer);

        creditRepository.save(credit);
        customer.setCredit(credit);
        customerRepository.save(customer);

        Assert.assertEquals(actualSize +1 ,customerService.getCustomers(credit.getId()).size());
    }

}
