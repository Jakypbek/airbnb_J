package peaksoft.airbnb_j.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import peaksoft.airbnb_j.models.Feedback;

import java.util.List;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
}