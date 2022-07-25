package peaksoft.airbnb_j.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.airbnb_j.dto.announcement.AnnouncementResponseCard;
import peaksoft.airbnb_j.models.Feedback;
import peaksoft.airbnb_j.repositories.FeedbackRepository;

import java.util.List;
@RequiredArgsConstructor
@Service
public class FeedbackService implements peaksoft.airbnb_j.services.FeedbackService {

    private final FeedbackRepository repository;

}
