/*
* @author: Monika Kocot <mh.kocot@gmail.com>
* @date: 07.07.2019
* @description: Entity model for Customer
* @Task:
 */
package com.inteca.creditApp.models.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.*;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String surname;
    private String personalId;

    public Customer(String name, String surname, String personalId) {
        this.name = name;
        this.surname = surname;
        this.personalId = personalId;
    }

    public Customer() {
    }

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "creditId")
    private Credit credit;

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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPersonalId() {
        return personalId;
    }

    public void setPersonalId(String personalId) {
        this.personalId = personalId;
    }

    public Credit getCredit() {
        return credit;
    }

    public void setCredit(Credit credit) {
        this.credit = credit;
    }
}
