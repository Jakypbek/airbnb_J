package peaksoft.airbnb_j.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import peaksoft.airbnb_j.models.Region;

public interface RegionRepository extends JpaRepository<Region, Long> {
}