package peaksoft.airbnb_j.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import peaksoft.airbnb_j.dto.announcement.AnnouncementResponseCard;
import peaksoft.airbnb_j.models.Announcement;

import java.util.List;

public interface AnnouncementRepository extends JpaRepository<Announcement, Long> {


    @Query("select a from Announcement a where a.houseType = 0 order by COUNT(a.feedbacks)")
    List<Announcement> findAllApartments();

    @Query("select a from  Announcement a where a.houseType = 1 order by COUNT(a.feedbacks)")
    List<Announcement> findAllHouses();

    @Query("select a from Announcement a order by a.createdAt")
    List<Announcement> findLastestAnn();
}