package peaksoft.airbnb_j.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import peaksoft.airbnb_j.models.auth.User;
import peaksoft.airbnb_j.models.enums.Status;
import peaksoft.airbnb_j.models.enums.Type;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.*;
import static javax.persistence.FetchType.EAGER;
import static javax.persistence.FetchType.LAZY;

@Entity
@Table(name = "announcements")
@NoArgsConstructor
@Getter
@Setter
public class Announcement {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "announcement_id_generator")
    @SequenceGenerator(name = "announcement_id_generator", sequenceName = "announcement_seq", allocationSize = 1)
    private Long id;

    private String title;

    private String description;

    @OneToMany(cascade = ALL, fetch = LAZY, mappedBy = "announcement")
    private List<Image> images = new ArrayList<>();
    private Long previewImageId;

    private Status status;

    private BigDecimal price;

    @OneToMany(cascade = ALL, mappedBy = "announcement", fetch = EAGER)
    private List<Feedback> feedbacks = new ArrayList<>();

    private Integer maxGuests;

    private Type houseType;

    @ManyToOne(cascade = {DETACH, MERGE, PERSIST, REFRESH}, fetch = EAGER)
    private User owner;

    @OneToOne(cascade = ALL, fetch = LAZY, mappedBy = "announcement")
    private Address location;

    @ManyToMany(cascade = ALL,
            fetch = EAGER)
    private List<User> guests;

    @OneToMany(cascade = ALL, mappedBy = "announcement", fetch = LAZY)
    private List<Booking> bookings;

    private LocalDate createdAt;

    public void addImage(Image image) {
        image.setAnnouncement(this);
        this.images.add(image);
    }
}
