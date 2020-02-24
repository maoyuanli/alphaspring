package com.alphasmart.alphaspring.controllers;

import com.alphasmart.alphaspring.models.Feedback;
import com.alphasmart.alphaspring.models.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class FeedbackController {
    @Autowired
    FeedbackRepository feedbackRepository;

    @PostMapping("api/feedback")
    public Feedback handleFeedback(@RequestBody Feedback feedback){
        return feedbackRepository.save(feedback);
    }
}
