/*
* @author: Monika Kocot <mh.kocot@gmail.com>
* @date: 07.07.2019
* @description: Entity model for Product
* @Task:
 */

package com.inteca.creditApp.models.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.*;


@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private int value;

    public Product(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public Product() {
    }

    public Product(int id, String name, int value, Credit credit) {
        this.id = id;
        this.name = name;
        this.value = value;
        this.credit = credit;
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

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Credit getCredit() {
        return credit;
    }

    public void setCredit(Credit credit) {
        this.credit = credit;
    }

}
