package peaksoft.airbnb_j.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.airbnb_j.dto.announcement.AnnouncementResponse;
import peaksoft.airbnb_j.dto.announcement.AnnouncementResponseCard;
import peaksoft.airbnb_j.mapper.announcement.AnnouncementViewMapper;
import peaksoft.airbnb_j.models.Address;
import peaksoft.airbnb_j.models.Announcement;
import peaksoft.airbnb_j.repositories.AddressRepository;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class AddressService {

    private final AddressRepository repository;
    private final AnnouncementViewMapper viewMapper;

    public List<AnnouncementResponseCard> getAnnByRegion(String region) {
        List<Address> addressByRegion = repository.getAddressByRegion(region);
        List<AnnouncementResponseCard> announcementResponses = new ArrayList<>();
        for (Address a: addressByRegion) {
            announcementResponses.add(viewMapper.viewCardAnnouncement(a.getAnnouncement()));
        }
        return announcementResponses;
    }

    public List<Address> getAllAddresses() {
        return repository.findAll();
    }

}
