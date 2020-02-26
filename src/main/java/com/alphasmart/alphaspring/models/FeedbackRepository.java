package com.alphasmart.alphaspring.models;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface FeedbackRepository extends CrudRepository<Feedback, Long> {
    Optional<List<Feedback>> findFeedbacksByEmail(String email);
}
