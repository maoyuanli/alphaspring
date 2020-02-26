package com.alphasmart.alphaspring.models;

import com.alphasmart.alphaspring.AlphaspringApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ContextConfiguration(classes = AlphaspringApplication.class)
@RunWith(SpringRunner.class)
@DataJpaTest
public class FeedbackRepositoryIntegrationTest {
    @Autowired
    FeedbackRepository feedbackRepository;

    @Test
    public void ifNewFeedbackSaved_thenSuccess(){
        Feedback feedback = new Feedback("John Doe","jd@gmail.com","405-909-2934","good job");
        feedbackRepository.save(feedback);
        List<Feedback> feedbacks = (List<Feedback>) feedbackRepository.findAll();
        assertEquals(4,feedbacks.size());
        Optional<List<Feedback>> jennyFeedbacks = feedbackRepository
                .findFeedbacksByEmail("Jenny.H@bell.ca");
        assertEquals("Jenny",jennyFeedbacks.get().get(0).getName());
        Optional<List<Feedback>> johnFeedbacks = feedbackRepository
                .findFeedbacksByEmail("jd@gmail.com");
        assertEquals("405-909-2934",johnFeedbacks.get().get(0).getPhone());
    }
}
