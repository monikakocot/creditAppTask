/*
* @author: Monika Kocot <mh.kocot@gmail.com>
* @date: 07.07.2019
* @description: Test class for ProductRepository.class
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
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductRepository_Test {

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
     after insert new Product to Product Repository.

     History
     --------
     VERSION     AUTHOR                  DATE            DETAIL          Description
     1.0         Monika Kocot            07/07/2019      Created
     ********************************************************************************/
    @Test
    public void findAllTest() throws Exception {
        Product product = new Product("productTest",555);
        Integer actualSize = productRepository.findAll().size();
        productRepository.save(product);
        Assert.assertEquals(actualSize +1,productRepository.findAll().size());
    }

    /*******************************************************************************
     Purpose:  Test for method findAllByCreditId compering size of the List that this method returns
     after insert new Product to Product Repository.

     History
     --------
     VERSION     AUTHOR                  DATE            DETAIL          Description
     1.0         Monika Kocot            07/07/2019      Created
     ********************************************************************************/
    @Test
    public void findAllByCreditIdTest() throws Exception {

        Credit credit = new Credit("name777");

        Product product = new Product("product",888);
        Integer actualSize = productRepository.findAllByCreditId(credit.getId()).size();

        productRepository.save(product);
        credit.addProduct(product);

        creditRepository.save(credit);
        product.setCredit(credit);
        productRepository.save(product);

        Assert.assertEquals(actualSize+1 ,productRepository.findAllByCreditId(credit.getId()).size());
    }
}
