package peaksoft.airbnb_j.dto.announcement;

import lombok.Getter;
import lombok.Setter;
import peaksoft.airbnb_j.models.Image;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class AnnouncementResponseCard {

    private String description;
    private List<Image> images = new ArrayList<>();
    private BigDecimal price;
    private Integer maxGuests;
    private String location;
    private double rating;
}
