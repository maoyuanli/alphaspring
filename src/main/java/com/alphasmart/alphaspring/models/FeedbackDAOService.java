package com.alphasmart.alphaspring.models;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class FeedbackDAOService {

    @PersistenceContext
    private EntityManager entityManager;

    public Long insert(Feedback feedback){
        entityManager.persist(feedback);
        return feedback.getId();
    }



}
