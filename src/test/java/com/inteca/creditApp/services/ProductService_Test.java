/*
* @author: Monika Kocot <mh.kocot@gmail.com>
* @date: 07.07.2019
* @description: Test class for ProductService.class
* @Task:
 */

package com.inteca.creditApp.services;

import com.inteca.creditApp.models.entities.Credit;
import com.inteca.creditApp.models.entities.Product;
import com.inteca.creditApp.models.repositories.CreditRepository;
import com.inteca.creditApp.models.repositories.ProductRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductService_Test {

    @Autowired
    ProductService productService;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    CreditRepository creditRepository;

    /*******************************************************************************
     Purpose:  Test for method createProduct compering value of the name field of the
     Product that this method returns after creating new Product.

     History
     --------
     VERSION     AUTHOR                  DATE            DETAIL          Description
     1.0         Monika Kocot            07/07/2019      Created
     ********************************************************************************/
    @Test
    public void createProductTest() throws Exception {

        String name = "Ala";
        int value = 22;
        Assert.assertEquals("Ala",productService.createProduct(name,value).getName());
    }

    /*******************************************************************************
     Purpose:  Test for method getProducts compering size of the List that this method returns
     after insert new Product to Product Repository.

     History
     --------
     VERSION     AUTHOR                  DATE            DETAIL          Description
     1.0         Monika Kocot            07/07/2019      Created
     ********************************************************************************/
    @Test
    public void getProductsTest() throws Exception {

        Credit credit = new Credit("name444");

        Product product = new Product("product",444);
        Integer actualSize = productRepository.findAllByCreditId(credit.getId()).size();

        productRepository.save(product);
        credit.addProduct(product);

        creditRepository.save(credit);
        product.setCredit(credit);
        productRepository.save(product);

        Assert.assertEquals(actualSize +1 ,productService.getProducts(credit.getId()).size());
    }

}
