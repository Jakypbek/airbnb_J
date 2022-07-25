package peaksoft.airbnb_j.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import peaksoft.airbnb_j.models.auth.User;
import peaksoft.airbnb_j.models.enums.Status;

import javax.persistence.*;
import java.time.LocalDate;

import static javax.persistence.CascadeType.*;

/**
 * @author Muhammed Toichubai
 */

@Entity
@Table(name = "bookings")
@NoArgsConstructor
@Getter
@Setter
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "booking_id_generator")
    @SequenceGenerator(name = "booking_id_generator", sequenceName = "booking_seq", allocationSize = 1)
    private Long id;

    @ManyToOne(cascade = {DETACH, MERGE, PERSIST, REFRESH}, fetch = FetchType.LAZY)
    private User user;

    @ManyToOne(cascade = {DETACH, MERGE, PERSIST, REFRESH}, fetch = FetchType.EAGER)
    private Announcement announcement;

    private LocalDate checkin;

    private LocalDate checkout;

    private Status status;

    private LocalDate createdAt;
}
