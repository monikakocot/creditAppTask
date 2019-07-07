/*
* @author: Monika Kocot <mh.kocot@gmail.com>
* @date: 07.07.2019
* @description: Test class for CreditRepository.class
* @Task:
 */
package com.inteca.creditApp.repositories;

import com.inteca.creditApp.models.entities.Credit;
import com.inteca.creditApp.models.repositories.CreditRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class CreditRepository_Test {


    @Autowired
    CreditRepository creditRepository;

    @Before
    public void setUp() throws Exception {
    }

    /*******************************************************************************
     Purpose:  Test for method save.

     History
     --------
     VERSION     AUTHOR                  DATE            DETAIL          Description
     1.0         Monika Kocot            07/07/2019      Created
     ********************************************************************************/
    @Test
    public void saveTest() throws Exception {

        Credit credit = new Credit("name149");
        Integer id = credit.getId();
        creditRepository.save(credit);

        Assert.assertEquals("name149" ,creditRepository.findById(credit.getId()).get().getName());
    }

}
