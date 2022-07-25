package peaksoft.airbnb_j.mapper.announcement;

import org.springframework.stereotype.Component;
import peaksoft.airbnb_j.dto.announcement.AnnouncementRequest;
import peaksoft.airbnb_j.models.Address;
import peaksoft.airbnb_j.models.Announcement;
import peaksoft.airbnb_j.models.Region;
import peaksoft.airbnb_j.models.enums.Status;
import peaksoft.airbnb_j.repositories.RegionRepository;

import java.time.LocalDate;

@Component
public class AnnouncementEditMapper {

    private final RegionRepository regionRepository;

    public AnnouncementEditMapper(RegionRepository regionRepository) {
        this.regionRepository = regionRepository;
    }

    public Announcement create(AnnouncementRequest request){

        if (request == null){
            return null;
        }

        Announcement announcement = new Announcement();
        announcement.setTitle(request.getTitle());
        announcement.setDescription(request.getDescription());
        announcement.setStatus(Status.NEW);
        announcement.setPrice(request.getPrice());
        announcement.setMaxGuests(request.getMaxGuests());
        announcement.setHouseType(request.getHouseType());
        announcement.setCreatedAt(LocalDate.now());

        Address address = new Address();
        for (Region region: regionRepository.findAll()) {
            if (region.getRegionName().equals(request.getRegion())) {
                address.setRegion(region);
            }
        }
        address.setTownProvince(request.getTown());
        address.setAddress(request.getAddress());
        announcement.setLocation(address);
        address.setAnnouncement(announcement);
        return announcement;
    }


    public void update(Announcement announcement, AnnouncementRequest request){

        announcement.setTitle(request.getTitle());
        announcement.setDescription(request.getDescription());
        announcement.setStatus(Status.NEW);
        announcement.setPrice(request.getPrice());
        announcement.setMaxGuests(request.getMaxGuests());
        announcement.setHouseType(request.getHouseType());
        announcement.setCreatedAt(LocalDate.now());

        Address address = new Address();
        for (Region region: regionRepository.findAll()) {
            if (region.getRegionName().equals(request.getRegion())) {
                address.setRegion(region);
            }
        }
        address.setTownProvince(request.getTown());
        address.setAddress(request.getAddress());
        announcement.setLocation(address);
        address.setAnnouncement(announcement);
    }
}
