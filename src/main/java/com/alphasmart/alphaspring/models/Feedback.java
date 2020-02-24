package com.alphasmart.alphaspring.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Map;

@Entity
public class Feedback {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;
    private String email;
    private String phone;
    private String comment;

    @JsonProperty("feedback")
    private void unpackRawFeedback(Map<String,String> feedback){
        this.name = (String) feedback.get("name");
        this.email = (String) feedback.get("email");
        this.phone = (String) feedback.get("phone");
        this.comment = (String) feedback.get("comment");
    }

    public Feedback() {
    }

    public Feedback(String name, String email, String phone, String comment) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.comment = comment;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
