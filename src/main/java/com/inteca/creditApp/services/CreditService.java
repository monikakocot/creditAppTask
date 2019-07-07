/*
* @author: Monika Kocot <mh.kocot@gmail.com>
* @date: 07.07.2019
* @description: Service with functionalities for Credit model.
* @Task:
 */

package com.inteca.creditApp.services;

import com.inteca.creditApp.models.entities.Credit;
import com.inteca.creditApp.models.entities.Customer;
import com.inteca.creditApp.models.entities.Product;
import com.inteca.creditApp.models.repositories.CreditRepository;
import com.inteca.creditApp.models.repositories.CustomerRepository;
import com.inteca.creditApp.models.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CreditService {

    CreditRepository creditRepository;
    CustomerRepository customerRepository;
    ProductRepository productRepository;
    CustomerService customerService;
    ProductService productService;

    @Autowired
    public CreditService(CreditRepository creditRepository, CustomerRepository customerRepository, ProductRepository productRepository,CustomerService customerService, ProductService productService) {
        this.creditRepository = creditRepository;
        this.customerRepository = customerRepository;
        this.productRepository = productRepository;
        this.customerService = customerService;
        this.productService = productService;
    }


    /*******************************************************************************
     Purpose:  Method create new Credit for a Client with Customer and product and return Credit model.
     Parameters: String name, String customerName, String customerSurname, String customerPersonalId,String productName, int productValue
     Returns: Credit

     History
     --------
     VERSION     AUTHOR                  DATE            DETAIL          Description
     1.0         Monika Kocot            07/07/2019      Created
     ********************************************************************************/
    public Credit createCredit(String name,
                                  String customerName, String customerSurname, String customerPersonalId,
                                  String productName, int productValue){
        Credit credit = new Credit(name);
        Customer customer = customerService.createCustomer(customerName,customerSurname,customerPersonalId);
        Product product = productService.createProduct(productName,productValue);

        credit.addCustomer(customer);
        credit.addProduct(product);
        creditRepository.save(credit);

        return credit;
    }

    /*******************************************************************************
     Purpose:  Method returns list of created credits with customers and products lists.
     Parameters: -
     Returns: List<Credit>

     History
     --------
     VERSION     AUTHOR                  DATE            DETAIL          Description
     1.0         Monika Kocot            07/07/2019      Created
     ********************************************************************************/
    public List<Credit> getCredits (){

        List<Credit> credits = creditRepository.findAll();

        for (int j=0; j <= credits.size()-1; j++) {
            int creditId = credits.get(j).getId();
            customerService.getCustomers(creditId);
            productService.getProducts(creditId);
        }
        return credits;
    }
}
