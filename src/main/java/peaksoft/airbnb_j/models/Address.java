package peaksoft.airbnb_j.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.CascadeType.*;
import static javax.persistence.FetchType.LAZY;

/**
 * @author Muhammed Toichubai
 */
@Entity
@Table(name = "addresses")
@NoArgsConstructor
@Getter
@Setter
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_id_generator")
    @SequenceGenerator(name = "address_id_generator", sequenceName = "address_seq", allocationSize = 1)
    private Long id;

    @ManyToOne(cascade = ALL, fetch = LAZY)
    private Region region;

    private String townProvince;

    private String address;

    @OneToOne(cascade = {DETACH, REFRESH, PERSIST, MERGE}, fetch = FetchType.LAZY)
    private Announcement announcement;


}
