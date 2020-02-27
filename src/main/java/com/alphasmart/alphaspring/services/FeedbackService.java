package com.alphasmart.alphaspring.services;

import com.alphasmart.alphaspring.entities.Feedback;
import com.alphasmart.alphaspring.repositories.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeedbackService {

    @Autowired
    FeedbackRepository feedbackRepository;

    public Feedback save(Feedback feedback){
        return feedbackRepository.save(feedback);
    }
}
