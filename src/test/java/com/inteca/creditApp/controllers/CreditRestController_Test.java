/*
* @author: Monika Kocot <mh.kocot@gmail.com>
* @date: 07.07.2019
* @description: Test class for CreditRestController.class
* @Task:
 */

package com.inteca.creditApp.controllers;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.inteca.creditApp.models.entities.Credit;
import com.inteca.creditApp.models.repositories.CreditRepository;
import com.inteca.creditApp.models.repositories.ProductRepository;
import com.inteca.creditApp.services.CreditService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import java.io.IOException;
import static org.junit.Assert.assertEquals;
import org.springframework.web.context.WebApplicationContext;


@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class CreditRestController_Test {

        protected MockMvc mvc;
        @Autowired
        WebApplicationContext webApplicationContext;
        @Autowired
        CreditRepository creditRepository;
        @Autowired
        ProductRepository productRepository;
        @Autowired
        CreditService creditService;

    /*******************************************************************************
     Purpose:  Methods used to create web application context by using MockMvc and define the mapToJson()
     and mapFromJson() methods to convert the Java object into JSON string and convert the JSON string into Java object
     DOES NOT WORK YET.

     History
     --------
     VERSION     AUTHOR                  DATE            DETAIL          Description
     1.0         Monika Kocot            07/07/2019      Created
     ********************************************************************************/
    protected void setUp() {
        mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }
    public String mapToJson(Object obj) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(obj);
    }
    protected <T> T mapFromJson(String json, Class<T> clazz) throws JsonParseException, JsonMappingException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(json, clazz);
    }

    /*******************************************************************************
     Purpose:  Test for method createCredit checking the response status of CreditRestController
     DOES NOT WORK YET.

     History
     --------
     VERSION     AUTHOR                  DATE            DETAIL          Description
     1.0         Monika Kocot            07/07/2019      Created
     ********************************************************************************/
    @Test
    // does not work yet
    public void createCreditTest() throws Exception {
        String uri = "/api/credit";
        String name = "CreditTest";
        String customerName = "Nicole";
        String customerSurname = "Hyny";
        String customerPersonalId = "8646846";
        String productName = "AGD";
        int productValue = 5145;

        Credit credit = creditService.createCredit(name, customerName, customerSurname, customerPersonalId, productName, productValue);
        creditRepository.save(credit);

        String inputJson = mapToJson(credit);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(201, status);
    }

    /*******************************************************************************
     Purpose:  Test for method getCredits checking the response status of CreditRestController
     DOES NOT WORK YET.

     History
     --------
     VERSION     AUTHOR                  DATE            DETAIL          Description
     1.0         Monika Kocot            07/07/2019      Created
     ********************************************************************************/
    @Test
    // does not work yet
    public void getCredits() throws Exception {
        String uri = "/api/credits";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }

}
