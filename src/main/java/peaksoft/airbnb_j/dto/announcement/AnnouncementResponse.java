package peaksoft.airbnb_j.dto.announcement;

import lombok.Getter;
import lombok.Setter;
import peaksoft.airbnb_j.models.Address;
import peaksoft.airbnb_j.models.Booking;
import peaksoft.airbnb_j.models.Feedback;
import peaksoft.airbnb_j.models.Image;
import peaksoft.airbnb_j.models.auth.User;
import peaksoft.airbnb_j.models.enums.Status;
import peaksoft.airbnb_j.models.enums.Type;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
public class AnnouncementResponse {

    private Long id;
    private String title;
    private String description;
    private List<Image> images = new ArrayList<>();
    private Long previewImageId;
    private String status;
    private BigDecimal price;
    private Integer maxGuests;
    private String houseType;
    private String location;
    private double rating;
    private String createdAt;
}
