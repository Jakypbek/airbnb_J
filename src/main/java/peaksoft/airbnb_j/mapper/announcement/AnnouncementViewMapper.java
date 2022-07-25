package peaksoft.airbnb_j.mapper.announcement;

import org.springframework.stereotype.Component;
import peaksoft.airbnb_j.dto.announcement.AnnouncementResponse;
import peaksoft.airbnb_j.dto.announcement.AnnouncementResponseCard;
import peaksoft.airbnb_j.models.Announcement;
import peaksoft.airbnb_j.models.Feedback;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Component
public class AnnouncementViewMapper {
    public AnnouncementResponse viewFullAnnouncement(Announcement announcement) {

        if (announcement == null) {
            return null;
        }

        AnnouncementResponse response = new AnnouncementResponse();
        response.setId(announcement.getId());
        response.setTitle(announcement.getTitle());
        response.setDescription(announcement.getDescription());
        response.setPreviewImageId(announcement.getPreviewImageId());
        String s = announcement.getStatus().toString();
        s = s.substring(0, 1).toUpperCase() + s.substring(1);
        response.setStatus(s);
        response.setPrice(announcement.getPrice());
        response.setMaxGuests(announcement.getMaxGuests());
        String ht = announcement.getHouseType().toString();
        ht = ht.substring(0, 1).toUpperCase() + ht.substring(1);
        response.setHouseType(ht);
        response.setLocation(announcement.getLocation().getAddress() + ", " +
                announcement.getLocation().getTownProvince() + ", " +
                announcement.getLocation().getRegion().getRegionName());
        response.setCreatedAt(announcement.getCreatedAt().toString());
        response.setImages(announcement.getImages());
        double a = 0;
        double b = 0;
        for (Feedback f: announcement.getFeedbacks()) {
            a = a + f.getRating();
            b ++;
        }
        double rating = a / b;
        response.setRating(rating);

        return response;
    }

    public List<AnnouncementResponse> view(List<Announcement> announcements){
        List<AnnouncementResponse> responses = new ArrayList<>();
        for (Announcement announcement : announcements){
            responses.add(viewFullAnnouncement(announcement));
        }
        return responses;
    }

    public AnnouncementResponseCard viewCardAnnouncement(Announcement announcement) {

        if (announcement == null) {
            return null;
        }

        AnnouncementResponseCard response = new AnnouncementResponseCard();
        response.setDescription(announcement.getDescription());
        response.setPrice(announcement.getPrice());
        response.setMaxGuests(announcement.getMaxGuests());
        response.setLocation(announcement.getLocation().getAddress() + ", " +
                announcement.getLocation().getTownProvince() + ", " +
                announcement.getLocation().getRegion().getRegionName());
        response.setImages(announcement.getImages());
        double a = 0;
        double b = 0;
        for (Feedback f: announcement.getFeedbacks()) {
            a = a + f.getRating();
            b ++;
        }
        double rating = a / b;
        response.setRating(rating);
        return response;
    }

    public List<AnnouncementResponseCard> viewCard(List<Announcement> announcements){
        List<AnnouncementResponseCard> responses = new ArrayList<>();
        for (Announcement announcement : announcements){
            responses.add(viewCardAnnouncement(announcement));
        }
        return responses;
    }
}
