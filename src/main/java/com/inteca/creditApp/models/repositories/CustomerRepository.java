/*
* @author: Monika Kocot <mh.kocot@gmail.com>
* @date: 07.07.2019
* @description: JPA Repository interface for Customers
* @Task:
 */

package com.inteca.creditApp.models.repositories;

import com.inteca.creditApp.models.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {

    List<Customer> findAllByCreditId(Integer id);
}
