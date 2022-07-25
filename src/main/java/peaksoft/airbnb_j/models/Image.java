package peaksoft.airbnb_j.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "images")
@NoArgsConstructor
@Getter
@Setter
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "image_id_generator")
    @SequenceGenerator(name = "image_id_generator", sequenceName = "image_seq", allocationSize = 1)
    private Long id;

    private String name;
    private String originalFileName;
    private Long size;
    private String contentType;
    private boolean isPreviewImage;
    @Lob
    private byte[] bytes;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH},
            fetch = FetchType.LAZY)
    private Announcement announcement;
}
