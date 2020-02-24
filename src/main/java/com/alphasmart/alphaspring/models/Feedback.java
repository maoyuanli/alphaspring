package com.alphasmart.alphaspring.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Feedback {

    @Id
    @GeneratedValue
    private Integer id;
}
