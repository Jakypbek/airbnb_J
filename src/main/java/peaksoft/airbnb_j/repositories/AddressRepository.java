package peaksoft.airbnb_j.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import peaksoft.airbnb_j.models.Address;
import peaksoft.airbnb_j.models.Announcement;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Long> {

    @Query("select a from Address a where a.region.regionName = :region")
    List<Address> getAddressByRegion(@Param("region") String region);

}