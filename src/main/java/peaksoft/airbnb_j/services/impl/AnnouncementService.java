package peaksoft.airbnb_j.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import peaksoft.airbnb_j.dto.announcement.AnnouncementRequest;
import peaksoft.airbnb_j.dto.announcement.AnnouncementResponse;
import peaksoft.airbnb_j.dto.announcement.AnnouncementResponseCard;
import peaksoft.airbnb_j.mapper.announcement.AnnouncementEditMapper;
import peaksoft.airbnb_j.mapper.announcement.AnnouncementViewMapper;
import peaksoft.airbnb_j.models.Address;
import peaksoft.airbnb_j.models.Announcement;
import peaksoft.airbnb_j.models.Feedback;
import peaksoft.airbnb_j.models.Image;
import peaksoft.airbnb_j.repositories.AnnouncementRepository;

import java.io.IOException;
import java.util.*;

@RequiredArgsConstructor
@Service
public class AnnouncementService implements peaksoft.airbnb_j.services.AnnouncementService {

    private final AnnouncementRepository repository;
    private final AnnouncementEditMapper editMapper;
    private final AnnouncementViewMapper viewMapper;

    public AnnouncementResponse create(
            AnnouncementRequest request,
            MultipartFile file1, MultipartFile file2,
            MultipartFile file3, MultipartFile file4) throws IOException {
        Announcement announcement = editMapper.create(request);
        Image image1;
        Image image2;
        Image image3;
        Image image4;

        if (file1.getSize() != 0) {
            image1 = toImageEntity(file1);
            image1.setPreviewImage(true);
            announcement.addImage(image1);
        }
        if (file2.getSize() != 0) {
            image2 = toImageEntity(file2);
            announcement.addImage(image2);
        }
        if (file3.getSize() != 0) {
            image3 = toImageEntity(file3);
            announcement.addImage(image3);
        }
        if (file4.getSize() != 0) {
            image4 = toImageEntity(file4);
            announcement.addImage(image4);
        }
        Announcement announcementFromDB = repository.save(announcement);
        announcementFromDB.setPreviewImageId(announcementFromDB.getImages().get(0).getId());
        repository.save(announcement);
        return viewMapper.viewFullAnnouncement(announcement);
    }

    private Image toImageEntity(MultipartFile file1)  throws IOException {
        Image image = new Image();
        image.setName(file1.getName());
        image.setOriginalFileName(file1.getOriginalFilename());
        image.setContentType(file1.getContentType());
        image.setSize(file1.getSize());
        image.setBytes(file1.getBytes());
        return image;
    }

    public AnnouncementResponse update(long id, AnnouncementRequest request) {
        Announcement announcement = repository.findById(id).get();
        editMapper.update(announcement, request);
        repository.save(announcement);
        return viewMapper.viewFullAnnouncement(announcement);

    }

    public AnnouncementResponse findById(long id) {
        Announcement announcement = repository.findById(id).get();
        return viewMapper.viewFullAnnouncement(announcement);
    }

    public AnnouncementResponse deleteById(long id) {
        Announcement announcement = repository.findById(id).get();
        repository.deleteById(id);
        return viewMapper.viewFullAnnouncement(announcement);

    }

    public List<AnnouncementResponse> getAllAnn() {
        List<Announcement> announcements = repository.findAll();
        return viewMapper.view(announcements);
    }

    public List<AnnouncementResponseCard> findPopularApartments() {
        List<Announcement> apartments = repository.findAllApartments();
        return viewMapper.viewCard(apartments);
    }
    public List<AnnouncementResponseCard> findPopularHouses() {
        List<Announcement> houses = repository.findAllHouses();
        return viewMapper.viewCard(houses);
    }

    public List<AnnouncementResponseCard> findLastestAnn() {
        List<Announcement> lastestAnn = repository.findLastestAnn();
        return viewMapper.viewCard(lastestAnn);
    }

    public List<AnnouncementResponseCard> getAnnByAddress(String address) {
        List<Announcement> announcements = repository.findAll();

        Set<Announcement> finish = new LinkedHashSet<>();


        String[] result = address.split(" ", 2);
        String first = result[0];
        String rest = result[1];

        String[] result2 = rest.split(" ", 2);
        String second = result2[0];
        String rest2 = result2[1];

        String[] result3 = rest2.split(" ", 2);
        String third = result3[0];

        String s;

        for (Announcement a: announcements) {
            s = a.getLocation()
                            .getRegion()
                            .getRegionName() + ", " +
                            a.getLocation()
                                    .getTownProvince() + ", " +
                            a.getLocation().getAddress();

                if (s.toLowerCase(Locale.ROOT).contains(first.toLowerCase(Locale.ROOT))) {
                    finish.add(a);
                }
        }

        for (Announcement a: announcements) {
            s = a.getLocation()
                    .getRegion()
                    .getRegionName() + ", " +
                    a.getLocation()
                            .getTownProvince() + ", " +
                    a.getLocation().getAddress();

            if (s.toLowerCase(Locale.ROOT).contains(second.toLowerCase(Locale.ROOT))) {
                finish.add(a);
            }
        }

        for (Announcement a: announcements) {
            s = a.getLocation()
                    .getRegion()
                    .getRegionName() + ", " +
                    a.getLocation()
                            .getTownProvince() + ", " +
                    a.getLocation().getAddress();

            if (s.toLowerCase(Locale.ROOT).contains(third.toLowerCase(Locale.ROOT))) {
                finish.add(a);
            }
        }
        List<Announcement> announcements1 = new ArrayList<>(finish);
        return viewMapper.viewCard(announcements1);
    }
}
