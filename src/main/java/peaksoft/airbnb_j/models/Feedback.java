package peaksoft.airbnb_j.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import peaksoft.airbnb_j.models.auth.User;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

import static javax.persistence.CascadeType.*;
import static javax.persistence.FetchType.EAGER;
import static javax.persistence.FetchType.LAZY;

/**
 * @author Muhammed Toichubai
 */
@Entity
@Table(name = "feedbacks")
@NoArgsConstructor
@Getter
@Setter
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "feedback_id_generator")
    @SequenceGenerator(name = "feedback_id_generator", sequenceName = "feedback_seq", allocationSize = 1)
    private Long id;

    @ManyToOne(cascade = {REFRESH, PERSIST, DETACH, MERGE}, fetch = EAGER)
    private User owner;

    @ElementCollection
    private List<String> images;

    private String description;

    @Column(name = "likes")
    private Integer like;


    private Integer dislike;

    private Double rating;

    @ManyToOne(cascade = ALL, fetch = LAZY)
    private Announcement announcement;

    private LocalDate createdAt;
}
