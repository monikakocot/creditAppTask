/*
* @author: Monika Kocot <mh.kocot@gmail.com>
* @date: 07.07.2019
* @description: Test class for CreditService.class
* @Task:
 */

package com.inteca.creditApp.services;

import com.inteca.creditApp.models.entities.Credit;
import com.inteca.creditApp.models.entities.Product;
import com.inteca.creditApp.models.repositories.CreditRepository;
import com.inteca.creditApp.models.repositories.CustomerRepository;
import com.inteca.creditApp.models.repositories.ProductRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CreditService_Test {

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
     Purpose:  Test for method createCredit compering value of the name field of the
     Credit that this method returns after creating new Credit.

     History
     --------
     VERSION     AUTHOR                  DATE            DETAIL          Description
     1.0         Monika Kocot            07/07/2019      Created
     ********************************************************************************/
    @Test
    public void createCreditTest() throws Exception {
        String name = "CreditTest";
        String customerName = "Nicole";
        String customerSurname = "Hyny";
        String customerPersonalId = "8646846";
        String productName = "AGD";
        int productValue = 5145;

        Assert.assertEquals("CreditTest",creditService.createCredit(name,customerName,customerSurname,customerPersonalId,productName,productValue).getName());
    }

    /*******************************************************************************
     Purpose:  Test for method getCredits compering size of the List that this method returns
     after insert new Credit to Credit Repository.

     History
     --------
     VERSION     AUTHOR                  DATE            DETAIL          Description
     1.0         Monika Kocot            07/07/2019      Created
     ********************************************************************************/
    @Test
    public void getCreditsTest() throws Exception {

        Credit credit = new Credit("name222");

        Product product = new Product("product",222);
        Integer actualSize = creditRepository.findAll().size();

        productRepository.save(product);
        credit.addProduct(product);

        creditRepository.save(credit);
        product.setCredit(credit);
        productRepository.save(product);

        Assert.assertEquals(actualSize +1 ,creditService.getCredits().size());
    }
}
