/*
* @author: Monika Kocot <mh.kocot@gmail.com>
* @date: 07.07.2019
* @description: Test class for CustomerRepository.class
* @Task:
 */

package com.inteca.creditApp.repositories;

import com.inteca.creditApp.models.entities.Credit;
import com.inteca.creditApp.models.entities.Customer;
import com.inteca.creditApp.models.entities.Product;
import com.inteca.creditApp.models.repositories.CreditRepository;
import com.inteca.creditApp.models.repositories.CustomerRepository;
import com.inteca.creditApp.models.repositories.ProductRepository;
import com.inteca.creditApp.services.CreditService;
import com.inteca.creditApp.services.CustomerService;
import com.inteca.creditApp.services.ProductService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerRepository_Test {

    @Autowired
    ProductRepository productRepository;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    CreditRepository creditRepository;
    @Autowired
    CreditService creditService;
    @Autowired
    CustomerService customerService;
    @Autowired
    ProductService productService;

    /*******************************************************************************
     Purpose:  Test for method findAll compering size of the List  that this method returns
     after insert new Customer to Customer Repository.

     History
     --------
     VERSION     AUTHOR                  DATE            DETAIL          Description
     1.0         Monika Kocot            07/07/2019      Created
     ********************************************************************************/
    @Test
    public void findAllTest() throws Exception {
        Customer customer = new Customer("Eryk", "Bomba","91952");
        Integer actualSize = customerRepository.findAll().size();
        customerRepository.save(customer);
        Assert.assertEquals(actualSize +1,customerRepository.findAll().size());
    }

    /*******************************************************************************
     Purpose:  Test for method findAllByCreditId compering size of the List that this method returns
     after insert new Customer to Customer Repository.

     History
     --------
     VERSION     AUTHOR                  DATE            DETAIL          Description
     1.0         Monika Kocot            07/07/2019      Created
     ********************************************************************************/
    @Test
    public void findAllByCreditIdTest() throws Exception {

        Credit credit = new Credit("name999");

        Customer customer = new Customer("Arek","Lewy","995883152");
        Integer actualSize = customerRepository.findAllByCreditId(credit.getId()).size();

        customerRepository.save(customer);
        credit.addCustomer(customer);

        creditRepository.save(credit);
        customer.setCredit(credit);
        customerRepository.save(customer);

        Assert.assertEquals(actualSize+1 ,customerRepository.findAllByCreditId(credit.getId()).size());
    }
}
