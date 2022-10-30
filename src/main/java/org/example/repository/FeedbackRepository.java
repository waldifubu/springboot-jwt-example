package org.example.repository;

import org.example.model.Feedback;
import org.example.model.Tutorial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
//    List<Tutorial> findByPublished(boolean published);

//    List<Tutorial> findByTitleContaining(String title);
}
