package com.alphasmart.alphaspring.controllers;

import com.alphasmart.alphaspring.entities.Feedback;
import com.alphasmart.alphaspring.services.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class FeedbackController {

    private FeedbackService feedbackService;

    @Autowired
    public FeedbackController(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }

    @PostMapping("api/feedback")
    public ResponseEntity handleFeedback(@RequestBody Feedback feedback) {
        feedbackService.save(feedback);
        String successFeedback = String.format("{ \"success\": \"Feedback created successfully: %s | %s | %s | %s\"}"
                , feedback.getName(), feedback.getEmail(), feedback.getPhone(), feedback.getComment());

        return new ResponseEntity<>(successFeedback, HttpStatus.OK);
    }
}
