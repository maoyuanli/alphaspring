package com.alphasmart.alphaspring.repositories;

import com.alphasmart.alphaspring.entities.Feedback;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class FeedbackRepositoryIntegrationTest {

    @Autowired
    FeedbackRepository feedbackRepository;

    @Test
    public void ifNewFeedbackSaved_thenSuccess(){
        Feedback feedback = new Feedback("John Doe","jd@gmail.com","405-909-2934","good job");
        feedbackRepository.save(feedback);
        assertEquals(4,((List<Feedback>) feedbackRepository.findAll()).size()); // initialized 3 in data.sql
        Optional<List<Feedback>> jennyFeedbacks = feedbackRepository
                .findFeedbacksByEmail("Jenny.H@bell.ca");
        assert jennyFeedbacks.isPresent();
        assertEquals("Jenny",jennyFeedbacks.get().get(0).getName());
        Optional<List<Feedback>> johnFeedbacks = feedbackRepository
                .findFeedbacksByEmail("jd@gmail.com");
        assert johnFeedbacks.isPresent();
        assertEquals("405-909-2934",johnFeedbacks.get().get(0).getPhone());
    }
}
