/*
* @author: Monika Kocot <mh.kocot@gmail.com>
* @date: 07.07.2019
* @description: Entity model for Credit
* @Task:
 */

package com.inteca.creditApp.models.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class,property="id" ) //to not loop app (JSON)
@Entity
public class Credit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;

    @OneToMany(mappedBy = "credit",cascade = {CascadeType.MERGE, CascadeType.REFRESH})
    List<Customer> customers = new ArrayList<>();

    @OneToMany(mappedBy = "credit",cascade = {CascadeType.MERGE, CascadeType.REFRESH})
    private List<Product> products = new ArrayList<>();

    public void addCustomer(Customer customer) {
        customers.add(customer);
        customer.setCredit(this);
    }

    public void addProduct (Product product) {
        products.add(product);
        product.setCredit(this);
    }

    public Credit(int id, String name, List<Customer> customers, List<Product> products) {
        this.id = id;
        this.name = name;
        this.customers = customers;
        this.products = products;
    }

    public Credit(String name, List<Customer> customers, List<Product> products) {
        this.name = name;
        this.customers = customers;
        this.products = products;
    }

    public Credit(String name) {
        this.name = name;
    }

    public Credit() {

    }

    //  GETTERS, SETTERS, TOSTRING
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
