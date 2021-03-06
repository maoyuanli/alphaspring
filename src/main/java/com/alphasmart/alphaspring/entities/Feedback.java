package com.alphasmart.alphaspring.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.Map;

@Entity
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String phone;
    private String comment;
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @JsonProperty("feedback")
    private void unpackRawFeedback(Map<String, String> feedback) {
        this.name = (String) feedback.get("name");
        this.email = (String) feedback.get("email");
        this.phone = (String) feedback.get("phone");
        this.comment = (String) feedback.get("comment");
    }

    protected Feedback() {
    }

    public Feedback(String name, String email, String phone, String comment) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.comment = comment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
