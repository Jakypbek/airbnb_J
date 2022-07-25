package peaksoft.airbnb_j.apis;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import peaksoft.airbnb_j.dto.announcement.AnnouncementRequest;
import peaksoft.airbnb_j.dto.announcement.AnnouncementResponse;
import peaksoft.airbnb_j.dto.announcement.AnnouncementResponseCard;
import peaksoft.airbnb_j.services.impl.FeedbackService;
import peaksoft.airbnb_j.services.impl.AddressService;
import peaksoft.airbnb_j.services.impl.AnnouncementService;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/main")
public class MainPagee {

    private final AnnouncementService announcementService;
    private final AddressService addressService;

    @PostMapping
    public AnnouncementResponse create(
            @RequestBody AnnouncementRequest request,
            @RequestParam("file1") MultipartFile file1,
            @RequestParam("file2") MultipartFile file2,
            @RequestParam("file3")  MultipartFile file3,
            @RequestParam("file4")  MultipartFile file4
    ) throws IOException {
        return announcementService.create(request, file1, file2, file3, file4);
    }

    @GetMapping("/search/{region}")
    public List<AnnouncementResponseCard> getByRegion(@PathVariable String region) {
        return addressService.getAnnByRegion(region);
    }

    @GetMapping("/search/p/a")
    public List<AnnouncementResponseCard> getPopularApartments() {
        return announcementService.findPopularApartments();
    }

    @GetMapping("/search/p/h")
    public List<AnnouncementResponseCard> getPopularHouses() {
        return announcementService.findPopularHouses();
    }

    @GetMapping("/search/l")
    public List<AnnouncementResponseCard> getLastestAnn() {
        return announcementService.findLastestAnn();
    }

    @GetMapping("/search/{address}")
    public List<AnnouncementResponseCard> getAnnBySearch(@PathVariable String address) {
        return announcementService.getAnnByAddress(address);
    }
}
