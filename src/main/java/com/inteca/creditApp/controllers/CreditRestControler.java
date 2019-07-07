/*
* @author: Monika Kocot <mh.kocot@gmail.com>
* @date: 07.07.2019
* @description: Main RestController for creditApp
* @Task:
 */

package com.inteca.creditApp.controllers;

import com.inteca.creditApp.models.entities.Credit;
import com.inteca.creditApp.models.repositories.CreditRepository;
import com.inteca.creditApp.services.CreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CreditRestControler {

    CreditService creditService;
    CreditRepository creditRepository;

    @Autowired
    public CreditRestControler(CreditService creditService,CreditRepository creditRepository) {
        this.creditService = creditService;
        this.creditRepository = creditRepository;
    }

    /*******************************************************************************
     Purpose:  Method create new Credit for a Client and return ID number of Credit
     Parameters: String name, String customerName, String customerSurname, String customerPersonalId,String productName, int productValue
     Returns: int

     History
     --------
     VERSION     AUTHOR                  DATE            DETAIL          Description
     1.0         Monika Kocot            07/07/2019      Created
     ********************************************************************************/
    @PostMapping("/api/credit")
    public int createCredit(@RequestParam String name,
                                                  @RequestParam String customerName,
                                                  @RequestParam String customerSurname,
                                                  @RequestParam String customerPersonalId,
                                                  @RequestParam String productName,
                                                  @RequestParam int productValue){

        Credit credit = creditService.createCredit(name, customerName, customerSurname, customerPersonalId, productName, productValue);
        return credit.getId();
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
    @GetMapping("/api/credits")
    public List<Credit> getCredits(){

        List<Credit> credits = creditService.getCredits();
        return creditRepository.findAll();
    }
}
