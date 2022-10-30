package org.example.controller;

import org.example.model.Feedback;
import org.example.model.Tutorial;
import org.example.repository.FeedbackRepository;
import org.example.repository.TutorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class FeedbackController {
    @Autowired
    FeedbackRepository feedbackRepository;

    @GetMapping("/feedback")
    public ResponseEntity<List<Feedback>> getAllFeedbacks(@RequestParam(required = false) String title) {
        try {

            List<Feedback> feedbacks = new ArrayList<Feedback>(feedbackRepository.findAll());

            return new ResponseEntity<>(feedbacks, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/feedback/{id}")
    public ResponseEntity<Feedback> getTutorialById(@PathVariable("id") long id) {
        Optional<Feedback> feedbackData = feedbackRepository.findById(id);

        return feedbackData.map(feedback -> new ResponseEntity<>(feedback, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}
