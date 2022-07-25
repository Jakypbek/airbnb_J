package peaksoft.airbnb_j.dto.announcement;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;
import peaksoft.airbnb_j.models.Address;
import peaksoft.airbnb_j.models.Image;
import peaksoft.airbnb_j.models.enums.Status;
import peaksoft.airbnb_j.models.enums.Type;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Getter@Setter
public class AnnouncementRequest {

    private String title;
    private String description;
    private BigDecimal price;
    private Integer maxGuests;
    private Type houseType;
    private String region;
    private String town;
    private String address;
}
