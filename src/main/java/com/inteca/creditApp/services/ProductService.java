/*
* @author: Monika Kocot <mh.kocot@gmail.com>
* @date: 07.07.2019
* @description: Service with functionalities for Product model.
* @Task:
 */

package com.inteca.creditApp.services;

import com.inteca.creditApp.models.entities.Product;
import com.inteca.creditApp.models.repositories.CreditRepository;
import com.inteca.creditApp.models.repositories.CustomerRepository;
import com.inteca.creditApp.models.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService {

    CreditRepository creditRepository;
    CustomerRepository customerRepository;
    ProductRepository productRepository;

    @Autowired
    public ProductService(CreditRepository creditRepository, CustomerRepository customerRepository, ProductRepository productRepository) {
        this.creditRepository = creditRepository;
        this.customerRepository = customerRepository;
        this.productRepository = productRepository;
    }

    /*******************************************************************************
     Purpose:  Method create new Product
     Parameters: String name, int value
     Returns: Product

     History
     --------
     VERSION     AUTHOR                  DATE            DETAIL          Description
     1.0         Monika Kocot            07/07/2019      Created
     ********************************************************************************/
    public Product createProduct(String name, int value) {
        Product product = new Product(name,value);
        productRepository.save(product);
        return product;
    }

    /*******************************************************************************
     Purpose:  Method returns all products for specified credit ID number
     Parameters: int creditId
     Returns: List<Product>

     History
     --------
     VERSION     AUTHOR                  DATE            DETAIL          Description
     1.0         Monika Kocot            07/07/2019      Created
     ********************************************************************************/
    public List<Product> getProducts(int creditId) {

        List<Product> products = productRepository.findAllByCreditId(creditId);
        return products;
    }
}
